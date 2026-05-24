package net.mcreator.create_mf.init;

import net.mcreator.create_mf.CreateMfMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

@EventBusSubscriber(modid = CreateMfMod.MODID)
public final class CmfVillagerNameCleanup {
    private CmfVillagerNameCleanup() {
    }

    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
        clearPersonalNameIfCreateMfVillager(event.getEntity());
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        clearPersonalNameIfCreateMfVillager(event.getTarget());
    }

    private static void clearPersonalNameIfCreateMfVillager(Entity entity) {
        if (!(entity instanceof Villager villager)) {
            return;
        }

        if (!isCreateMfProfession(villager)) {
            return;
        }

        if (villager.hasCustomName()) {
            villager.setCustomName(null);
        }

        if (villager.isCustomNameVisible()) {
            villager.setCustomNameVisible(false);
        }
    }

    private static boolean isCreateMfProfession(Villager villager) {
        VillagerProfession profession = villager.getVillagerData().getProfession();
        ResourceLocation professionId = BuiltInRegistries.VILLAGER_PROFESSION.getKey(profession);

        return professionId != null && CreateMfMod.MODID.equals(professionId.getNamespace());
    }
}
