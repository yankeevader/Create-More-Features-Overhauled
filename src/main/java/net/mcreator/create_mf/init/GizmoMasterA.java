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
public class GizmoMasterA {
    @SubscribeEvent
    public static void registerGizmoMasterA(VillagerTradesEvent event) {
        if (event.getType() != CreateMfModVillagerProfessions.GIZMOMASTER.get()) {
            return;
        }

        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 1), GizmoMasterA.createItem("turntable", 1), 12, 3, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), GizmoMasterA.createItem("hand_crank", 1), 12, 3, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 3), GizmoMasterA.createItem("nozzle", 1), 10, 3, 0.01f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), GizmoMasterA.createItem("cuckoo_clock", 1), 10, 4, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), GizmoMasterA.createItem("mechanical_piston", 1), 15, 4, 0.01f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 5), GizmoMasterA.createItem("mechanical_bearing", 1), 15, 4, 0.01f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 8), GizmoMasterA.createItem("gantry_carriage", 1), 10, 6, 0.02f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), GizmoMasterA.createItem("linear_chassis", 2), 20, 6, 0.02f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 2), GizmoMasterA.createItem("placard", 1), 20, 8, 0.03f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(4), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 7), GizmoMasterA.createItem("rope_pulley", 1), 10, 8, 0.03f));

        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 14), GizmoMasterA.createItem("elevator_pulley", 1), 5, 9, 0.05f));
        CmfTradeGuard.safeAdd((List) event.getTrades().get(5), new BasicItemListing(new ItemStack((ItemLike) Items.EMERALD, 4), GizmoMasterA.createItem("radial_chassis", 2), 15, 9, 0.05f));
    }

    private static ItemStack createItem(String string, int n) {
        ItemLike itemLike;
        if (n < 1) {
            n = 1;
        }
        if (n > 99) {
            n = 99;
        }
        if ((itemLike = (ItemLike) BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath((String) "create", (String) string))) == Items.AIR) {
            return ItemStack.EMPTY;
        }
        return new ItemStack(itemLike, n);
    }
}
