package net.mcreator.create_mf.procedures;

import net.minecraft.world.entity.Entity;

public class Netheralavs_dangerProcedure {
    public static void execute(Entity entity) {
        if (entity == null) {
            return;
        }
        entity.igniteForSeconds(9.0f);
    }
}

