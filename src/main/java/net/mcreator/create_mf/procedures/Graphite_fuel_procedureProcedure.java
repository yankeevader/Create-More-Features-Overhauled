package net.mcreator.create_mf.procedures;

import net.minecraft.world.item.ItemStack;

public class Graphite_fuel_procedureProcedure {
    public static boolean execute(ItemStack itemstack) {
        return itemstack.getCount() >= 10;
    }
}

