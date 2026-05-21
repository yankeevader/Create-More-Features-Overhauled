package net.mcreator.create_mf.block;

import net.mcreator.create_mf.procedures.SignallingdisableprocedureProcedure;
import net.mcreator.create_mf.procedures.SignallingenableprocedureProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
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
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SignallingBlock extends Block implements SimpleWaterloggedBlock {
    public static final IntegerProperty BLOCKSTATE = IntegerProperty.create("blockstate", 0, 1);
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SignallingBlock() {
        super(BlockBehaviour.Properties.of()
                .instrument(NoteBlockInstrument.BASEDRUM)
                .mapColor(MapColor.TERRACOTTA_ORANGE)
                .sound(SoundType.NETHERITE_BLOCK)
                .strength(4.0f, 14.5f)
                .lightLevel(state -> state.getValue(BLOCKSTATE) == 1 ? 9 : 0)
                .noOcclusion()
                .isRedstoneConductor((bs, br, bp) -> false));

        this.registerDefaultState(this.stateDefinition.any()
                .setValue(FACING, Direction.NORTH)
                .setValue(WATERLOGGED, false)
                .setValue(BLOCKSTATE, 0));
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
        if (state.getValue(BLOCKSTATE) == 1) {
            return switch (state.getValue(FACING)) {
                default -> Shapes.or(
                        SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                        SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                        SignallingBlock.box(10.0D, 6.0D, 3.0D, 12.0D, 8.0D, 13.0D),
                        SignallingBlock.box(4.0D, 6.0D, 3.0D, 6.0D, 8.0D, 13.0D)
                );
                case NORTH -> Shapes.or(
                        SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                        SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                        SignallingBlock.box(4.0D, 6.0D, 3.0D, 6.0D, 8.0D, 13.0D),
                        SignallingBlock.box(10.0D, 6.0D, 3.0D, 12.0D, 8.0D, 13.0D)
                );
                case EAST -> Shapes.or(
                        SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                        SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                        SignallingBlock.box(3.0D, 6.0D, 4.0D, 13.0D, 8.0D, 6.0D),
                        SignallingBlock.box(3.0D, 6.0D, 10.0D, 13.0D, 8.0D, 12.0D)
                );
                case WEST -> Shapes.or(
                        SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                        SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                        SignallingBlock.box(3.0D, 6.0D, 10.0D, 13.0D, 8.0D, 12.0D),
                        SignallingBlock.box(3.0D, 6.0D, 4.0D, 13.0D, 8.0D, 6.0D)
                );
            };
        }

        return switch (state.getValue(FACING)) {
            default -> Shapes.or(
                    SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                    SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                    SignallingBlock.box(10.0D, 6.0D, 3.0D, 12.0D, 8.0D, 13.0D),
                    SignallingBlock.box(4.0D, 6.0D, 3.0D, 6.0D, 8.0D, 13.0D)
            );
            case NORTH -> Shapes.or(
                    SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                    SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                    SignallingBlock.box(4.0D, 6.0D, 3.0D, 6.0D, 8.0D, 13.0D),
                    SignallingBlock.box(10.0D, 6.0D, 3.0D, 12.0D, 8.0D, 13.0D)
            );
            case EAST -> Shapes.or(
                    SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                    SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                    SignallingBlock.box(3.0D, 6.0D, 4.0D, 13.0D, 8.0D, 6.0D),
                    SignallingBlock.box(3.0D, 6.0D, 10.0D, 13.0D, 8.0D, 12.0D)
            );
            case WEST -> Shapes.or(
                    SignallingBlock.box(6.0D, 7.0D, 6.0D, 10.0D, 14.0D, 10.0D),
                    SignallingBlock.box(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D),
                    SignallingBlock.box(3.0D, 6.0D, 10.0D, 13.0D, 8.0D, 12.0D),
                    SignallingBlock.box(3.0D, 6.0D, 4.0D, 13.0D, 8.0D, 6.0D)
            );
        };
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, WATERLOGGED, BLOCKSTATE);
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

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter world, BlockPos pos, Direction side) {
        return true;
    }

    @Override
    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);

        if (world.getBestNeighborSignal(pos) > 0) {
            SignallingenableprocedureProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
        } else {
            SignallingdisableprocedureProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
        }
    }
}
