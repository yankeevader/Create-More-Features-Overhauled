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
public class SundriesSellerA {
    @SubscribeEvent
    public static void registerSundriesSellerA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.SUNDRIESSELLER.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 1), SundriesSellerA.createItem("chute", 1), 15, 1, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SundriesSellerA.createItem("clipboard", 1), 8, 1, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SundriesSellerA.createItem("sail_frame", 1), 16, 1, 0.01f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), SundriesSellerA.createItem("schematic_table", 1), 16, 3, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), SundriesSellerA.createItem("whisk", 1), 8, 3, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 1), SundriesSellerA.createItem("sand_paper", 1), 25, 3, 0.02f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SundriesSellerA.createItem("red_sand_paper", 1), 25, 3, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 7), SundriesSellerA.createItem("rose_quartz_lamp", 1), 16, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 32), SundriesSellerA.createItem("schematicannon", 1), 3, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), SundriesSellerA.createItem("attribute_filter", 1), 18, 5, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 16), SundriesSellerA.createItem("clockwork_bearing", 1), 5, 7, 0.04f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 20), SundriesSellerA.createItem("flywheel", 1), 5, 7, 0.04f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 36), SundriesSellerA.createItem("extendo_grip", 1), 1, 5, 0.04f));
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
