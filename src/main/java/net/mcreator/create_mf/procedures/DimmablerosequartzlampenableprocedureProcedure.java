package net.mcreator.create_mf.procedures;

import net.mcreator.create_mf.CreateMfMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class DimmablerosequartzlampenableprocedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        for (int value = 1; value <= 15; value++) {
            final int targetValue = value;
            CreateMfMod.queueServerWork(targetValue * 10, () -> setBlockstate(world, x, y, z, targetValue));
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void setBlockstate(LevelAccessor world, double x, double y, double z, int value) {
        BlockPos pos = BlockPos.containing(x, y, z);
        BlockState state = world.getBlockState(pos);
        Property<?> property = state.getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty integerProperty && integerProperty.getPossibleValues().contains(value)) {
            world.setBlock(pos, state.setValue((Property)integerProperty, value), 3);
        }
    }
}
