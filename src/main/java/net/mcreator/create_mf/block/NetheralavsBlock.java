package net.mcreator.create_mf.block;

import net.mcreator.create_mf.init.CreateMfModFluids;
import net.mcreator.create_mf.procedures.Netheralavs_craft_graniteProcedure;
import net.mcreator.create_mf.procedures.Netheralavs_dangerProcedure;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class NetheralavsBlock
extends LiquidBlock {
    public NetheralavsBlock() {
        super((FlowingFluid)CreateMfModFluids.NETHERALAVS.get(), BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100.0f).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
    }

    public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
        super.onPlace(blockstate, world, pos, oldState, moving);
        Netheralavs_craft_graniteProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
    }

    public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
        super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
        Netheralavs_craft_graniteProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
    }

    public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
        super.tick(blockstate, world, pos, random);
        Netheralavs_craft_graniteProcedure.execute((LevelAccessor)world, pos.getX(), pos.getY(), pos.getZ());
    }

    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        super.entityInside(blockstate, world, pos, entity);
        Netheralavs_dangerProcedure.execute(entity);
    }
}

