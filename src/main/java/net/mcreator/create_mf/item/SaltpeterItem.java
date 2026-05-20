package net.mcreator.create_mf.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SaltpeterItem
extends Item {
    public SaltpeterItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}

