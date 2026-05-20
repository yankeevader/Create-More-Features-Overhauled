#!/usr/bin/env python3
"""
Verify the recovered source tree against a reference patched jar.

Usage:
    python scripts/verify_recovery.py path/to/patched.jar

Checks:
    - every non-class runtime file from the jar exists under src/main/resources
    - every runtime resource is byte-for-byte identical
    - every class file maps to a decompiled Java file, including $ inner classes via outer source
"""
from __future__ import annotations

import hashlib
import sys
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
JAVA_ROOT = ROOT / "src" / "main" / "java"
RES_ROOT = ROOT / "src" / "main" / "resources"


def sha256(data: bytes) -> str:
    return hashlib.sha256(data).hexdigest()


def main() -> int:
    if len(sys.argv) != 2:
        print("Usage: python scripts/verify_recovery.py path/to/patched.jar", file=sys.stderr)
        return 2

    jar_path = Path(sys.argv[1]).expanduser().resolve()
    if not jar_path.exists():
        print(f"ERROR: jar not found: {jar_path}", file=sys.stderr)
        return 2

    java_sources = {}
    for path in JAVA_ROOT.rglob("*.java"):
        rel = path.relative_to(JAVA_ROOT).as_posix()
        class_base = rel[:-5]
        java_sources[class_base] = rel

    missing_resources: list[str] = []
    changed_resources: list[str] = []
    unmapped_classes: list[str] = []
    resource_count = 0
    class_count = 0

    with zipfile.ZipFile(jar_path) as jar:
        names = sorted(name for name in jar.namelist() if not name.endswith("/"))
        for name in names:
            if name.endswith(".class"):
                class_count += 1
                class_base = name[:-6]
                outer_base = class_base.split("$")[0]
                if outer_base not in java_sources:
                    unmapped_classes.append(name)
                continue

            resource_count += 1
            repo_path = RES_ROOT / name
            if not repo_path.exists():
                missing_resources.append(name)
                continue
            jar_hash = sha256(jar.read(name))
            repo_hash = sha256(repo_path.read_bytes())
            if jar_hash != repo_hash:
                changed_resources.append(name)

    print(f"Jar: {jar_path}")
    print(f"Runtime resources checked: {resource_count}")
    print(f"Class files checked: {class_count}")
    print(f"Java source files found: {len(java_sources)}")
    print(f"Missing resources: {len(missing_resources)}")
    print(f"Changed resources: {len(changed_resources)}")
    print(f"Unmapped classes: {len(unmapped_classes)}")

    if missing_resources:
        print("\nMissing resources:")
        print("\n".join(missing_resources))
    if changed_resources:
        print("\nChanged resources:")
        print("\n".join(changed_resources))
    if unmapped_classes:
        print("\nUnmapped classes:")
        print("\n".join(unmapped_classes))

    if missing_resources or changed_resources or unmapped_classes:
        return 1

    print("\nOK: recovered tree matches the jar resources and maps all class files to source.")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
