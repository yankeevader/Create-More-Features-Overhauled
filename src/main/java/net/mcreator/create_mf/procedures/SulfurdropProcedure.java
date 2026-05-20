package net.mcreator.create_mf.procedures;

import javax.annotation.Nullable;
import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;

@EventBusSubscriber
public class SulfurdropProcedure {
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        SulfurdropProcedure.execute((Event)event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), (Entity)event.getPlayer());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        SulfurdropProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        ItemEntity entityToSpawn;
        ServerLevel _level;
        if (entity == null) {
            return;
        }
        if (checkGamemode(entity, GameType.SURVIVAL) && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == CreateMfModBlocks.SULFUR_BASALT_ORE.get()) {
            if (Math.random() < 0.7 && world instanceof ServerLevel) {
                _level = (ServerLevel)world;
                entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)CreateMfModItems.SULFUR.get()));
                entityToSpawn.setPickUpDelay(5);
                entityToSpawn.setUnlimitedLifetime();
                _level.addFreshEntity((Entity)entityToSpawn);
            }
            if (Math.random() < 0.2 && world instanceof ServerLevel) {
                _level = (ServerLevel)world;
                entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)CreateMfModItems.SULFUR.get()));
                entityToSpawn.setPickUpDelay(5);
                entityToSpawn.setUnlimitedLifetime();
                _level.addFreshEntity((Entity)entityToSpawn);
            }
        }
        if (checkGamemode(entity, GameType.SURVIVAL) && world.getBlockState(BlockPos.containing((double)x, (double)y, (double)z)).getBlock() == CreateMfModBlocks.SULFUR_ORE.get() && Math.random() < 0.4 && world instanceof ServerLevel) {
            _level = (ServerLevel)world;
            entityToSpawn = new ItemEntity((Level)_level, x, y, z, new ItemStack((ItemLike)CreateMfModItems.SULFUR.get()));
            entityToSpawn.setPickUpDelay(5);
            entityToSpawn.setUnlimitedLifetime();
            _level.addFreshEntity((Entity)entityToSpawn);
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
