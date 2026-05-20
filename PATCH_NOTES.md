# Patch Notes

Unofficial patch work currently preserved in this recovered source tree:

- Added `net.mcreator.create_mf.init.CmfTradeGuard`.
- Updated villager trade registration paths to use guarded trade insertion.
- Confirmed `PostManTrade` was also switched to `CmfTradeGuard.safeAdd(...)`.
- Preserved original runtime resources and metadata from the patched jar.

The patch intentionally avoids editing Easy Villagers or any external mod. The guard belongs to this mod's trade registration path.
