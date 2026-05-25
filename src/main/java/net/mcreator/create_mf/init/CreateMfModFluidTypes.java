package net.mcreator.create_mf.init;

import net.mcreator.create_mf.CreateMfMod;

import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;

public class CreateMfModFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY =
            DeferredRegister.create(BuiltInRegistries.FLUID_TYPE, CreateMfMod.MODID);

    public static final DeferredHolder<FluidType, FluidType> NETHERALAVS_TYPE =
            REGISTRY.register("netheralavs", () -> new FluidType(
                    FluidType.Properties.create()
                            .lightLevel(10)
                            .density(15)
                            .viscosity(5)
                            .temperature(1000)
                            .sound(
                                    SoundActions.BUCKET_FILL,
                                    SoundEvents.BUCKET_FILL_LAVA
                            )
                            .sound(
                                    SoundActions.BUCKET_EMPTY,
                                    SoundEvents.BUCKET_EMPTY_LAVA
                            )
            ) {
                @Override
                public ResourceLocation getStillTexture() {
                    return ResourceLocation.fromNamespaceAndPath("create_mf", "block/netheralavs_still");
                }

                @Override
                public ResourceLocation getFlowingTexture() {
                    return ResourceLocation.fromNamespaceAndPath("create_mf", "block/netheralavs_flow");
                }
            });
}
