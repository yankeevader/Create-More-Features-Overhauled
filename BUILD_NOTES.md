# Build Notes

## Environment

- Minecraft 1.21.1
- NeoForge 21.1.x
- Java 21
- Gradle Wrapper Included

## Building

Windows:

```bash
gradlew.bat build
```

Linux:

```bash
./gradlew build
```

## Output

Compiled jars are generated in:

```text
build/libs/
```

## Repository Notes

This repository contains the cleaned NeoForge 1.21.1 patched source branch.

Generated files, Gradle cache directories, and temporary runtime directories are intentionally excluded from version control.

## Patch Goal

Maintain compatibility and stability for Create: More Features on modern NeoForge environments while preserving original gameplay behavior wherever possible.
