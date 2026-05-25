package net.mcreator.create_mf.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class CreateMfModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, "create_mf");

	public static final DeferredHolder<SoundEvent, SoundEvent> SIGNALLING = REGISTRY.register("signalling", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("create_mf", "signalling")));
}
