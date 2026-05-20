package net.mcreator.create_mf.item;

import net.mcreator.create_mf.procedures.RefinedRadianceStorageProcedureProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;

public class RefinedRadianceStorageItem
extends Item {
    public RefinedRadianceStorageItem() {
        super(new Item.Properties().durability(3).rarity(Rarity.COMMON));
    }

    public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
        InteractionResultHolder ar = super.use(world, entity, hand);
        RefinedRadianceStorageProcedureProcedure.execute((LevelAccessor)world, entity.getX(), entity.getY(), entity.getZ(), (Entity)entity, (ItemStack)ar.getObject());
        return ar;
    }
}

