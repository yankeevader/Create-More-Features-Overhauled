package net.mcreator.create_mf.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;

public class SignallingenableprocedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        IntegerProperty _integerProp;
        int _value = 1;
        BlockPos _pos = BlockPos.containing((double)x, (double)y, (double)z);
        BlockState _bs = world.getBlockState(_pos);
        Property property = _bs.getBlock().getStateDefinition().getProperty("blockstate");
        if (property instanceof IntegerProperty && (_integerProp = (IntegerProperty)property).getPossibleValues().contains(_value)) {
            world.setBlock(_pos, (BlockState)_bs.setValue((Property)_integerProp, (Comparable)Integer.valueOf(_value)), 3);
        }
        if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
                _level.playSound(null, BlockPos.containing((double)x, (double)y, (double)z), (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"create_mf:signalling")), SoundSource.NEUTRAL, 6.0f, 1.0f);
            } else {
                _level.playLocalSound(x, y, z, (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"create_mf:signalling")), SoundSource.NEUTRAL, 6.0f, 1.0f, false);
            }
        }
        if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((ParticleOptions)ParticleTypes.FIREWORK, x + 0.5, y + 0.5, z + 0.5, 5, 0.2, 0.3, 0.2, 0.1);
        }
    }
}

