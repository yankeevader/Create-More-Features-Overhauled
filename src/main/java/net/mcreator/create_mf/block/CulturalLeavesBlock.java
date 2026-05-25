package net.mcreator.create_mf.block;

import net.mcreator.create_mf.init.CreateMfModBlocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class CulturalLeavesBlock extends LeavesBlock {
    public CulturalLeavesBlock() {
        super(BlockBehaviour.Properties.of()
                .sound(SoundType.GRASS)
                .strength(0.2f)
                .randomTicks()
                .noOcclusion()
                .isValidSpawn((state, world, pos, entityType) -> false)
                .isSuffocating((state, world, pos) -> false)
                .isViewBlocking((state, world, pos) -> false));
    }

    @Override
    public int getLightBlock(net.minecraft.world.level.block.state.BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1;
    }

    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getAverageFoliageColor((BlockAndTintGetter) world, pos)
                        : FoliageColor.getDefaultColor(),
                CreateMfModBlocks.CULTURAL_LEAVES.get()
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> FoliageColor.getDefaultColor(),
                CreateMfModBlocks.CULTURAL_LEAVES.get()
        );
    }
}
