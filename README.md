# Create: More Features Patched Unofficial

Unofficial compatibility and stability patch for Create: More Features on NeoForge 1.21.1.

This project preserves the original gameplay and design intentions of Create: More Features while addressing compatibility, stability, and unfinished content issues encountered on modern Create 6 based NeoForge environments.

## Goals

- Preserve original mod behavior
- Preserve existing worlds and profession IDs
- Improve compatibility with NeoForge 1.21.1
- Improve compatibility with Easy Villagers interactions
- Maintain Create 6 compatibility
- Improve multiplayer and dedicated server stability
- Clean up unfinished or placeholder villager content
- Provide a clean, buildable source repository for server owners and pack developers

## Included Fixes

- Villager trade registration stability fixes
- Easy Villagers compatibility safeguards
- Create 6 schema cleanup and modernization
- Metadata and dependency cleanup
- Build system cleanup and modernization
- Safer Create item lookup handling
- Villager profession display name cleanup
- Villager trade balancing and progression cleanup
- Replacement of unfinished placeholder villager trades
- Create 6 logistics-themed Postman trade redesign
- Additional defensive trade validation through `CmfTradeGuard`

## Compatibility

- Minecraft 1.21.1
- NeoForge 21.1.x
- Create 6.0.x

## Notes

This is an unofficial patched maintenance branch.

Original mod authors retain full credit for the original project and design.

This repository exists to preserve compatibility and stability for modern NeoForge modpacks and servers while keeping the original Create: More Features identity intact.

## Original Authors

- Daniil_White
- Tamlighter

## Unofficial Patch Maintenance

- Yankeevader

## Issues

Please report issues here:

https://github.com/yankeevader/Create-More-Features-Patched-Unofficial/issues

## License

Academic Free License v3.0

Original project rights belong to the original authors.

## Building

```bash
./gradlew build
