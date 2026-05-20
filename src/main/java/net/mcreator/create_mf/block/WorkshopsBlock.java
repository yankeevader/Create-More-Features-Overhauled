package net.mcreator.create_mf.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WorkshopsBlock
extends Block {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public WorkshopsBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.WOOD).strength(4.0f, 10.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH));
    }

    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch ((Direction)state.getValue((Property)FACING)) {
            default -> Shapes.or((VoxelShape)WorkshopsBlock.box((double)12.0, (double)0.0, (double)6.0, (double)15.0, (double)11.0, (double)9.0), (VoxelShape[])new VoxelShape[]{WorkshopsBlock.box((double)1.0, (double)0.0, (double)6.0, (double)4.0, (double)11.0, (double)9.0), WorkshopsBlock.box((double)0.0, (double)11.0, (double)0.0, (double)16.0, (double)13.0, (double)15.0), WorkshopsBlock.box((double)0.5, (double)13.0, (double)0.0, (double)15.5, (double)23.0, (double)6.0), WorkshopsBlock.box((double)5.5, (double)18.0, (double)6.0, (double)11.5, (double)19.0, (double)6.5), WorkshopsBlock.box((double)1.0, (double)12.0, (double)14.0, (double)3.0, (double)15.0, (double)16.0), WorkshopsBlock.box((double)5.0, (double)13.0, (double)7.0, (double)16.0, (double)13.25, (double)14.0)});
            case Direction.NORTH -> Shapes.or((VoxelShape)WorkshopsBlock.box((double)1.0, (double)0.0, (double)7.0, (double)4.0, (double)11.0, (double)10.0), (VoxelShape[])new VoxelShape[]{WorkshopsBlock.box((double)12.0, (double)0.0, (double)7.0, (double)15.0, (double)11.0, (double)10.0), WorkshopsBlock.box((double)0.0, (double)11.0, (double)1.0, (double)16.0, (double)13.0, (double)16.0), WorkshopsBlock.box((double)0.5, (double)13.0, (double)10.0, (double)15.5, (double)23.0, (double)16.0), WorkshopsBlock.box((double)4.5, (double)18.0, (double)9.5, (double)10.5, (double)19.0, (double)10.0), WorkshopsBlock.box((double)13.0, (double)12.0, (double)0.0, (double)15.0, (double)15.0, (double)2.0), WorkshopsBlock.box((double)0.0, (double)13.0, (double)2.0, (double)11.0, (double)13.25, (double)9.0)});
            case Direction.EAST -> Shapes.or((VoxelShape)WorkshopsBlock.box((double)6.0, (double)0.0, (double)1.0, (double)9.0, (double)11.0, (double)4.0), (VoxelShape[])new VoxelShape[]{WorkshopsBlock.box((double)6.0, (double)0.0, (double)12.0, (double)9.0, (double)11.0, (double)15.0), WorkshopsBlock.box((double)0.0, (double)11.0, (double)0.0, (double)15.0, (double)13.0, (double)16.0), WorkshopsBlock.box((double)0.0, (double)13.0, (double)0.5, (double)6.0, (double)23.0, (double)15.5), WorkshopsBlock.box((double)6.0, (double)18.0, (double)4.5, (double)6.5, (double)19.0, (double)10.5), WorkshopsBlock.box((double)14.0, (double)12.0, (double)13.0, (double)16.0, (double)15.0, (double)15.0), WorkshopsBlock.box((double)7.0, (double)13.0, (double)0.0, (double)14.0, (double)13.25, (double)11.0)});
            case Direction.WEST -> Shapes.or((VoxelShape)WorkshopsBlock.box((double)7.0, (double)0.0, (double)12.0, (double)10.0, (double)11.0, (double)15.0), (VoxelShape[])new VoxelShape[]{WorkshopsBlock.box((double)7.0, (double)0.0, (double)1.0, (double)10.0, (double)11.0, (double)4.0), WorkshopsBlock.box((double)1.0, (double)11.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0), WorkshopsBlock.box((double)10.0, (double)13.0, (double)0.5, (double)16.0, (double)23.0, (double)15.5), WorkshopsBlock.box((double)9.5, (double)18.0, (double)5.5, (double)10.0, (double)19.0, (double)11.5), WorkshopsBlock.box((double)0.0, (double)12.0, (double)1.0, (double)2.0, (double)15.0, (double)3.0), WorkshopsBlock.box((double)2.0, (double)13.0, (double)5.0, (double)9.0, (double)13.25, (double)16.0)});
        };
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{FACING});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)super.getStateForPlacement(context).setValue((Property)FACING, (Comparable)context.getHorizontalDirection().getOpposite());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
    }
}

