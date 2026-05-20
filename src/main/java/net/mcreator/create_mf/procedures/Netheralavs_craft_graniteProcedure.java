package net.mcreator.create_mf.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class Netheralavs_craft_graniteProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)z)).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)z)).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z + 1.0))).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)x, (double)y, (double)(z - 1.0))).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)(x + 1.0), (double)y, (double)(z + 1.0))).getBlock() == Blocks.WATER || world.getBlockState(BlockPos.containing((double)(x - 1.0), (double)y, (double)(z - 1.0))).getBlock() == Blocks.WATER) {
            if (Mth.nextInt((RandomSource)RandomSource.create(), (int)1, (int)3) == 1) {
                BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bs = Blocks.GRANITE.defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Property _propertyOld : _bso.getProperties()) {
                    Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                    if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                    try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                    }
                    catch (Exception exception) {}
                }
                world.setBlock(_bp, _bs, 3);
            } else {
                BlockPos _bp = BlockPos.containing((double)x, (double)y, (double)z);
                BlockState _bs = Blocks.STONE.defaultBlockState();
                BlockState _bso = world.getBlockState(_bp);
                for (Property _propertyOld : _bso.getProperties()) {
                    Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
                    if (_propertyNew == null || _bs.getValue(_propertyNew) == null) continue;
                    try {
                        _bs = (BlockState)_bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
                    }
                    catch (Exception exception) {}
                }
                world.setBlock(_bp, _bs, 3);
            }
        }
    }
}

