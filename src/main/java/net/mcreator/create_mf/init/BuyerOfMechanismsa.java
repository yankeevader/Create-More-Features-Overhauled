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
public class BuyerOfMechanismsa {
    @SubscribeEvent
    public static void registerBuyerOfMechanismsa(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.BUYER_OF_MECHANISMS.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("cogwheel", 8), new ItemStack((ItemLike) Items.EMERALD), 24, 2, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("gearbox", 2), new ItemStack((ItemLike) Items.EMERALD), 12, 3, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("vertical_gearbox", 2), new ItemStack((ItemLike) Items.EMERALD), 12, 3, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(BuyerOfMechanismsa.createItem("belt_connector", 6), new ItemStack((ItemLike) Items.EMERALD), 20, 4, 0.05f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("encased_fan", 2), new ItemStack((ItemLike) Items.EMERALD, 2), 16, 6, 0.06f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_drill", 2), new ItemStack((ItemLike) Items.EMERALD, 2), 16, 6, 0.06f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_saw", 2), new ItemStack((ItemLike) Items.EMERALD, 2), 16, 6, 0.06f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_press", 1), new ItemStack((ItemLike) Items.EMERALD, 2), 20, 6, 0.06f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(BuyerOfMechanismsa.createItem("blaze_burner", 1), new ItemStack((ItemLike) Items.EMERALD, 5), 10, 7, 0.07f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(BuyerOfMechanismsa.createItem("crushing_wheel", 1), new ItemStack((ItemLike) Items.EMERALD, 6), 10, 7, 0.07f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(BuyerOfMechanismsa.createItem("shaft", 48), new ItemStack((ItemLike) Items.EMERALD), 24, 5, 0.07f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(BuyerOfMechanismsa.createItem("precision_mechanism", 1), new ItemStack((ItemLike) Items.EMERALD, 5), 8, 8, 0.08f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(BuyerOfMechanismsa.createItem("sturdy_sheet", 1), new ItemStack((ItemLike) Items.EMERALD, 2), 10, 8, 0.08f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_arm", 1), new ItemStack((ItemLike) Items.EMERALD, 8), 6, 10, 0.08f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(BuyerOfMechanismsa.createItem("mechanical_crafter", 4), new ItemStack((ItemLike) Items.EMERALD, 5), 10, 10, 0.08f));
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
