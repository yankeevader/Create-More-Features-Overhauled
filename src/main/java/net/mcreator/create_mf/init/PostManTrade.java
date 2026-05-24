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
    public static void registerPostManTrade(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.POSTMAN.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(PostManTrade.createItem("package_frogport", 1), new ItemStack((ItemLike) Items.EMERALD, 2), 18, 3, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), PostManTrade.createItem("stock_link", 1), 16, 3, 0.02f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(PostManTrade.createItem("package", 8), new ItemStack((ItemLike) Items.EMERALD), 16, 4, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), PostManTrade.createItem("postbox", 1), 14, 4, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 7), PostManTrade.createItem("mailbox", 1), 12, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), PostManTrade.createItem("packager", 1), 10, 5, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 10), PostManTrade.createItem("redstone_requester", 1), 10, 7, 0.04f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 9), PostManTrade.createItem("content_observer", 1), 10, 7, 0.04f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), PostManTrade.createItem("factory_gauge", 1), 8, 9, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 12), PostManTrade.createItem("display_link", 1), 10, 9, 0.05f));
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
