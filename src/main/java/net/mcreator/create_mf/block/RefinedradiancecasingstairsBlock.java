package net.mcreator.create_mf.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RefinedradiancecasingstairsBlock
extends StairBlock {
    public RefinedradiancecasingstairsBlock() {
        super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().sound(SoundType.ANCIENT_DEBRIS).strength(7.0f, 10.0f).requiresCorrectToolForDrops().dynamicShape());
    }

    public float getExplosionResistance() {
        return 10.0f;
    }
}

