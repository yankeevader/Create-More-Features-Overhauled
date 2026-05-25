package net.mcreator.create_mf.init;

import net.mcreator.create_mf.fluid.NetheralavsFluid;
import net.mcreator.create_mf.CreateMfMod;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;

public class CreateMfModFluids {
    public static final DeferredRegister<Fluid> REGISTRY =
            DeferredRegister.create(BuiltInRegistries.FLUID, CreateMfMod.MODID);

    public static final DeferredHolder<Fluid, FlowingFluid> NETHERALAVS =
            REGISTRY.register("netheralavs", NetheralavsFluid.Source::new);

    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_NETHERALAVS =
            REGISTRY.register("flowing_netheralavs", NetheralavsFluid.Flowing::new);
}
