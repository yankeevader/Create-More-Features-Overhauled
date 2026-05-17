Create: More Features 0.9.69 - Unofficial patched test build

Changes:
- Replaced GravitronprocedureProcedure with safer flight ownership logic.
  - Tracks UUIDs whose mayfly permission was granted by the Gravitron.
  - Only revokes flight if the Gravitron granted it.
  - Does not wipe mayfly from other mods' flight systems.
  - Hunger/durability/particles only tick while the player is actually flying.
  - Avoids creative/spectator flight interference.
- Replaced stale data resource references from create_more_features: to create_mf: in data JSON files.

Notes:
- Original mod by Daniil_White / Tamlighter.
- Original license: Academic Free License v3.0.
- This is an unofficial community patch test build, not an official release.
