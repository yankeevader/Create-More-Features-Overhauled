package net.mcreator.create_mf.procedures;

import javax.annotation.Nullable;
import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber
public class FlyingBlockProcedureProcedure {
    @SubscribeEvent
    public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
        if (event.getHand() != event.getEntity().getUsedItemHand()) {
            return;
        }
        FlyingBlockProcedureProcedure.execute((Event)event, (LevelAccessor)event.getLevel(), (Entity)event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        FlyingBlockProcedureProcedure.execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        ItemStack itemStack;
        if (entity == null) {
            return;
        }
        if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            itemStack = _livEnt.getMainHandItem();
        } else {
            itemStack = ItemStack.EMPTY;
        }
        if (itemStack.getItem() == ((Block)CreateMfModBlocks.FLYING_BLOCK.get()).asItem() && world.getBlockState(BlockPos.containing((double)(entity.getX() + entity.getLookAngle().x + entity.getLookAngle().x + entity.getLookAngle().x), (double)(entity.getY() + entity.getLookAngle().y + entity.getLookAngle().y + entity.getLookAngle().y + 1.0), (double)(entity.getZ() + entity.getLookAngle().z + entity.getLookAngle().z + entity.getLookAngle().z))).getBlock() == Blocks.AIR) {
            world.setBlock(BlockPos.containing((double)(entity.getX() + entity.getLookAngle().x + entity.getLookAngle().x + entity.getLookAngle().x), (double)(entity.getY() + entity.getLookAngle().y + entity.getLookAngle().y + entity.getLookAngle().y + 1.0), (double)(entity.getZ() + entity.getLookAngle().z + entity.getLookAngle().z + entity.getLookAngle().z)), ((Block)CreateMfModBlocks.FLYING_BLOCK.get()).defaultBlockState(), 3);
            if (!new Object(){

                public boolean checkGamemode(Entity _ent) {
                    if (_ent instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)_ent;
                        return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
                    }
                    if (_ent.level().isClientSide() && _ent instanceof Player) {
                        Player _player = (Player)_ent;
                        return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
                    }
                    return false;
                }
            }.checkGamemode(entity) && entity instanceof Player) {
                Player _player = (Player)entity;
                ItemStack _stktoremove = new ItemStack((ItemLike)CreateMfModBlocks.FLYING_BLOCK.get());
                _player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, (Container)_player.inventoryMenu.getCraftSlots());
            }
        }
    }
}

