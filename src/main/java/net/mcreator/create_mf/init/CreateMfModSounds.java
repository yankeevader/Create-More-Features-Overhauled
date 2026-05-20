package net.mcreator.create_mf.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateMfModSounds {
    public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create((ResourceKey)Registries.SOUND_EVENT, (String)"create_mf");
    public static final DeferredHolder<SoundEvent, SoundEvent> SIGNALLING = REGISTRY.register("signalling", () -> SoundEvent.createVariableRangeEvent((ResourceLocation)ResourceLocation.fromNamespaceAndPath((String)"create_mf", (String)"signalling")));
}

