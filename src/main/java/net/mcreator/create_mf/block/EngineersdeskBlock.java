package net.mcreator.create_mf.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EngineersdeskBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public EngineersdeskBlock() {
        super(BlockBehaviour.Properties.of().ignitedByLava().instrument(NoteBlockInstrument.BASS).sound(SoundType.NETHER_WOOD_HANGING_SIGN).strength(12.0f, 30.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
    }

    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() == this ? true : super.skipRendering(state, adjacentBlockState, side);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch ((Direction)state.getValue((Property)FACING)) {
            default -> Shapes.or((VoxelShape)EngineersdeskBlock.box((double)12.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)16.0), (VoxelShape[])new VoxelShape[]{EngineersdeskBlock.box((double)0.0, (double)0.0, (double)0.0, (double)4.0, (double)1.0, (double)16.0), EngineersdeskBlock.box((double)13.0, (double)1.0, (double)0.0, (double)15.0, (double)16.0, (double)16.0), EngineersdeskBlock.box((double)1.0, (double)1.0, (double)0.0, (double)3.0, (double)16.0, (double)16.0), EngineersdeskBlock.box((double)3.0, (double)11.0, (double)0.0, (double)13.0, (double)16.0, (double)9.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)0.0, (double)16.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)-2.0, (double)16.0, (double)0.0, (double)0.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)16.0, (double)16.0, (double)0.0, (double)18.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)3.0, (double)6.0, (double)0.0, (double)13.0, (double)11.0, (double)9.0), EngineersdeskBlock.box((double)0.0, (double)17.0, (double)0.0, (double)16.0, (double)30.0, (double)1.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)1.0, (double)15.0, (double)28.0, (double)2.0), EngineersdeskBlock.box((double)12.0, (double)18.0, (double)1.0, (double)13.0, (double)28.0, (double)2.0), EngineersdeskBlock.box((double)10.0, (double)18.0, (double)1.0, (double)11.0, (double)28.0, (double)2.0), EngineersdeskBlock.box((double)0.0, (double)18.0, (double)1.0, (double)1.0, (double)25.0, (double)2.0), EngineersdeskBlock.box((double)1.0, (double)24.0, (double)1.0, (double)2.0, (double)27.0, (double)2.0), EngineersdeskBlock.box((double)-1.0, (double)24.0, (double)1.0, (double)0.0, (double)27.0, (double)2.0), EngineersdeskBlock.box((double)3.0, (double)26.0, (double)1.0, (double)4.0, (double)28.0, (double)2.0), EngineersdeskBlock.box((double)4.0, (double)20.0, (double)1.0, (double)5.0, (double)26.0, (double)2.0), EngineersdeskBlock.box((double)5.0, (double)26.0, (double)1.0, (double)6.0, (double)28.0, (double)2.0), EngineersdeskBlock.box((double)12.0, (double)17.0, (double)12.0, (double)16.0, (double)18.0, (double)13.0), EngineersdeskBlock.box((double)3.0, (double)18.0, (double)1.0, (double)4.0, (double)20.0, (double)2.0), EngineersdeskBlock.box((double)5.0, (double)18.0, (double)1.0, (double)6.0, (double)20.0, (double)2.0), EngineersdeskBlock.box((double)16.0, (double)17.0, (double)0.0, (double)18.0, (double)30.0, (double)1.0), EngineersdeskBlock.box((double)-2.0, (double)17.0, (double)0.0, (double)0.0, (double)30.0, (double)1.0)});
            case Direction.NORTH -> Shapes.or((VoxelShape)EngineersdeskBlock.box((double)0.0, (double)0.0, (double)0.0, (double)4.0, (double)1.0, (double)16.0), (VoxelShape[])new VoxelShape[]{EngineersdeskBlock.box((double)12.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)16.0), EngineersdeskBlock.box((double)1.0, (double)1.0, (double)0.0, (double)3.0, (double)16.0, (double)16.0), EngineersdeskBlock.box((double)13.0, (double)1.0, (double)0.0, (double)15.0, (double)16.0, (double)16.0), EngineersdeskBlock.box((double)3.0, (double)11.0, (double)7.0, (double)13.0, (double)16.0, (double)16.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)0.0, (double)16.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)16.0, (double)16.0, (double)0.0, (double)18.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)-2.0, (double)16.0, (double)0.0, (double)0.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)3.0, (double)6.0, (double)7.0, (double)13.0, (double)11.0, (double)16.0), EngineersdeskBlock.box((double)0.0, (double)17.0, (double)15.0, (double)16.0, (double)30.0, (double)16.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)14.0, (double)2.0, (double)28.0, (double)15.0), EngineersdeskBlock.box((double)3.0, (double)18.0, (double)14.0, (double)4.0, (double)28.0, (double)15.0), EngineersdeskBlock.box((double)5.0, (double)18.0, (double)14.0, (double)6.0, (double)28.0, (double)15.0), EngineersdeskBlock.box((double)15.0, (double)18.0, (double)14.0, (double)16.0, (double)25.0, (double)15.0), EngineersdeskBlock.box((double)14.0, (double)24.0, (double)14.0, (double)15.0, (double)27.0, (double)15.0), EngineersdeskBlock.box((double)16.0, (double)24.0, (double)14.0, (double)17.0, (double)27.0, (double)15.0), EngineersdeskBlock.box((double)12.0, (double)26.0, (double)14.0, (double)13.0, (double)28.0, (double)15.0), EngineersdeskBlock.box((double)11.0, (double)20.0, (double)14.0, (double)12.0, (double)26.0, (double)15.0), EngineersdeskBlock.box((double)10.0, (double)26.0, (double)14.0, (double)11.0, (double)28.0, (double)15.0), EngineersdeskBlock.box((double)0.0, (double)17.0, (double)3.0, (double)4.0, (double)18.0, (double)4.0), EngineersdeskBlock.box((double)12.0, (double)18.0, (double)14.0, (double)13.0, (double)20.0, (double)15.0), EngineersdeskBlock.box((double)10.0, (double)18.0, (double)14.0, (double)11.0, (double)20.0, (double)15.0), EngineersdeskBlock.box((double)-2.0, (double)17.0, (double)15.0, (double)0.0, (double)30.0, (double)16.0), EngineersdeskBlock.box((double)16.0, (double)17.0, (double)15.0, (double)18.0, (double)30.0, (double)16.0)});
            case Direction.EAST -> Shapes.or((VoxelShape)EngineersdeskBlock.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)4.0), (VoxelShape[])new VoxelShape[]{EngineersdeskBlock.box((double)0.0, (double)0.0, (double)12.0, (double)16.0, (double)1.0, (double)16.0), EngineersdeskBlock.box((double)0.0, (double)1.0, (double)1.0, (double)16.0, (double)16.0, (double)3.0), EngineersdeskBlock.box((double)0.0, (double)1.0, (double)13.0, (double)16.0, (double)16.0, (double)15.0), EngineersdeskBlock.box((double)0.0, (double)11.0, (double)3.0, (double)9.0, (double)16.0, (double)13.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)0.0, (double)16.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)16.0, (double)16.0, (double)17.0, (double)18.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)-2.0, (double)16.0, (double)17.0, (double)0.0), EngineersdeskBlock.box((double)0.0, (double)6.0, (double)3.0, (double)9.0, (double)11.0, (double)13.0), EngineersdeskBlock.box((double)0.0, (double)17.0, (double)0.0, (double)1.0, (double)30.0, (double)16.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)1.0, (double)2.0, (double)28.0, (double)2.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)3.0, (double)2.0, (double)28.0, (double)4.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)5.0, (double)2.0, (double)28.0, (double)6.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)15.0, (double)2.0, (double)25.0, (double)16.0), EngineersdeskBlock.box((double)1.0, (double)24.0, (double)14.0, (double)2.0, (double)27.0, (double)15.0), EngineersdeskBlock.box((double)1.0, (double)24.0, (double)16.0, (double)2.0, (double)27.0, (double)17.0), EngineersdeskBlock.box((double)1.0, (double)26.0, (double)12.0, (double)2.0, (double)28.0, (double)13.0), EngineersdeskBlock.box((double)1.0, (double)20.0, (double)11.0, (double)2.0, (double)26.0, (double)12.0), EngineersdeskBlock.box((double)1.0, (double)26.0, (double)10.0, (double)2.0, (double)28.0, (double)11.0), EngineersdeskBlock.box((double)12.0, (double)17.0, (double)0.0, (double)13.0, (double)18.0, (double)4.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)12.0, (double)2.0, (double)20.0, (double)13.0), EngineersdeskBlock.box((double)1.0, (double)18.0, (double)10.0, (double)2.0, (double)20.0, (double)11.0), EngineersdeskBlock.box((double)0.0, (double)17.0, (double)-2.0, (double)1.0, (double)30.0, (double)0.0), EngineersdeskBlock.box((double)0.0, (double)17.0, (double)16.0, (double)1.0, (double)30.0, (double)18.0)});
            case Direction.WEST -> Shapes.or((VoxelShape)EngineersdeskBlock.box((double)0.0, (double)0.0, (double)12.0, (double)16.0, (double)1.0, (double)16.0), (VoxelShape[])new VoxelShape[]{EngineersdeskBlock.box((double)0.0, (double)0.0, (double)0.0, (double)16.0, (double)1.0, (double)4.0), EngineersdeskBlock.box((double)0.0, (double)1.0, (double)13.0, (double)16.0, (double)16.0, (double)15.0), EngineersdeskBlock.box((double)0.0, (double)1.0, (double)1.0, (double)16.0, (double)16.0, (double)3.0), EngineersdeskBlock.box((double)7.0, (double)11.0, (double)3.0, (double)16.0, (double)16.0, (double)13.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)0.0, (double)16.0, (double)17.0, (double)16.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)-2.0, (double)16.0, (double)17.0, (double)0.0), EngineersdeskBlock.box((double)0.0, (double)16.0, (double)16.0, (double)16.0, (double)17.0, (double)18.0), EngineersdeskBlock.box((double)7.0, (double)6.0, (double)3.0, (double)16.0, (double)11.0, (double)13.0), EngineersdeskBlock.box((double)15.0, (double)17.0, (double)0.0, (double)16.0, (double)30.0, (double)16.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)14.0, (double)15.0, (double)28.0, (double)15.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)12.0, (double)15.0, (double)28.0, (double)13.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)10.0, (double)15.0, (double)28.0, (double)11.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)0.0, (double)15.0, (double)25.0, (double)1.0), EngineersdeskBlock.box((double)14.0, (double)24.0, (double)1.0, (double)15.0, (double)27.0, (double)2.0), EngineersdeskBlock.box((double)14.0, (double)24.0, (double)-1.0, (double)15.0, (double)27.0, (double)0.0), EngineersdeskBlock.box((double)14.0, (double)26.0, (double)3.0, (double)15.0, (double)28.0, (double)4.0), EngineersdeskBlock.box((double)14.0, (double)20.0, (double)4.0, (double)15.0, (double)26.0, (double)5.0), EngineersdeskBlock.box((double)14.0, (double)26.0, (double)5.0, (double)15.0, (double)28.0, (double)6.0), EngineersdeskBlock.box((double)3.0, (double)17.0, (double)12.0, (double)4.0, (double)18.0, (double)16.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)3.0, (double)15.0, (double)20.0, (double)4.0), EngineersdeskBlock.box((double)14.0, (double)18.0, (double)5.0, (double)15.0, (double)20.0, (double)6.0), EngineersdeskBlock.box((double)15.0, (double)17.0, (double)16.0, (double)16.0, (double)30.0, (double)18.0), EngineersdeskBlock.box((double)15.0, (double)17.0, (double)-2.0, (double)16.0, (double)30.0, (double)0.0)});
        };
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{FACING, WATERLOGGED});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
        return (BlockState)((BlockState)super.getStateForPlacement(context).setValue((Property)FACING, (Comparable)context.getHorizontalDirection().getOpposite())).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(flag));
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue((Property)FACING, (Comparable)rot.rotate((Direction)state.getValue((Property)FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation((Direction)state.getValue((Property)FACING)));
    }

    public FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue((Property)WATERLOGGED) != false ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (((Boolean)state.getValue((Property)WATERLOGGED)).booleanValue()) {
            world.scheduleTick(currentPos, (Fluid)Fluids.WATER, Fluids.WATER.getTickDelay((LevelReader)world));
        }
        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
}

