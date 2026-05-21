package net.mcreator.create_mf.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
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
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EngineersdeskBlock extends Block implements SimpleWaterloggedBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public EngineersdeskBlock() {
        super(BlockBehaviour.Properties.of()
                .ignitedByLava()
                .instrument(NoteBlockInstrument.BASS)
                .sound(SoundType.NETHER_WOOD_HANGING_SIGN)
                .strength(12.0f, 30.0f)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false));
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getFluidState().isEmpty();
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> Shapes.or(
                    EngineersdeskBlock.box(12.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 0.0D, 0.0D, 4.0D, 1.0D, 16.0D),
                    EngineersdeskBlock.box(13.0D, 1.0D, 0.0D, 15.0D, 16.0D, 16.0D),
                    EngineersdeskBlock.box(1.0D, 1.0D, 0.0D, 3.0D, 16.0D, 16.0D),
                    EngineersdeskBlock.box(3.0D, 11.0D, 0.0D, 13.0D, 16.0D, 9.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, 0.0D, 16.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(-2.0D, 16.0D, 0.0D, 0.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(16.0D, 16.0D, 0.0D, 18.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(3.0D, 6.0D, 0.0D, 13.0D, 11.0D, 9.0D),
                    EngineersdeskBlock.box(0.0D, 17.0D, 0.0D, 16.0D, 30.0D, 1.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 1.0D, 15.0D, 28.0D, 2.0D),
                    EngineersdeskBlock.box(12.0D, 18.0D, 1.0D, 13.0D, 28.0D, 2.0D),
                    EngineersdeskBlock.box(10.0D, 18.0D, 1.0D, 11.0D, 28.0D, 2.0D),
                    EngineersdeskBlock.box(0.0D, 18.0D, 1.0D, 1.0D, 25.0D, 2.0D),
                    EngineersdeskBlock.box(1.0D, 24.0D, 1.0D, 2.0D, 27.0D, 2.0D),
                    EngineersdeskBlock.box(-1.0D, 24.0D, 1.0D, 0.0D, 27.0D, 2.0D),
                    EngineersdeskBlock.box(3.0D, 26.0D, 1.0D, 4.0D, 28.0D, 2.0D),
                    EngineersdeskBlock.box(4.0D, 20.0D, 1.0D, 5.0D, 26.0D, 2.0D),
                    EngineersdeskBlock.box(5.0D, 26.0D, 1.0D, 6.0D, 28.0D, 2.0D),
                    EngineersdeskBlock.box(12.0D, 17.0D, 12.0D, 16.0D, 18.0D, 13.0D),
                    EngineersdeskBlock.box(3.0D, 18.0D, 1.0D, 4.0D, 20.0D, 2.0D),
                    EngineersdeskBlock.box(5.0D, 18.0D, 1.0D, 6.0D, 20.0D, 2.0D),
                    EngineersdeskBlock.box(16.0D, 17.0D, 0.0D, 18.0D, 30.0D, 1.0D),
                    EngineersdeskBlock.box(-2.0D, 17.0D, 0.0D, 0.0D, 30.0D, 1.0D)
            );
            case NORTH -> Shapes.or(
                    EngineersdeskBlock.box(0.0D, 0.0D, 0.0D, 4.0D, 1.0D, 16.0D),
                    EngineersdeskBlock.box(12.0D, 0.0D, 0.0D, 16.0D, 1.0D, 16.0D),
                    EngineersdeskBlock.box(1.0D, 1.0D, 0.0D, 3.0D, 16.0D, 16.0D),
                    EngineersdeskBlock.box(13.0D, 1.0D, 0.0D, 15.0D, 16.0D, 16.0D),
                    EngineersdeskBlock.box(3.0D, 11.0D, 7.0D, 13.0D, 16.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, 0.0D, 16.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(16.0D, 16.0D, 0.0D, 18.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(-2.0D, 16.0D, 0.0D, 0.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(3.0D, 6.0D, 7.0D, 13.0D, 11.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 17.0D, 15.0D, 16.0D, 30.0D, 16.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 14.0D, 2.0D, 28.0D, 15.0D),
                    EngineersdeskBlock.box(3.0D, 18.0D, 14.0D, 4.0D, 28.0D, 15.0D),
                    EngineersdeskBlock.box(5.0D, 18.0D, 14.0D, 6.0D, 28.0D, 15.0D),
                    EngineersdeskBlock.box(15.0D, 18.0D, 14.0D, 16.0D, 25.0D, 15.0D),
                    EngineersdeskBlock.box(14.0D, 24.0D, 14.0D, 15.0D, 27.0D, 15.0D),
                    EngineersdeskBlock.box(16.0D, 24.0D, 14.0D, 17.0D, 27.0D, 15.0D),
                    EngineersdeskBlock.box(12.0D, 26.0D, 14.0D, 13.0D, 28.0D, 15.0D),
                    EngineersdeskBlock.box(11.0D, 20.0D, 14.0D, 12.0D, 26.0D, 15.0D),
                    EngineersdeskBlock.box(10.0D, 26.0D, 14.0D, 11.0D, 28.0D, 15.0D),
                    EngineersdeskBlock.box(0.0D, 17.0D, 3.0D, 4.0D, 18.0D, 4.0D),
                    EngineersdeskBlock.box(12.0D, 18.0D, 14.0D, 13.0D, 20.0D, 15.0D),
                    EngineersdeskBlock.box(10.0D, 18.0D, 14.0D, 11.0D, 20.0D, 15.0D),
                    EngineersdeskBlock.box(-2.0D, 17.0D, 15.0D, 0.0D, 30.0D, 16.0D),
                    EngineersdeskBlock.box(16.0D, 17.0D, 15.0D, 18.0D, 30.0D, 16.0D)
            );
            case EAST -> Shapes.or(
                    EngineersdeskBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 4.0D),
                    EngineersdeskBlock.box(0.0D, 0.0D, 12.0D, 16.0D, 1.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 1.0D, 1.0D, 16.0D, 16.0D, 3.0D),
                    EngineersdeskBlock.box(0.0D, 1.0D, 13.0D, 16.0D, 16.0D, 15.0D),
                    EngineersdeskBlock.box(0.0D, 11.0D, 3.0D, 9.0D, 16.0D, 13.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, 0.0D, 16.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, 16.0D, 16.0D, 17.0D, 18.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, -2.0D, 16.0D, 17.0D, 0.0D),
                    EngineersdeskBlock.box(0.0D, 6.0D, 3.0D, 9.0D, 11.0D, 13.0D),
                    EngineersdeskBlock.box(0.0D, 17.0D, 0.0D, 1.0D, 30.0D, 16.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 1.0D, 2.0D, 28.0D, 2.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 3.0D, 2.0D, 28.0D, 4.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 5.0D, 2.0D, 28.0D, 6.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 15.0D, 2.0D, 25.0D, 16.0D),
                    EngineersdeskBlock.box(1.0D, 24.0D, 14.0D, 2.0D, 27.0D, 15.0D),
                    EngineersdeskBlock.box(1.0D, 24.0D, 16.0D, 2.0D, 27.0D, 17.0D),
                    EngineersdeskBlock.box(1.0D, 26.0D, 12.0D, 2.0D, 28.0D, 13.0D),
                    EngineersdeskBlock.box(1.0D, 20.0D, 11.0D, 2.0D, 26.0D, 12.0D),
                    EngineersdeskBlock.box(1.0D, 26.0D, 10.0D, 2.0D, 28.0D, 11.0D),
                    EngineersdeskBlock.box(12.0D, 17.0D, 0.0D, 13.0D, 18.0D, 4.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 12.0D, 2.0D, 20.0D, 13.0D),
                    EngineersdeskBlock.box(1.0D, 18.0D, 10.0D, 2.0D, 20.0D, 11.0D),
                    EngineersdeskBlock.box(0.0D, 17.0D, -2.0D, 1.0D, 30.0D, 0.0D),
                    EngineersdeskBlock.box(0.0D, 17.0D, 16.0D, 1.0D, 30.0D, 18.0D)
            );
            case WEST -> Shapes.or(
                    EngineersdeskBlock.box(0.0D, 0.0D, 12.0D, 16.0D, 1.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 1.0D, 4.0D),
                    EngineersdeskBlock.box(0.0D, 1.0D, 13.0D, 16.0D, 16.0D, 15.0D),
                    EngineersdeskBlock.box(0.0D, 1.0D, 1.0D, 16.0D, 16.0D, 3.0D),
                    EngineersdeskBlock.box(7.0D, 11.0D, 3.0D, 16.0D, 16.0D, 13.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, 0.0D, 16.0D, 17.0D, 16.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, -2.0D, 16.0D, 17.0D, 0.0D),
                    EngineersdeskBlock.box(0.0D, 16.0D, 16.0D, 16.0D, 17.0D, 18.0D),
                    EngineersdeskBlock.box(7.0D, 6.0D, 3.0D, 16.0D, 11.0D, 13.0D),
                    EngineersdeskBlock.box(15.0D, 17.0D, 0.0D, 16.0D, 30.0D, 16.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 14.0D, 15.0D, 28.0D, 15.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 12.0D, 15.0D, 28.0D, 13.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 10.0D, 15.0D, 28.0D, 11.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 0.0D, 15.0D, 25.0D, 1.0D),
                    EngineersdeskBlock.box(14.0D, 24.0D, 1.0D, 15.0D, 27.0D, 2.0D),
                    EngineersdeskBlock.box(14.0D, 24.0D, -1.0D, 15.0D, 27.0D, 0.0D),
                    EngineersdeskBlock.box(14.0D, 26.0D, 3.0D, 15.0D, 28.0D, 4.0D),
                    EngineersdeskBlock.box(14.0D, 20.0D, 4.0D, 15.0D, 26.0D, 5.0D),
                    EngineersdeskBlock.box(14.0D, 26.0D, 5.0D, 15.0D, 28.0D, 6.0D),
                    EngineersdeskBlock.box(3.0D, 17.0D, 12.0D, 4.0D, 18.0D, 16.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 3.0D, 15.0D, 20.0D, 4.0D),
                    EngineersdeskBlock.box(14.0D, 18.0D, 5.0D, 15.0D, 20.0D, 6.0D),
                    EngineersdeskBlock.box(15.0D, 17.0D, 16.0D, 16.0D, 30.0D, 18.0D),
                    EngineersdeskBlock.box(15.0D, 17.0D, -2.0D, 16.0D, 30.0D, 0.0D)
            );
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean waterlogged = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;

        return super.getStateForPlacement(context)
                .setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(WATERLOGGED, waterlogged);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return rotate(state, mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED)
                ? Fluids.WATER.getSource(false)
                : super.getFluidState(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
        }

        return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
    }
}
