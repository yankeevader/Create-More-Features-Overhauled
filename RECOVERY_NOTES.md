# Recovery Notes

This source tree was recovered from the patched distribution jar using CFR.

## What is preserved

- Decompiled Java sources under `src/main/java`.
- Runtime resources under `src/main/resources`.
- NeoForge metadata from the jar, including `META-INF/neoforge.mods.toml`.
- Legacy/stale metadata files that were present in the jar, including `META-INF/mods.toml`, intentionally left untouched for traceability.
- Original asset/data paths and filenames.

## What this is not

This is not the original MCreator workspace and not the author's original development repository. Decompiled source can contain:

- redundant casts,
- rough generic types,
- synthetic inner-class reconstruction,
- ugly generated procedure code,
- missing comments/history.

## Cleanup policy

Until the repo successfully compiles, avoid broad cosmetic rewrites. Keep code close to decompiled output so changes remain easy to diff against the shipped jar.
