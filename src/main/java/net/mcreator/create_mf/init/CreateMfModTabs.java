package net.mcreator.create_mf.init;

import net.mcreator.create_mf.CreateMfMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class CreateMfModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMfMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_MF_TAB =
            REGISTRY.register("create_mf_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.create_mf.create_mf_tab"))
                    .icon(() -> new ItemStack(CreateMfModBlocks.GRAVITRON.get()))
                    .displayItems((parameters, tabData) -> {
                        CreateMfModItems.REGISTRY.getEntries().forEach(item ->
                                tabData.accept(item.get())
                        );
                    })
                    .build());
}
