package net.mcreator.create_mf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import net.mcreator.create_mf.init.CreateMfModBlocks;
import net.mcreator.create_mf.init.CreateMfModFluidTypes;
import net.mcreator.create_mf.init.CreateMfModFluids;
import net.mcreator.create_mf.init.CreateMfModItems;
import net.mcreator.create_mf.init.CreateMfModSounds;
import net.mcreator.create_mf.init.CreateMfModTabs;
import net.mcreator.create_mf.init.CreateMfModVillagerProfessions;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Tuple;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(value="create_mf")
public class CreateMfMod {
    public static final Logger LOGGER = LogManager.getLogger(CreateMfMod.class);
    public static final String MODID = "create_mf";
    private static boolean networkingRegistered = false;
    private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();
    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public CreateMfMod(IEventBus modEventBus) {
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::registerNetworking);
        CreateMfModSounds.REGISTRY.register(modEventBus);
        CreateMfModBlocks.REGISTRY.register(modEventBus);
        CreateMfModItems.REGISTRY.register(modEventBus);
        CreateMfModTabs.REGISTRY.register(modEventBus);
        CreateMfModVillagerProfessions.PROFESSIONS.register(modEventBus);
        CreateMfModFluids.REGISTRY.register(modEventBus);
        CreateMfModFluidTypes.REGISTRY.register(modEventBus);
    }

    public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? super RegistryFriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
        if (networkingRegistered) {
            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
        }
        MESSAGES.put(id, new NetworkMessage<>(reader, handler));
    }

    private void registerNetworking(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(MODID);
        MESSAGES.forEach((id, networkMessage) -> registerMessage(registrar, id, networkMessage));
        networkingRegistered = true;
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private static <T extends CustomPacketPayload> void registerMessage(PayloadRegistrar registrar, CustomPacketPayload.Type<?> id, NetworkMessage<?> networkMessage) {
        registrar.playBidirectional((CustomPacketPayload.Type<T>) id, (StreamCodec<? super RegistryFriendlyByteBuf, T>) networkMessage.reader(), (IPayloadHandler<T>) networkMessage.handler());
    }

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
            workQueue.add(new Tuple<>(action, tick));
        }
    }

    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {
        ArrayList<Tuple<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setB(work.getB() - 1);
            if (work.getB() == 0) {
                actions.add(work);
            }
        });
        actions.forEach(e -> e.getA().run());
        workQueue.removeAll(actions);
    }

    private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? super RegistryFriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
    }
}
