package net.mcreator.create_mf.init;

import java.util.List;
import net.mcreator.create_mf.init.CmfTradeGuard;
import net.mcreator.create_mf.init.CreateMfModVillagerProfessions;
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
        if (event.getType() == CreateMfModVillagerProfessions.SELLEROFMECHANISMS.get()) {
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("andesite_casing", 3), 20, 2, 0.01f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 2), SellerOfMechanismsa.createBlock("andesite_casing", 5), 15, 1, 0.01f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createItem("iron_sheet", 5), 20, 1, 0.01f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createItem("golden_sheet", 3), 15, 2, 0.01f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 4), SellerOfMechanismsa.createItem("super_glue", 1), 5, 5, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createItem("filter", 4), 20, 3, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("cogwheel", 4), 30, 3, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createItem("belt_connector", 2), 25, 4, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("gearbox", 1), 20, 5, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("clutch", 1), 18, 5, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("gearshift", 1), 18, 5, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("sail", 2), 20, 5, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 2), SellerOfMechanismsa.createBlock("brass_casing", 1), 20, 7, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createItem("polished_rose_quartz", 1), 50, 6, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 3), SellerOfMechanismsa.createItem("brass_hand", 1), 15, 7, 0.04f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 8), SellerOfMechanismsa.createItem("precision_mechanism", 1), 10, 9, 0.04f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD), SellerOfMechanismsa.createBlock("piston_extension_pole", 10), 18, 6, 0.04f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 7), SellerOfMechanismsa.createItem("empty_blaze_burner", 1), new ItemStack((ItemLike)Blocks.DIAMOND_BLOCK), 10, 7, 0.05f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 11), SellerOfMechanismsa.createBlock("mechanical_arm", 1), 10, 10, 0.05f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 4), SellerOfMechanismsa.createBlock("display_link", 1), 10, 12, 0.05f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 5), SellerOfMechanismsa.createBlock("orange_nixie_tube", 2), 10, 13, 0.05f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 2), SellerOfMechanismsa.createItem("electron_tube", 1), 10, 10, 0.05f));
        }
    }

    private static ItemStack createBlock(String id, int count) {
        return new ItemStack((ItemLike)((Block)BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath((String)"create", (String)id))).asItem(), count);
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

