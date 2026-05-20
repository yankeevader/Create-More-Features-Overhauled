package net.mcreator.create_mf.init;

import net.mcreator.create_mf.fluid.types.NetheralavsFluidType;
import net.minecraft.core.Registry;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class CreateMfModFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create((Registry)NeoForgeRegistries.FLUID_TYPES, (String)"create_mf");
    public static final DeferredHolder<FluidType, FluidType> NETHERALAVS_TYPE = REGISTRY.register("netheralavs", () -> new NetheralavsFluidType());
}

