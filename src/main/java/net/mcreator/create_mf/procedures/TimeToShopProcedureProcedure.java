package net.mcreator.create_mf.procedures;

import javax.annotation.Nullable;
import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber
public class TimeToShopProcedureProcedure {
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        TimeToShopProcedureProcedure.execute((Event)event, (Entity)event.getEntity());
    }

    public static void execute(Entity entity) {
        TimeToShopProcedureProcedure.execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        Player _playerHasItem;
        Player _playerHasItem2;
        Player _playerHasItem3;
        Player _playerHasItem4;
        Player _playerHasItem5;
        Player _playerHasItem6;
        Player _playerHasItem7;
        Player _playerHasItem8;
        Player _playerHasItem9;
        Player _playerHasItem10;
        if (entity == null) {
            return;
        }
        if ((entity instanceof Player && (_playerHasItem10 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.SUNDRIES_TABLE.get())) || entity instanceof Player && (_playerHasItem9 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.WORKSHOPS.get())) || entity instanceof Player && (_playerHasItem8 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.PIPE_TABLE.get())) || entity instanceof Player && (_playerHasItem7 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.CONTRAPTIONS_TABLE.get())) || entity instanceof Player && (_playerHasItem6 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.ENGINEERS_DESK.get())) || entity instanceof Player && (_playerHasItem5 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.MASTER_CONTRAPTIONS_TABLE.get())) || entity instanceof Player && (_playerHasItem4 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.SELLER_OF_MECHANISMS_TABLE.get())) || entity instanceof Player && (_playerHasItem3 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.BAYERS_TABLE.get())) || entity instanceof Player && (_playerHasItem2 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.LINEMAN_TABLE.get())) || entity instanceof Player && (_playerHasItem = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModBlocks.SHOWCASE.get()))) && entity instanceof ServerPlayer) {
            AdvancementProgress _ap;
            ServerPlayer _player = (ServerPlayer)entity;
            AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse((String)"create_mf:time_to_shop"));
            if (_adv != null && !(_ap = _player.getAdvancements().getOrStartProgress(_adv)).isDone()) {
                for (String criteria : _ap.getRemainingCriteria()) {
                    _player.getAdvancements().award(_adv, criteria);
                }
            }
        }
        if (entity instanceof Player && (_playerHasItem10 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModItems.SULFUR.get())) && entity instanceof Player && (_playerHasItem9 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModItems.COAL_PIN.get())) && entity instanceof Player && (_playerHasItem8 = (Player)entity).getInventory().contains(new ItemStack((ItemLike)CreateMfModItems.SALTPETER.get())) && entity instanceof ServerPlayer) {
            AdvancementProgress _ap;
            ServerPlayer _player = (ServerPlayer)entity;
            AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse((String)"create_mf:explosive_things"));
            if (_adv != null && !(_ap = _player.getAdvancements().getOrStartProgress(_adv)).isDone()) {
                for (String criteria : _ap.getRemainingCriteria()) {
                    _player.getAdvancements().award(_adv, criteria);
                }
            }
        }
    }
}

