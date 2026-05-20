package net.mcreator.create_mf.procedures;

import net.mcreator.create_mf.CreateMfMod;
import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CultivatedTreeTickProcedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        CreateMfMod.queueServerWork(800, () -> {
            if (Math.random() < 0.2) {
                if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y + 2.0), (double)z)).getBlock() == Blocks.AIR) {
                    world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)CreateMfModBlocks.CULTURAL_LOG.get()).defaultBlockState(), 3);
                    world.setBlock(BlockPos.containing((double)x, (double)(y + 1.0), (double)z), ((Block)CreateMfModBlocks.CULTURAL_LEAVES.get()).defaultBlockState(), 3);
                    world.setBlock(BlockPos.containing((double)x, (double)(y + 2.0), (double)z), ((Block)CreateMfModBlocks.CULTURAL_LEAVES.get()).defaultBlockState(), 3);
                }
            } else {
                CreateMfMod.queueServerWork(100, () -> {
                    if (Math.random() < 0.5) {
                        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y + 2.0), (double)z)).getBlock() == Blocks.AIR) {
                            world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)CreateMfModBlocks.CULTURAL_LOG.get()).defaultBlockState(), 3);
                            world.setBlock(BlockPos.containing((double)x, (double)(y + 1.0), (double)z), ((Block)CreateMfModBlocks.CULTURAL_LEAVES.get()).defaultBlockState(), 3);
                            world.setBlock(BlockPos.containing((double)x, (double)(y + 2.0), (double)z), ((Block)CreateMfModBlocks.CULTURAL_LEAVES.get()).defaultBlockState(), 3);
                        }
                    } else {
                        CreateMfMod.queueServerWork(100, () -> {
                            if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == Blocks.AIR && world.getBlockState(BlockPos.containing((double)x, (double)(y + 2.0), (double)z)).getBlock() == Blocks.AIR) {
                                world.setBlock(BlockPos.containing((double)x, (double)y, (double)z), ((Block)CreateMfModBlocks.CULTURAL_LOG.get()).defaultBlockState(), 3);
                                world.setBlock(BlockPos.containing((double)x, (double)(y + 1.0), (double)z), ((Block)CreateMfModBlocks.CULTURAL_LEAVES.get()).defaultBlockState(), 3);
                                world.setBlock(BlockPos.containing((double)x, (double)(y + 2.0), (double)z), ((Block)CreateMfModBlocks.CULTURAL_LEAVES.get()).defaultBlockState(), 3);
                            }
                        });
                    }
                });
            }
        });
    }
}

