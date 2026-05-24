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
public class EngineerA {
    @SubscribeEvent
    public static void registerEngineerA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.ENGINEER.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(EngineerA.createItem("goggles", 1), new ItemStack((ItemLike) Items.EMERALD), 20, 2, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 6), EngineerA.createItem("brass_funnel", 1), 20, 2, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), EngineerA.createItem("brass_tunnel", 1), 20, 2, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), EngineerA.createItem("smart_chute", 1), 20, 2, 0.02f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(EngineerA.createItem("wrench", 1), new ItemStack((ItemLike) Items.EMERALD, 2), 25, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), EngineerA.createItem("redstone_link", 1), 10, 3, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 6), EngineerA.createItem("linked_controller", 1), 10, 3, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 10), EngineerA.createItem("precision_mechanism", 1), 16, 4, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), EngineerA.createItem("rotation_speed_controller", 1), 12, 5, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 9), EngineerA.createItem("sequenced_gearshift", 1), 16, 5, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), EngineerA.createItem("mechanical_arm", 1), 8, 5, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(EngineerA.createItem("flywheel", 1), new ItemStack((ItemLike) Items.EMERALD, 3), 12, 6, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), EngineerA.createItem("content_observer", 1), 14, 10, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 9), EngineerA.createItem("stockpile_switch", 1), 16, 10, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 18), EngineerA.createItem("wand_of_symmetry", 1), 8, 5, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 10), EngineerA.createItem("mechanical_crafter", 2), 10, 5, 0.05f));
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
