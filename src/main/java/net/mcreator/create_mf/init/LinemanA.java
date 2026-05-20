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
public class LinemanA {
    @SubscribeEvent
    public static void registerLinemanA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.LINEMAN.get()) {
            return;
        }
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(LinemanA.createItem("powdered_obsidian", 6), new ItemStack((ItemLike)Items.EMERALD), 26, 2, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(LinemanA.createItem("sturdy_sheet", 1), new ItemStack((ItemLike)Items.EMERALD), 25, 2, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 5), LinemanA.createItem("railway_casing", 1), 10, 2, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 3), LinemanA.createItem("display_board", 2), 20, 2, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(LinemanA.createItem("schedule", 3), new ItemStack((ItemLike)Items.EMERALD), 20, 4, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 11), LinemanA.createItem("track_station", 1), 11, 5, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 6), LinemanA.createItem("track_observer", 2), 15, 5, 0.02f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 9), LinemanA.createItem("controls", 1), 15, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 7), LinemanA.createItem("track_signal", 4), 20, 8, 0.03f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 6), LinemanA.createItem("train_door", 1), 15, 11, 0.04f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 5), LinemanA.createItem("train_trapdoor", 1), 15, 11, 0.04f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 23), LinemanA.createItem("mechanical_roller", 1), 6, 5, 0.05f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 1), LinemanA.createItem("framed_glass_trapdoor", 1), 20, 5, 0.05f));
        CmfTradeGuard.safeAdd((List)event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike)Items.EMERALD, 2), LinemanA.createItem("framed_glass_door", 1), 20, 5, 0.05f));
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

