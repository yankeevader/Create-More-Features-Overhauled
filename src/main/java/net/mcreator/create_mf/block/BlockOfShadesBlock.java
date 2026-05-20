package net.mcreator.create_mf.block;

import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class BlockOfShadesBlock
extends Block {
    public BlockOfShadesBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.BONE_BLOCK).strength(3.0f, 10.0f));
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> world != null && pos != null ? BiomeColors.getAverageGrassColor((BlockAndTintGetter)world, (BlockPos)pos) : GrassColor.get((double)0.5, (double)1.0), new Block[]{(Block)CreateMfModBlocks.BLOCK_OF_SHADES.get()});
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, index) -> GrassColor.get((double)0.5, (double)1.0), new ItemLike[]{(ItemLike)CreateMfModBlocks.BLOCK_OF_SHADES.get()});
    }
}

