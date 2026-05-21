package net.mcreator.create_mf.procedures;

import javax.annotation.Nullable;
import net.mcreator.create_mf.CreateMfMod;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(modid = CreateMfMod.MODID, value = Dist.CLIENT)
public class GravitronGravityOffProcedure {
    @SubscribeEvent
    public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
        PacketDistributor.sendToServer((CustomPacketPayload)new GravitronGravityOffMessage(), (CustomPacketPayload[])new CustomPacketPayload[0]);
        GravitronGravityOffProcedure.execute();
    }

    public static void execute() {
        GravitronGravityOffProcedure.execute(null);
    }

    private static void execute(@Nullable Event event) {
    }

    @EventBusSubscriber(modid = CreateMfMod.MODID)
    public record GravitronGravityOffMessage() implements CustomPacketPayload
    {
        public static final CustomPacketPayload.Type<GravitronGravityOffMessage> TYPE = new CustomPacketPayload.Type(ResourceLocation.fromNamespaceAndPath((String)"create_mf", (String)"procedure_gravitron_gravity_off"));
        public static final StreamCodec<RegistryFriendlyByteBuf, GravitronGravityOffMessage> STREAM_CODEC = StreamCodec.of((buffer, message) -> {}, buffer -> new GravitronGravityOffMessage());

        public CustomPacketPayload.Type<GravitronGravityOffMessage> type() {
            return TYPE;
        }

        public static void handleData(GravitronGravityOffMessage message, IPayloadContext context) {
            if (context.flow() == PacketFlow.SERVERBOUND) {
                context.enqueueWork(() -> {
                    if (!context.player().level().hasChunkAt(context.player().blockPosition())) {
                        return;
                    }
                    GravitronGravityOffProcedure.execute();
                }).exceptionally(e -> {
                    context.connection().disconnect((Component)Component.literal((String)e.getMessage()));
                    return null;
                });
            }
        }

        @SubscribeEvent
        public static void registerMessage(FMLCommonSetupEvent event) {
            CreateMfMod.addNetworkMessage(TYPE, STREAM_CODEC, GravitronGravityOffMessage::handleData);
        }
    }
}
