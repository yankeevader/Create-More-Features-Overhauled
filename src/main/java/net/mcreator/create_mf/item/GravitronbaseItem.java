package net.mcreator.create_mf.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class GravitronbaseItem
extends Item {
    public GravitronbaseItem() {
        super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
    }
}

