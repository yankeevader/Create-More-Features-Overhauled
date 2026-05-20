package net.mcreator.create_mf.init;

import net.mcreator.create_mf.fluid.NetheralavsFluid;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateMfModFluids {
    public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create((Registry)BuiltInRegistries.FLUID, (String)"create_mf");
    public static final DeferredHolder<Fluid, FlowingFluid> NETHERALAVS = REGISTRY.register("netheralavs", () -> new NetheralavsFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_NETHERALAVS = REGISTRY.register("flowing_netheralavs", () -> new NetheralavsFluid.Flowing());

    @EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
    public static class FluidsClientSideHandler {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer((Fluid)((Fluid)NETHERALAVS.get()), (RenderType)RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer((Fluid)((Fluid)FLOWING_NETHERALAVS.get()), (RenderType)RenderType.translucent());
        }
    }
}

