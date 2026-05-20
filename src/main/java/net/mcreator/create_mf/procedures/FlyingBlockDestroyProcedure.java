package net.mcreator.create_mf.procedures;

import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.items.ItemHandlerHelper;

public class FlyingBlockDestroyProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }
        if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = new ItemStack((ItemLike)CreateMfModBlocks.FLYING_BLOCK.get()).copy();
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer((Player)_player, (ItemStack)_setstack);
        }
    }
}

