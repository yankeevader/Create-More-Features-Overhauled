package net.mcreator.create_mf.init;

import net.mcreator.create_mf.CreateMfMod;
import net.mcreator.create_mf.fluid.types.NetheralavsFluidType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredFluid;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateMfModFluids {
    public static final DeferredRegister.FluidTypes REGISTRY = DeferredRegister.createFluidTypes((String)"create_mf");
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(net.neoforged.neoforge.registries.NeoForgeRegistries.FLUID_TYPES, (String)"create_mf");
    public static final DeferredRegister<FlowingFluid> FLUIDS = DeferredRegister.createFluids((String)"create_mf");

    public static final DeferredFluid<FlowingFluid> NETHERALAVS = FLUIDS.register("netheralavs", () -> new BaseFlowingFluid.Source(CreateMfModFluids.NETHERALAVS_PROPERTIES));
    public static final DeferredFluid<FlowingFluid> FLOWING_NETHERALAVS = FLUIDS.register("flowing_netheralavs", () -> new BaseFlowingFluid.Flowing(CreateMfModFluids.NETHERALAVS_PROPERTIES));

    public static final FluidType.Properties NETHERALAVS_TYPE_PROPERTIES = FluidType.Properties.create()
        .descriptionId("block.create_mf.netheralavs")
        .lightLevel(5)
        .density(1000)
        .viscosity(1000)
        .temperature(50000);

    public static final DeferredRegister.Items FLUID_BUCKETS = DeferredRegister.createItems((String)"create_mf");

    public static final DeferredRegister.Blocks FLUID_BLOCKS = DeferredRegister.createBlocks((String)"create_mf");

    public static final net.neoforged.neoforge.registries.DeferredHolder<FluidType, FluidType> NETHERALAVS_TYPE = FLUID_TYPES.register("netheralavs", NetheralavsFluidType::new);

    public static final BaseFlowingFluid.Properties NETHERALAVS_PROPERTIES = new BaseFlowingFluid.Properties(
        () -> (FluidType)NETHERALAVS_TYPE.get(),
        () -> (FlowingFluid)NETHERALAVS.get(),
        () -> (FlowingFluid)FLOWING_NETHERALAVS.get()
    )
        .explosionResistance(100f)
        .bucket(() -> CreateMfModItems.NETHERALAVS_BUCKET.get())
        .block(() -> (net.minecraft.world.level.block.LiquidBlock)CreateMfModBlocks.NETHERALAVS.get());

    @EventBusSubscriber(modid = CreateMfMod.MODID, value = Dist.CLIENT)
    public static class FluidClientSideHandler {
    }
}
