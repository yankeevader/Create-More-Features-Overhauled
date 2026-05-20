package net.mcreator.create_mf.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class SulfurItem
extends Item {
    public SulfurItem() {
        super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
    }
}

