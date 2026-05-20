package net.mcreator.create_mf.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class ShadowIngotItem
extends Item {
    public ShadowIngotItem() {
        super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
    }
}

