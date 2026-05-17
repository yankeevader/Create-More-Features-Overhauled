package net.mcreator.create_mf.procedures;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

@EventBusSubscriber
public class GravitronprocedureProcedure {
    private static final Set<UUID> GRAVITRON_GRANTED = new HashSet<>();

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (!(entity instanceof Player player)) {
            return;
        }

        // Do not interfere with vanilla creative/spectator flight.
        if (player.getAbilities().instabuild || player.isSpectator()) {
            GRAVITRON_GRANTED.remove(player.getUUID());
            return;
        }

        ItemStack offhand = player.getOffhandItem();
        boolean holdingGravitron = offhand.getItem() == CreateMfModItems.GRAVITRON.get();
        boolean nearlyBroken = holdingGravitron
                && (offhand.getMaxDamage() - offhand.getDamageValue()) <= 1;

        if (holdingGravitron && !nearlyBroken) {
            // Grant mayfly only when needed.
            if (!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }

            GRAVITRON_GRANTED.add(player.getUUID());

            // Only consume durability/hunger while actually flying, and only on the server side.
            if (player.getAbilities().flying && world instanceof ServerLevel level) {
                player.causeFoodExhaustion(0.02f);
                offhand.hurtAndBreak(1, level, null, item -> {});
                level.sendParticles(ParticleTypes.END_ROD, x, y, z, 3, 0, 0, 0, 0);
            }
        } else {
            // Only revoke flight if this procedure is the one that granted it.
            if (GRAVITRON_GRANTED.remove(player.getUUID())) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        GRAVITRON_GRANTED.remove(event.getEntity().getUUID());
    }
}
