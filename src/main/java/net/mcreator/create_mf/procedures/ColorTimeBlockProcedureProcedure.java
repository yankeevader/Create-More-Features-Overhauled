package net.mcreator.create_mf.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class ColorTimeBlockProcedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        IntegerProperty _integerProp;
        Property property;
        BlockState _bs;
        BlockPos _pos;
        int _value;
        if (world.dayTime() > 1000L && world.dayTime() < 6000L) {
            _value = 1;
            _pos = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = world.getBlockState(_pos);
            property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        }
        if (world.dayTime() > 6000L && world.dayTime() < 13000L) {
            _value = 2;
            _pos = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = world.getBlockState(_pos);
            property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        }
        if (world.dayTime() > 13000L && world.dayTime() < 18000L) {
            _value = 3;
            _pos = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = world.getBlockState(_pos);
            property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        }
        if (world.dayTime() > 18000L && world.dayTime() < 21000L) {
            _value = 4;
            _pos = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = world.getBlockState(_pos);
            property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        }
        if (world.dayTime() > 21000L && world.dayTime() < 24000L) {
            _value = 0;
            _pos = BlockPos.containing((double)x, (double)y, (double)z);
            _bs = world.getBlockState(_pos);
            property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
            if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
                world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
            }
        }
    }
}

