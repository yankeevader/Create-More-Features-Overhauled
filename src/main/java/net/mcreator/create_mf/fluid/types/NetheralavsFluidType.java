package net.mcreator.create_mf.fluid.types;

import net.mcreator.create_mf.CreateMfMod;
import net.mcreator.create_mf.init.CreateMfModFluidTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.PathType;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

@EventBusSubscriber(modid = CreateMfMod.MODID)
public class NetheralavsFluidType
extends FluidType {
    public NetheralavsFluidType() {
        super(FluidType.Properties.create().canSwim(false).canDrown(false).pathType(PathType.LAVA).adjacentPathType(null).motionScale(0.0105).lightLevel(5).temperature(50000).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).sound(SoundActions.BUCKET_EMPTY, (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"item.bucket.fill_lava"))).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }

    @SubscribeEvent
    public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions(){
            private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse((String)"create_mf:block/netheralavs_fluid");
            private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse((String)"create_mf:block/netheralavs_fluid");

            public ResourceLocation getStillTexture() {
                return STILL_TEXTURE;
            }

            public ResourceLocation getFlowingTexture() {
                return FLOWING_TEXTURE;
            }
        }, new FluidType[]{(FluidType)CreateMfModFluidTypes.NETHERALAVS_TYPE.get()});
    }
}
