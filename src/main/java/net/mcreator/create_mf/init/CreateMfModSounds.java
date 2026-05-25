package net.mcreator.create_mf.init;

import net.mcreator.create_mf.CreateMfMod;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public class CreateMfModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY =
            DeferredRegister.create(Registries.SOUND_EVENT, CreateMfMod.MODID);

    public static final DeferredHolder<SoundEvent, SoundEvent> FLYING =
            REGISTRY.register(
                    "flying",
                    () -> SoundEvent.createVariableRangeEvent(
                            ResourceLocation.fromNamespaceAndPath(CreateMfMod.MODID, "flying")
                    )
            );
}
