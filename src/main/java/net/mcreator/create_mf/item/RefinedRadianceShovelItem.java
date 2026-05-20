package net.mcreator.create_mf.item;

import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;

public class RefinedRadianceShovelItem
extends ShovelItem {
    private static final Tier TOOL_TIER = new Tier(){

        public int getUses() {
            return 2436;
        }

        public float getSpeed() {
            return 21.0f;
        }

        public float getAttackDamageBonus() {
            return 0.0f;
        }

        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
        }

        public int getEnchantmentValue() {
            return 23;
        }

        public Ingredient getRepairIngredient() {
            return Ingredient.of((ItemStack[])new ItemStack[]{new ItemStack((ItemLike)CreateMfModItems.REFINED_RADIANCE.get())});
        }
    };

    public RefinedRadianceShovelItem() {
        super(TOOL_TIER, new Item.Properties().attributes(DiggerItem.createAttributes((Tier)TOOL_TIER, (float)6.0f, (float)-2.6f)).fireResistant());
    }
}

