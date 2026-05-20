package net.mcreator.create_mf.procedures;

import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.create_mf.network.CreateMfModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FlyingBlockProcedureProcedure {
	@SubscribeEvent
	public static void onEntityTick(EntityTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Object event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getData(CreateMfModVariables.PLAYER_VARIABLES).fly) == true && !checkGamemode(entity)) {
			if (entity instanceof Player _player)
				_player.getAbilities().mayfly = true;
		} else {
			if (entity instanceof Player _player)
				_player.getAbilities().mayfly = false;
		}
	}

	private static boolean checkGamemode(Entity _ent) {
		if (_ent instanceof ServerPlayer _serverPlayer) {
			return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
		}
		return false;
	}
}
