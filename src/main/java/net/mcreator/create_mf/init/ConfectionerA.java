package net.mcreator.create_mf.init;

import java.util.List;
import net.mcreator.create_mf.init.CmfTradeGuard;
import net.mcreator.create_mf.init.CreateMfModVillagerProfessions;
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
public class ConfectionerA {
    @SubscribeEvent
    public static void registerConfectioner(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.CONFECTIONER.get()) {
            return;
        }
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(ConfectionerA.createItem("wheat_flour", 19), new ItemStack((ItemLike)Items.EMERALD), 18, 4, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(ConfectionerA.createItem("dough", 9), new ItemStack((ItemLike)Items.EMERALD), 16, 4, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), ConfectionerA.createItem("dough", 6), 15, 4, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), new ItemStack((ItemLike)Items.COOKIE, 9), 15, 4, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(ConfectionerA.createItem("cinder_flour", 29), new ItemStack((ItemLike)Items.EMERALD), 27, 5, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), ConfectionerA.createItem("sweet_roll", 3), 13, 5, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), new ItemStack((ItemLike)Items.BREAD, 7), 14, 5, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(ConfectionerA.createItem("blaze_cake_base", 5), new ItemStack((ItemLike)Items.EMERALD, 2), 12, 6, 0.04f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), ConfectionerA.createItem("chocolate_glazed_berries", 3), 11, 6, 0.04f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), ConfectionerA.createItem("honeyed_apple", 2), 14, 6, 0.04f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.GOLDEN_APPLE, 2), new ItemStack((ItemLike)Items.EMERALD), 17, 15, 0.05f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), ConfectionerA.createItem("bar_of_chocolate", 1), 13, 7, 0.05f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 2), ConfectionerA.createItem("builders_tea", 3), 13, 7, 0.05f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.CHORUS_FRUIT, 16), new ItemStack((ItemLike)Items.EMERALD), 18, 8, 0.06f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 9), ConfectionerA.createItem("blaze_cake", 1), 10, 8, 0.06f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 2), ConfectionerA.createItem("tree_fertilizer", 1), 25, 8, 0.06f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(ConfectionerA.createItem("blaze_cake_base", 1), new ItemStack((ItemLike)Items.EMERALD, 3), ConfectionerA.createItem("blaze_cake", 1), 8, 8, 0.06f));
    }

    private static ItemStack createItem(String string, int n) {
        ItemLike itemLike;
        if (n < 1) {
            n = 1;
        }
        if (n > 99) {
            n = 99;
        }
        if ((itemLike = (ItemLike)BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath((String)"create", (String)string))) == Items.AIR) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(itemLike, n);
    }
}

