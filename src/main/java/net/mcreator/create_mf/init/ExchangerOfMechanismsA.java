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
public class ExchangerOfMechanismsA {
    @SubscribeEvent
    public static void registerExchangerOfMechanismsA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.EXCHANGEROFMECHANISMS.get()) {
            return;
        }
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(ExchangerOfMechanismsA.createItem("shaft", 3), ExchangerOfMechanismsA.createItem("cogwheel", 1), 15, 3, 0.01f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(ExchangerOfMechanismsA.createItem("cogwheel", 2), ExchangerOfMechanismsA.createItem("large_cogwheel", 1), 15, 3, 0.01f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(ExchangerOfMechanismsA.createItem("clutch", 1), ExchangerOfMechanismsA.createItem("gearshift", 1), 20, 3, 0.01f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(ExchangerOfMechanismsA.createItem("water_wheel", 1), new ItemStack((ItemLike)Items.EMERALD), ExchangerOfMechanismsA.createItem("large_water_wheel", 1), 10, 5, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(ExchangerOfMechanismsA.createItem("whisk", 1), ExchangerOfMechanismsA.createItem("propeller", 1), 10, 5, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(ExchangerOfMechanismsA.createItem("wooden_bracket", 4), ExchangerOfMechanismsA.createItem("metal_bracket", 1), 15, 5, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(ExchangerOfMechanismsA.createItem("depot", 1), new ItemStack((ItemLike)Items.EMERALD), ExchangerOfMechanismsA.createItem("weighted_ejector", 1), 10, 7, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(ExchangerOfMechanismsA.createItem("shaft", 14), ExchangerOfMechanismsA.createItem("andesite_funnel", 1), 18, 7, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(ExchangerOfMechanismsA.createItem("shaft", 24), ExchangerOfMechanismsA.createItem("andesite_tunnel", 1), 18, 7, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(ExchangerOfMechanismsA.createItem("andesite_alloy", 14), ExchangerOfMechanismsA.createItem("millstone", 1), 15, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(ExchangerOfMechanismsA.createItem("andesite_alloy", 20), ExchangerOfMechanismsA.createItem("placard", 1), 20, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(ExchangerOfMechanismsA.createItem("encased_chain_drive", 6), ExchangerOfMechanismsA.createItem("adjustable_chain_gearshift", 1), 25, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(ExchangerOfMechanismsA.createItem("chest", 1), new ItemStack((ItemLike)Items.EMERALD), ExchangerOfMechanismsA.createItem("item_vault", 1), 20, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(ExchangerOfMechanismsA.createItem("rail", 8), ExchangerOfMechanismsA.createItem("track", 1), 20, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(ExchangerOfMechanismsA.createItem("crafter_slot_cover", 4), new ItemStack((ItemLike)Items.SLIME_BALL, 3), 25, 8, 0.03f));
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

