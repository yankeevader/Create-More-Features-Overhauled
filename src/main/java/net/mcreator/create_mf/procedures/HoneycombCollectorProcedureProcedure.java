package net.mcreator.create_mf.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

public class HoneycombCollectorProcedureProcedure {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (world.getBlockState(BlockPos.containing((double)x, (double)(y + 1.0), (double)z)).getBlock() == new Object(){

            /*
             * Enabled aggressive block sorting
             */
            public BlockState with(BlockState _bs, String _property, int _newValue) {
                BlockState blockState;
                Property _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
                if (_prop instanceof IntegerProperty) {
                    IntegerProperty _ip = (IntegerProperty)_prop;
                    if (_prop.getPossibleValues().contains(_newValue)) {
                        blockState = (BlockState)_bs.setValue((Property)_ip, (Comparable)Integer.valueOf(_newValue));
                        return blockState;
                    }
                }
                blockState = _bs;
                return blockState;
            }
        }.with(Blocks.BEEHIVE.defaultBlockState(), "honey_level", 5).getBlock() && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            LightningBolt entityToSpawn = (LightningBolt)EntityType.LIGHTNING_BOLT.create((Level)_level);
            entityToSpawn.moveTo(Vec3.atBottomCenterOf((Vec3i)BlockPos.containing((double)x, (double)y, (double)z)));
            _level.addFreshEntity((Entity)entityToSpawn);
        }
    }
}

