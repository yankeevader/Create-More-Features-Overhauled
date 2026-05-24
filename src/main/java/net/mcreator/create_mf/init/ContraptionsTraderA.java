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
public class ContraptionsTraderA {
    @SubscribeEvent
    public static void registerContraptionsTraderA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.CONTRAPTIONSTRADER.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), ContraptionsTraderA.createItem("encased_fan", 1), 15, 4, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 10), ContraptionsTraderA.createItem("millstone", 1), 10, 4, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 16), ContraptionsTraderA.createItem("mechanical_press", 1), 10, 4, 0.01f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 16), ContraptionsTraderA.createItem("mechanical_drill", 1), 15, 6, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 16), ContraptionsTraderA.createItem("mechanical_saw", 1), 10, 6, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), ContraptionsTraderA.createItem("mechanical_harvester", 1), 20, 6, 0.01f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 12), ContraptionsTraderA.createItem("portable_storage_interface", 1), 15, 7, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 18), ContraptionsTraderA.createItem("mechanical_mixer", 1), 10, 7, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 24), ContraptionsTraderA.createItem("deployer", 1), 25, 7, 0.02f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), ContraptionsTraderA.createItem("mechanical_plough", 1), 10, 8, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 20), ContraptionsTraderA.createItem("contraption_controls", 1), 15, 8, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 32), ContraptionsTraderA.createItem("crushing_wheel", 1), 8, 9, 0.02f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 32), ContraptionsTraderA.createItem("mechanical_roller", 1), 6, 10, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), ContraptionsTraderA.createItem("redstone_contact", 1), 15, 10, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 6), ContraptionsTraderA.createItem("speedometer", 1), 10, 10, 0.03f));
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
