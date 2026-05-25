package net.mcreator.create_mf.fluid;

import net.mcreator.create_mf.init.CreateMfModFluidTypes;
import net.mcreator.create_mf.init.CreateMfModFluids;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;

public abstract class NetheralavsFluid extends BaseFlowingFluid {
    public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(
            CreateMfModFluidTypes.NETHERALAVS_TYPE,
            CreateMfModFluids.NETHERALAVS,
            CreateMfModFluids.FLOWING_NETHERALAVS
    );

    private NetheralavsFluid() {
        super(PROPERTIES);
    }

    public static class Source extends NetheralavsFluid {
        @Override
        public int getAmount(FluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }
    }

    public static class Flowing extends NetheralavsFluid {
        @Override
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        @Override
        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
