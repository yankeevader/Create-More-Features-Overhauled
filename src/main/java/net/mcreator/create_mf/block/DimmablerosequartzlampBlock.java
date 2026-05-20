package net.mcreator.create_mf.block;

import net.mcreator.create_mf.procedures.DimmablerosequartzlampdisableprocedureProcedure;
import net.mcreator.create_mf.procedures.DimmablerosequartzlampenableprocedureProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DimmablerosequartzlampBlock
extends Block {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create((String)"blockstate", (int)0, (int)14);

    public DimmablerosequartzlampBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.GLASS).strength(6.0f, 10.0f).lightLevel(s -> { int level = ((Integer)s.getValue((Property)BLOCKSTATE)).intValue(); return level >= 6 ? level + 1 : level; }));
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return DimmablerosequartzlampBlock.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)16.0, (double)16.0);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{BLOCKSTATE});
    }

    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
        return true;
    }

    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
        if (world.getBestNeighborSignal(pos) > 0) {
            DimmablerosequartzlampenableprocedureProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
        } else {
            DimmablerosequartzlampdisableprocedureProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
        }
    }
}

