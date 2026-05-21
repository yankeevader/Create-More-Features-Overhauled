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
public class PostManTrade {
    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.POSTMAN.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.PAPER, 24), new ItemStack((ItemLike) Items.EMERALD), 16, 2, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), PostManTrade.createItem("clipboard", 1), 10, 2, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.INK_SAC, 8), new ItemStack((ItemLike) Items.EMERALD), 16, 4, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 1), PostManTrade.createItem("empty_schematic", 4), 12, 4, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), PostManTrade.createItem("schematic_and_quill", 1), 10, 5, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.FEATHER, 8), new ItemStack((ItemLike) Items.EMERALD), 16, 6, 0.04f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), PostManTrade.createItem("schematic_table", 1), 10, 6, 0.04f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), PostManTrade.createItem("package_filter", 1), 12, 6, 0.04f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 10), PostManTrade.createItem("packager", 1), 8, 8, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 12), PostManTrade.createItem("repackager", 1), 8, 8, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), PostManTrade.createItem("package_frogport", 1), 8, 8, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 18), PostManTrade.createItem("stock_link", 1), 6, 10, 0.06f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 22), PostManTrade.createItem("stock_ticker", 1), 6, 10, 0.06f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), PostManTrade.createItem("schedule", 1), 12, 10, 0.06f));
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
