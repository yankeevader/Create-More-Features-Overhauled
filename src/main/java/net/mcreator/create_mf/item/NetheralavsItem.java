package net.mcreator.create_mf.item;

import net.mcreator.create_mf.init.CreateMfModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.material.Fluid;

public class NetheralavsItem
extends BucketItem {
    public NetheralavsItem() {
        super((Fluid)CreateMfModFluids.NETHERALAVS.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON));
    }
}

