package net.mcreator.create_mf.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;

public class PlayerFlyRuleProcedure {
    public static void execute(Entity entity) {
        Player _player;
        if (entity == null) {
            return;
        }
        if (checkGamemode(entity, GameType.CREATIVE) && entity instanceof Player) {
            _player = (Player)entity;
            _player.getAbilities().mayfly = true;
            _player.onUpdateAbilities();
        }
        if (checkGamemode(entity, GameType.SPECTATOR) && entity instanceof Player) {
            _player = (Player)entity;
            _player.getAbilities().mayfly = true;
            _player.onUpdateAbilities();
        }
    }

    private static boolean checkGamemode(Entity _ent, GameType gameType) {
        if (_ent instanceof ServerPlayer) {
            ServerPlayer _serverPlayer = (ServerPlayer)_ent;
            return _serverPlayer.gameMode.getGameModeForPlayer() == gameType;
        }
        return false;
    }
}
