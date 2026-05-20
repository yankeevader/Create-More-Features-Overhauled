package net.mcreator.create_mf.fluid;

import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.mcreator.create_mf.init.CreateMfModFluidTypes;
import net.mcreator.create_mf.init.CreateMfModFluids;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;

public abstract class NetheralavsFluid
extends BaseFlowingFluid {
    public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> (FluidType)CreateMfModFluidTypes.NETHERALAVS_TYPE.get(), () -> (Fluid)CreateMfModFluids.NETHERALAVS.get(), () -> (Fluid)CreateMfModFluids.FLOWING_NETHERALAVS.get()).explosionResistance(100.0f).tickRate(7).levelDecreasePerBlock(2).slopeFindDistance(6).bucket(() -> (Item)CreateMfModItems.NETHERALAVS_BUCKET.get()).block(() -> (LiquidBlock)CreateMfModBlocks.NETHERALAVS.get());

    private NetheralavsFluid() {
        super(PROPERTIES);
    }

    public ParticleOptions getDripParticle() {
        return ParticleTypes.LARGE_SMOKE;
    }

    public static class Flowing
    extends NetheralavsFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(new Property[]{LEVEL});
        }

        public int getAmount(FluidState state) {
            return (Integer)state.getValue((Property)LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }

    public static class Source
    extends NetheralavsFluid {
        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }
    }
}

