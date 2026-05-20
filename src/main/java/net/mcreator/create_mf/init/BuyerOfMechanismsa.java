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
public class BuyerOfMechanismsa {
    @SubscribeEvent
    public static void registerBuyerOfMechanismsa(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.BUYER_OF_MECHANISMS.get()) {
            return;
        }
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("cogwheel", 6), new ItemStack((ItemLike)Items.EMERALD), 32, 2, 0.07f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("gearbox", 2), new ItemStack((ItemLike)Items.EMERALD), 14, 3, 0.06f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("vertical_gearbox", 2), new ItemStack((ItemLike)Items.EMERALD), 16, 5, 0.08f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("belt_connector", 3), new ItemStack((ItemLike)Items.EMERALD), 24, 7, 0.07f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("encased_fan", 2), new ItemStack((ItemLike)Items.EMERALD), 32, 8, 0.07f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_drill", 2), new ItemStack((ItemLike)Items.EMERALD), 35, 8, 0.09f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_saw", 2), new ItemStack((ItemLike)Items.EMERALD), 25, 8, 0.07f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_press", 1), new ItemStack((ItemLike)Items.EMERALD), 40, 8, 0.08f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(BuyerOfMechanismsa.createItem("blaze_burner", 1), new ItemStack((ItemLike)Items.EMERALD, 3), 40, 6, 0.07f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(BuyerOfMechanismsa.createItem("crushing_wheel", 1), new ItemStack((ItemLike)Items.EMERALD, 2), 26, 7, 0.1f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(BuyerOfMechanismsa.createItem("shaft", 40), new ItemStack((ItemLike)Items.EMERALD), 40, 6, 0.1f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(BuyerOfMechanismsa.createItem("precision_mechanism", 1), new ItemStack((ItemLike)Items.EMERALD), 15, 6, 0.06f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(BuyerOfMechanismsa.createItem("sturdy_sheet", 1), new ItemStack((ItemLike)Items.EMERALD), 18, 7, 0.07f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_arm", 1), new ItemStack((ItemLike)Items.EMERALD, 5), 15, 5, 0.05f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_crafter", 1), new ItemStack((ItemLike)Items.EMERALD), 15, 5, 0.05f));
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

