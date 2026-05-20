package net.mcreator.create_mf.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RailwaycasingslabBlock
extends SlabBlock {
    public RailwaycasingslabBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.METAL).strength(7.0f, 10.0f).requiresCorrectToolForDrops().dynamicShape());
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }
}

