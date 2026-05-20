# Build Notes

This repository was reconstructed from the patched NeoForge distribution jar for `create_mf`.

The layout is now a normal Gradle/NeoForge-style source tree:

```text
src/main/java
src/main/resources
```

## Important status

This is recovered/decompiled source, not the original MCreator workspace. The code is intentionally kept close to CFR output so behavior can be audited against the shipped jar.

Expected remaining work before treating this as a fully native source repo:

1. Run a Gradle compile with NeoForge 21.1.222 / Minecraft 1.21.1.
2. Fix any decompiler-only type/import issues that appear.
3. Only then start cosmetic Java cleanup.
4. Keep checking against the shipped jar using `scripts/verify_recovery.py`.

## Recommended first build command

```powershell
./gradlew build
```

If no Gradle wrapper is present yet, either install Gradle locally or generate the wrapper from a trusted Gradle install.

## Patch class

The added TradeGuard patch is here:

```text
src/main/java/net/mcreator/create_mf/init/CmfTradeGuard.java
```

The patched Postman trade registration is here:

```text
src/main/java/net/mcreator/create_mf/init/PostManTrade.java
```
