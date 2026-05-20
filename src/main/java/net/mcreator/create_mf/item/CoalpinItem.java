package net.mcreator.create_mf.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class CoalpinItem
extends Item {
    public CoalpinItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
    }
}

