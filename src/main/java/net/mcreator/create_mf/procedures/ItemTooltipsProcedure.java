package net.mcreator.create_mf.procedures;

import java.util.List;
import javax.annotation.Nullable;
import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

@EventBusSubscriber(value={Dist.CLIENT})
public class ItemTooltipsProcedure {
    @OnlyIn(value=Dist.CLIENT)
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemTooltipsProcedure.execute((Event)event, event.getItemStack(), event.getToolTip());
    }

    public static void execute(ItemStack itemstack, List<Component> tooltip) {
        ItemTooltipsProcedure.execute(null, itemstack, tooltip);
    }

    private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
        if (tooltip == null) {
            return;
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.SIGNALLING.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_signalling").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.DIMMABLE_ROSE_QUARTZ_LAMP.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_lamp").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.VELCRO.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_velcro").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.FLYING_BLOCK.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_flying_block").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.BLOCK_OF_SHADES.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_block_of_shades").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.COLOR_TIME_BLOCK.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_color_time_block").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == CreateMfModItems.GRAPHITE.get()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_graphite").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == CreateMfModItems.GRAVITRON.get()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_gravitron").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == CreateMfModItems.NETHERALAVS_BUCKET.get()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_lava").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == ((Block)CreateMfModBlocks.CULTIVATED_TREE_SAPLING.get()).asItem()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_cultural_sapling").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.is(ItemTags.create((ResourceLocation)ResourceLocation.parse((String)"forge:work_blocks")))) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_work_blocks").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == CreateMfModItems.SHADOW_INGOT.get()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_shadow_ingot").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == CreateMfModItems.REFINED_RADIANCE_STORAGE.get() || itemstack.getItem() == CreateMfModItems.DARK_STORAGE.get() || itemstack.getItem() == CreateMfModItems.VOID_STORAGE.get()) {
            if (Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages").getString()));
            }
            if (!Screen.hasShiftDown()) {
                tooltip.add((Component)Component.literal((String)Component.translatable((String)"msg.create_more_features.item_tooltip_summary").getString()));
            }
        }
        if (itemstack.getItem() == CreateMfModItems.REFINED_RADIANCE_STORAGE.get()) {
            tooltip.add((Component)Component.literal((String)(Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages_water_level").getString() + Math.round(((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDouble("fluid_water")) + "/3")));
            tooltip.add((Component)Component.literal((String)(Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages_lava_level").getString() + Math.round(((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDouble("fluid_lava")) + "/3")));
        }
        if (itemstack.getItem() == CreateMfModItems.DARK_STORAGE.get()) {
            tooltip.add((Component)Component.literal((String)(Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages_water_level").getString() + Math.round(((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDouble("fluid_water")) + "/5")));
            tooltip.add((Component)Component.literal((String)(Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages_lava_level").getString() + Math.round(((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDouble("fluid_lava")) + "/5")));
        }
        if (itemstack.getItem() == CreateMfModItems.VOID_STORAGE.get()) {
            tooltip.add((Component)Component.literal((String)(Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages_water_level").getString() + Math.round(((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDouble("fluid_water")) + "/10")));
            tooltip.add((Component)Component.literal((String)(Component.translatable((String)"msg.create_more_features.item_tooltip_fluids_storages_lava_level").getString() + Math.round(((CustomData)itemstack.getOrDefault(DataComponents.CUSTOM_DATA, (Object)CustomData.EMPTY)).copyTag().getDouble("fluid_lava")) + "/10")));
        }
    }
}

