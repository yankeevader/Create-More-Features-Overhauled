package net.mcreator.create_mf.init;

import net.mcreator.create_mf.CreateMfMod;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateMfModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMfMod.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_MORE_FEATURES_TAB =
            REGISTRY.register("create_more_features_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.create_mf.create_more_features_tab"))
                    .icon(() -> new ItemStack(CreateMfModItems.INCOMPLETE_GRAVITRON.get()))
                    .displayItems((parameters, tabData) -> {
                        tabData.accept(((Block) CreateMfModBlocks.SIGNALLING.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.DIMMABLE_ROSE_QUARTZ_LAMP.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING_WALL.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING_FENCE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING_TRAPDOOR.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_DECORATIVE_CASING_FENCE_GATE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.REFINED_RADIANCE_CASING.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.REFINED_RADIANCE_CASING_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.REFINED_RADIANCE_CASING_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.ANDESITE_CASING_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.ANDESITE_CASING_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.BRASS_CASING_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.BRASS_CASING_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_CASING_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.RAILWAY_CASING_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.COPPER_CASING_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.COPPER_CASING_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.REFINED_RADIANCE_BLOCK.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.COPPER_PLATING.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.BAYERS_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SELLER_OF_MECHANISMS_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SHOWCASE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.VELCRO.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.FLYING_BLOCK.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.ENGINEERS_DESK.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CONTRAPTIONS_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.PIPE_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.LINEMAN_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.WORKSHOPS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SUNDRIES_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.MASTER_CONTRAPTIONS_TABLE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SULFUR_BASALT_ORE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SULFUR_ORE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SULFUR_LAMP.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.SULFUR_LAMP_UP.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.BLOCK_OF_SHADES.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.COLOR_TIME_BLOCK.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_WOOD.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_LOG.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_PLANKS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_LEAVES.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_STAIRS.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_SLAB.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_FENCE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_FENCE_GATE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_PRESSURE_PLATE.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTURAL_BUTTON.get()).asItem());
                        tabData.accept(((Block) CreateMfModBlocks.CULTIVATED_TREE_SAPLING.get()).asItem());

                        tabData.accept(CreateMfModItems.NETHERALAVS_BUCKET.get());
                        tabData.accept(CreateMfModItems.REFINED_RADIANCE_STORAGE.get());
                        tabData.accept(CreateMfModItems.DARK_STORAGE.get());
                        tabData.accept(CreateMfModItems.VOID_STORAGE.get());
                        tabData.accept(CreateMfModItems.SULFUR.get());
                        tabData.accept(CreateMfModItems.COAL_PIN.get());
                        tabData.accept(CreateMfModItems.SALTPETER.get());
                        tabData.accept(CreateMfModItems.REFINED_RADIANCE.get());
                        tabData.accept(CreateMfModItems.REFINED_RADIANCE_PICKAXE.get());
                        tabData.accept(CreateMfModItems.REFINED_RADIANCE_AXE.get());
                        tabData.accept(CreateMfModItems.REFINED_RADIANCE_SHOVEL.get());
                        tabData.accept(CreateMfModItems.REFINED_RADIANCE_SWORD.get());
                        tabData.accept(CreateMfModItems.GRAVITRON_BASE.get());
                        tabData.accept(CreateMfModItems.INCOMPLETE_GRAVITRON.get());
                        tabData.accept(CreateMfModItems.GRAVITRON.get());
                        tabData.accept(CreateMfModItems.INCOMPLETE_DIAMOND.get());
                        tabData.accept(CreateMfModItems.GRAPHITE.get());
                        tabData.accept(CreateMfModItems.PIECES_OF_GRAPHITE.get());
                        tabData.accept(CreateMfModItems.SHADOW_INGOT.get());
                    })
                    .build());
}
