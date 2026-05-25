package net.mcreator.create_mf.block;

import net.mcreator.create_mf.init.CreateMfModBlocks;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class BlockOfShadesBlock extends Block {
    public BlockOfShadesBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .sound(SoundType.BONE_BLOCK)
                .strength(3.0f, 10.0f));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    @OnlyIn(Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.register(
                (state, world, pos, tintIndex) -> world != null && pos != null
                        ? BiomeColors.getAverageGrassColor((BlockAndTintGetter) world, pos)
                        : GrassColor.get(0.5, 1.0),
                CreateMfModBlocks.BLOCK_OF_SHADES.get()
        );
    }

    @OnlyIn(Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.register(
                (stack, tintIndex) -> GrassColor.get(0.5, 1.0),
                CreateMfModBlocks.BLOCK_OF_SHADES.get()
        );
    }
}
