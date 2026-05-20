package net.mcreator.create_mf.block;

import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RefinedradiancecasingslabBlock
extends SlabBlock {
    public RefinedradiancecasingslabBlock() {
        super(BlockBehaviour.Properties.of().sound(SoundType.ANCIENT_DEBRIS).strength(7.0f, 10.0f).requiresCorrectToolForDrops().dynamicShape());
    }
}

