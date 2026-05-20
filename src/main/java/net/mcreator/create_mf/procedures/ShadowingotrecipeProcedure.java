package net.mcreator.create_mf.procedures;

import java.util.function.Predicate;
import javax.annotation.Nullable;
import net.mcreator.create_mf.CreateMfMod;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.items.ItemHandlerHelper;

@EventBusSubscriber
public class ShadowingotrecipeProcedure {
    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Pre event) {
        ShadowingotrecipeProcedure.execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
    }

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        ShadowingotrecipeProcedure.execute(null, world, x, y, z, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null || entity.getY() >= 0.0 || getDimension(world) != Level.END) {
            return;
        }

        ItemStack mainHand = entity instanceof LivingEntity livingEntity ? livingEntity.getMainHandItem() : ItemStack.EMPTY;
        if (mainHand.getItem() == CreateMfModItems.REFINED_RADIANCE.get()) {
            sendAsh(world, x, y, z);
            CreateMfMod.queueServerWork(80, () -> sendAsh(world, x, y, z));
            sendAsh(world, x, y, z);
            convertHeldStack(entity, true);
        }

        ItemStack offHand = entity instanceof LivingEntity livingEntity ? livingEntity.getOffhandItem() : ItemStack.EMPTY;
        if (offHand.getItem() == CreateMfModItems.REFINED_RADIANCE.get()) {
            sendAsh(world, x, y, z);
            CreateMfMod.queueServerWork(80, () -> {
                sendAsh(world, x, y, z);
                convertHeldStack(entity, false);
            });
            sendAsh(world, x, y, z);
        }
    }

    private static ResourceKey<Level> getDimension(LevelAccessor world) {
        if (world instanceof Level level) {
            return level.dimension();
        }
        if (world instanceof WorldGenLevel worldGenLevel) {
            return worldGenLevel.getLevel().dimension();
        }
        return Level.OVERWORLD;
    }

    private static void sendAsh(LevelAccessor world, double x, double y, double z) {
        if (world instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles((ParticleOptions)ParticleTypes.ASH, x, y, z, 3, 0.1, 0.1, 0.1, 0.1);
        }
    }

    private static void convertHeldStack(Entity entity, boolean mainHand) {
        if (!(entity instanceof Player player)) {
            return;
        }

        ItemStack heldStack = entity instanceof LivingEntity livingEntity
                ? (mainHand ? livingEntity.getMainHandItem() : livingEntity.getOffhandItem())
                : ItemStack.EMPTY;

        ItemStack stackToRemove = new ItemStack((ItemLike)CreateMfModItems.REFINED_RADIANCE.get());
        Predicate<ItemStack> predicate = stack -> stackToRemove.getItem() == stack.getItem();
        Inventory inventory = player.getInventory();
        inventory.clearOrCountMatchingItems(predicate, heldStack.getCount(), (Container)player.inventoryMenu.getCraftSlots());

        ItemStack resultStack = new ItemStack((ItemLike)CreateMfModItems.SHADOW_INGOT.get()).copy();
        resultStack.setCount(heldStack.getCount());
        ItemHandlerHelper.giveItemToPlayer(player, resultStack);
    }
}
