package net.mcreator.create_mf.client.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiEvent;

@EventBusSubscriber(value={Dist.CLIENT})
public class WorkedOverlay {
    @SubscribeEvent(priority=EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getGuiGraphics().guiWidth();
        int h = event.getGuiGraphics().guiHeight();
        Level world = null;
        double x = 0.0;
        double y = 0.0;
        double z = 0.0;
        LocalPlayer entity = Minecraft.getInstance().player;
        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY();
            z = entity.getZ();
        }
        event.getGuiGraphics().drawString(Minecraft.getInstance().font, (Component)Component.translatable((String)"gui.create_mf.worked.label_work_in_progress"), 0, h - -5, -6842473, false);
    }
}

