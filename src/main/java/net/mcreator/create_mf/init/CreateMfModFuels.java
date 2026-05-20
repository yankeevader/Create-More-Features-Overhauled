package net.mcreator.create_mf.init;

import net.mcreator.create_mf.init.CreateMfModItems;
import net.mcreator.create_mf.procedures.Graphite_fuel_procedureProcedure;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;

@EventBusSubscriber
public class CreateMfModFuels {
    @SubscribeEvent
    public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
        ItemStack itemstack = event.getItemStack();
        if (itemstack.getItem() == CreateMfModItems.GRAPHITE.get() && Graphite_fuel_procedureProcedure.execute(itemstack)) {
            event.setBurnTime(8000);
        }
    }
}

