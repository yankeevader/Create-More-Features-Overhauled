package net.mcreator.create_mf.block;

import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;

public class RailwaydecorativecasingfancegateBlock
extends FenceGateBlock {
    public RailwaydecorativecasingfancegateBlock() {
        super(WoodType.OAK, BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.CHERRY_WOOD).strength(6.0f, 10.0f).dynamicShape().forceSolidOn());
    }
}

