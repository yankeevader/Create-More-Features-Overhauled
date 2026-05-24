package net.mcreator.create_mf.init;

import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@EventBusSubscriber
public class PipefitterA {
    @SubscribeEvent
    public static void registerPipefitterA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.PIPEFITTER.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(PipefitterA.createItem("copper_sheet", 9), new ItemStack((ItemLike) Items.EMERALD), 20, 5, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD), PipefitterA.createItem("fluid_pipe", 8), 24, 5, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 6), PipefitterA.createItem("mechanical_pump", 1), 17, 5, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(PipefitterA.createItem("copper_valve_handle", 2), new ItemStack((ItemLike) Items.EMERALD), 15, 6, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), PipefitterA.createItem("copper_casing", 4), 27, 6, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), PipefitterA.createItem("item_drain", 1), 16, 6, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(PipefitterA.createItem("fluid_pipe", 13), new ItemStack((ItemLike) Items.EMERALD), 26, 7, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 6), PipefitterA.createItem("fluid_tank", 1), 27, 7, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 7), PipefitterA.createItem("spout", 1), 15, 7, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(PipefitterA.createItem("steam_whistle", 3), new ItemStack((ItemLike) Items.EMERALD), 18, 7, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 7), PipefitterA.createItem("copper_diving_helmet", 1), 7, 10, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), PipefitterA.createItem("copper_diving_boots", 1), 7, 10, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), PipefitterA.createItem("steam_engine", 1), 15, 7, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), PipefitterA.createItem("smart_fluid_pipe", 1), 18, 7, 0.05f));
    }

    private static ItemStack createItem(String string, int n) {
        ItemLike itemLike;
        if (n < 1) {
            n = 1;
        }
        if (n > 99) {
            n = 99;
        }
        if ((itemLike = (ItemLike) BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("create", string))) == Items.AIR) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(itemLike, n);
    }
}
