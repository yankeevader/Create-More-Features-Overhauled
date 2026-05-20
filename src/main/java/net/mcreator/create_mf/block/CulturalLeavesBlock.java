package net.mcreator.create_mf.block;

import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;

public class CulturalLeavesBlock
extends LeavesBlock {
    public CulturalLeavesBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().sound(SoundType.GRASS).strength(0.24f).noOcclusion());
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 1;
    }

    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 36;
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
        event.getBlockColors().register((bs, world, pos, index) -> FoliageColor.getDefaultColor(), new Block[]{(Block)CreateMfModBlocks.CULTURAL_LEAVES.get()});
    }

    @OnlyIn(value=Dist.CLIENT)
    public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
        event.getItemColors().register((stack, index) -> FoliageColor.getDefaultColor(), new ItemLike[]{(ItemLike)CreateMfModBlocks.CULTURAL_LEAVES.get()});
    }
}

