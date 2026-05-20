# Create: More Features Patched Unofficial

Recovered GitHub-ready source tree for the unofficial patched NeoForge 1.21.1 build of Create: More Features.

## Status

This is a recovered source repository created from the patched runtime jar. It is intended for auditing, cleanup, and eventually rebuilding the patch properly from source.

## Main patch files

```text
src/main/java/net/mcreator/create_mf/init/CmfTradeGuard.java
src/main/java/net/mcreator/create_mf/init/PostManTrade.java
```

## Layout

```text
src/main/java        Decompiled Java source
src/main/resources   Runtime assets, data, and mod metadata
scripts              Verification/helper scripts
docs                 Generated audit notes
reference            File/class inventories from the original patched jar
```

## Notes

The source is intentionally conservative. Runtime resources were preserved from the patched jar, and decompiled Java was not broadly rewritten yet. Build cleanup should happen one compile error at a time.
