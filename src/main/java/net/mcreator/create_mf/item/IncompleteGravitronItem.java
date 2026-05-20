package net.mcreator.create_mf.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class IncompleteGravitronItem
extends Item {
    public IncompleteGravitronItem() {
        super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
    }
}

