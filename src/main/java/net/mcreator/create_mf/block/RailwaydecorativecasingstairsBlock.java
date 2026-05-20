package net.mcreator.create_mf.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RailwaydecorativecasingstairsBlock
extends StairBlock {
    public RailwaydecorativecasingstairsBlock() {
        super(Blocks.AIR.defaultBlockState(), BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).strength(6.0f, 10.0f).dynamicShape());
    }

    public float getExplosionResistance() {
        return 10.0f;
    }
}

