package net.mcreator.create_mf.init;

import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@EventBusSubscriber
public class SellerOfMechanismsa {
    @SubscribeEvent
    public static void registerSellerofmechanismsa(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.SELLEROFMECHANISMS.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 1), SellerOfMechanismsa.createBlock("andesite_casing", 2), 20, 2, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createItem("iron_sheet", 4), 20, 1, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createItem("golden_sheet", 2), 15, 2, 0.01f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), SellerOfMechanismsa.createItem("super_glue", 1), 5, 5, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createItem("filter", 3), 20, 3, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createItem("cogwheel", 4), 30, 3, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createItem("belt_connector", 2), 25, 4, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), SellerOfMechanismsa.createBlock("gearbox", 1), 20, 5, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), SellerOfMechanismsa.createBlock("clutch", 1), 18, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), SellerOfMechanismsa.createBlock("gearshift", 1), 18, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createBlock("sail", 2), 20, 5, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), SellerOfMechanismsa.createBlock("brass_casing", 1), 20, 7, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), SellerOfMechanismsa.createItem("polished_rose_quartz", 1), 40, 6, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), SellerOfMechanismsa.createItem("brass_hand", 1), 15, 7, 0.04f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 12), SellerOfMechanismsa.createItem("precision_mechanism", 1), 10, 9, 0.04f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), SellerOfMechanismsa.createBlock("piston_extension_pole", 8), 18, 6, 0.04f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 16), SellerOfMechanismsa.createItem("empty_blaze_burner", 1), new ItemStack((ItemLike) Blocks.DIAMOND_BLOCK), 6, 7, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 16), SellerOfMechanismsa.createItem("mechanical_arm", 1), 8, 10, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 6), SellerOfMechanismsa.createItem("display_link", 1), 10, 12, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 7), SellerOfMechanismsa.createBlock("orange_nixie_tube", 2), 10, 13, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), SellerOfMechanismsa.createItem("electron_tube", 1), 10, 10, 0.05f));
    }

    private static ItemStack createBlock(String id, int count) {
        if (count < 1) {
            count = 1;
        }
        if (count > 99) {
            count = 99;
        }

        Block block = BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath("create", id));
        if (block == Blocks.AIR) {
            return ItemStack.EMPTY;
        }

        ItemLike itemLike = block.asItem();
        if (itemLike == Items.AIR) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(itemLike, count);
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
