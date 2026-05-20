package net.mcreator.create_mf.procedures;

import javax.annotation.Nullable;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber
public class GravitronDeathProcedure {
    @SubscribeEvent
    public static void onEntityDeath(LivingDeathEvent event) {
        if (event.getEntity() != null) {
            GravitronDeathProcedure.execute((Event)event);
        }
    }

    public static void execute() {
        GravitronDeathProcedure.execute(null);
    }

    private static void execute(@Nullable Event event) {
    }
}

