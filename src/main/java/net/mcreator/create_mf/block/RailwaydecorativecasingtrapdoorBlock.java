package net.mcreator.create_mf.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;

public class RailwaydecorativecasingtrapdoorBlock
extends TrapDoorBlock {
    public RailwaydecorativecasingtrapdoorBlock() {
        super(BlockSetType.OAK, BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).strength(6.0f, 10.0f).dynamicShape());
    }
}

