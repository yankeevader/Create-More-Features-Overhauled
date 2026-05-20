package net.mcreator.create_mf.block;

import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RailwaydecorativecasingfenceBlock
extends FenceBlock {
    public RailwaydecorativecasingfenceBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).strength(6.0f, 10.0f).dynamicShape().forceSolidOn());
    }
}

