package net.mcreator.create_mf.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class DarkStorageProcedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (itemstack == null || itemstack.isEmpty()) {
            return;
        }

        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState state = world.getBlockState(pos);

        Property<?> property = state.getBlock().getStateDefinition().getProperty("blockstate");

        if (!(property instanceof IntegerProperty integerProperty)) {
            return;
        }

        int blockstate = state.getValue(integerProperty);

        if (blockstate == 1) {
            setStoredFluid(itemstack, "minecraft:water", 1000.0);
        }

        if (blockstate == 2) {
            setStoredFluid(itemstack, "minecraft:lava", 1000.0);
        }

        if (blockstate == 3) {
            setStoredFluid(itemstack, "minecraft:water", 2000.0);
        }

        if (blockstate == 4) {
            setStoredFluid(itemstack, "minecraft:lava", 2000.0);
        }
    }

    private static void setStoredFluid(ItemStack stack, String fluidName, double amount) {
        CompoundTag tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();

        tag.putString("FluidName", fluidName);
        tag.putDouble("FluidAmount", amount);

        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }
}