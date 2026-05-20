package net.mcreator.create_mf.procedures;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class GravitronprocedureProcedure {
    private static final Set<UUID> GRAVITRON_GRANTED = new HashSet<UUID>();

    public static void execute(LevelAccessor levelAccessor, double d, double d2, double d3, Entity entity) {
        boolean bl;
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player)entity;
        if (player.getAbilities().instabuild || player.isSpectator()) {
            GRAVITRON_GRANTED.remove(player.getUUID());
            return;
        }
        ItemStack itemStack = player.getOffhandItem();
        boolean bl2 = itemStack.getItem() == CreateMfModItems.GRAVITRON.get();
        boolean bl3 = bl = bl2 && itemStack.getMaxDamage() - itemStack.getDamageValue() > 1;
        if (bl2 && bl) {
            if (!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
                GRAVITRON_GRANTED.add(player.getUUID());
            }
            if (player.getAbilities().flying && levelAccessor instanceof ServerLevel) {
                ServerLevel serverLevel = (ServerLevel)levelAccessor;
                itemStack.hurtAndBreak(1, serverLevel, null, item -> {});
                serverLevel.sendParticles((ParticleOptions)ParticleTypes.END_ROD, d, d2, d3, 3, 0.0, 0.0, 0.0, 0.0);
            }
        } else if (GRAVITRON_GRANTED.remove(player.getUUID())) {
            player.getAbilities().mayfly = false;
            player.getAbilities().flying = false;
            player.onUpdateAbilities();
        }
    }
}

