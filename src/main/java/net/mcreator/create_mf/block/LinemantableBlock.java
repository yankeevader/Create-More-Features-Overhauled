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

public class LinemantableBlock
extends Block
implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public LinemantableBlock() {
        super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.NETHER_BRICKS).strength(5.0f, 10.0f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
        this.registerDefaultState((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue((Property)FACING, (Comparable)Direction.NORTH)).setValue((Property)WATERLOGGED, (Comparable)Boolean.valueOf(false)));
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
            default -> Shapes.or((VoxelShape)LinemantableBlock.box((double)1.0, (double)0.0, (double)6.0, (double)5.0, (double)12.0, (double)10.0), (VoxelShape[])new VoxelShape[]{LinemantableBlock.box((double)11.0, (double)0.0, (double)6.0, (double)15.0, (double)12.0, (double)10.0), LinemantableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0), LinemantableBlock.box((double)8.0, (double)13.0, (double)2.0, (double)14.0, (double)16.0, (double)4.0), LinemantableBlock.box((double)2.0, (double)13.0, (double)3.0, (double)6.0, (double)14.0, (double)7.0), LinemantableBlock.box((double)3.0, (double)14.0, (double)4.0, (double)5.0, (double)19.0, (double)6.0), LinemantableBlock.box((double)5.75, (double)13.0, (double)8.75, (double)13.75, (double)13.5, (double)13.75)});
            case Direction.NORTH -> Shapes.or((VoxelShape)LinemantableBlock.box((double)11.0, (double)0.0, (double)6.0, (double)15.0, (double)12.0, (double)10.0), (VoxelShape[])new VoxelShape[]{LinemantableBlock.box((double)1.0, (double)0.0, (double)6.0, (double)5.0, (double)12.0, (double)10.0), LinemantableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0), LinemantableBlock.box((double)2.0, (double)13.0, (double)12.0, (double)8.0, (double)16.0, (double)14.0), LinemantableBlock.box((double)10.0, (double)13.0, (double)9.0, (double)14.0, (double)14.0, (double)13.0), LinemantableBlock.box((double)11.0, (double)14.0, (double)10.0, (double)13.0, (double)19.0, (double)12.0), LinemantableBlock.box((double)2.25, (double)13.0, (double)2.25, (double)10.25, (double)13.5, (double)7.25)});
            case Direction.EAST -> Shapes.or((VoxelShape)LinemantableBlock.box((double)6.0, (double)0.0, (double)11.0, (double)10.0, (double)12.0, (double)15.0), (VoxelShape[])new VoxelShape[]{LinemantableBlock.box((double)6.0, (double)0.0, (double)1.0, (double)10.0, (double)12.0, (double)5.0), LinemantableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0), LinemantableBlock.box((double)2.0, (double)13.0, (double)2.0, (double)4.0, (double)16.0, (double)8.0), LinemantableBlock.box((double)3.0, (double)13.0, (double)10.0, (double)7.0, (double)14.0, (double)14.0), LinemantableBlock.box((double)4.0, (double)14.0, (double)11.0, (double)6.0, (double)19.0, (double)13.0), LinemantableBlock.box((double)8.75, (double)13.0, (double)2.25, (double)13.75, (double)13.5, (double)10.25)});
            case Direction.WEST -> Shapes.or((VoxelShape)LinemantableBlock.box((double)6.0, (double)0.0, (double)1.0, (double)10.0, (double)12.0, (double)5.0), (VoxelShape[])new VoxelShape[]{LinemantableBlock.box((double)6.0, (double)0.0, (double)11.0, (double)10.0, (double)12.0, (double)15.0), LinemantableBlock.box((double)0.0, (double)12.0, (double)0.0, (double)16.0, (double)13.0, (double)16.0), LinemantableBlock.box((double)12.0, (double)13.0, (double)8.0, (double)14.0, (double)16.0, (double)14.0), LinemantableBlock.box((double)9.0, (double)13.0, (double)2.0, (double)13.0, (double)14.0, (double)6.0), LinemantableBlock.box((double)10.0, (double)14.0, (double)3.0, (double)12.0, (double)19.0, (double)5.0), LinemantableBlock.box((double)2.25, (double)13.0, (double)5.75, (double)7.25, (double)13.5, (double)13.75)});
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

