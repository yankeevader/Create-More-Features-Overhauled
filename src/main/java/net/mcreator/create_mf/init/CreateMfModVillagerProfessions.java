package net.mcreator.create_mf.init;

import com.google.common.collect.ImmutableSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.mcreator.create_mf.CreateMfMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.RegisterEvent;

@EventBusSubscriber(modid = CreateMfMod.MODID)
public class CreateMfModVillagerProfessions {
    private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<String, ProfessionPoiType>();
    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, "create_mf");
    public static final DeferredHolder<VillagerProfession, VillagerProfession> BUYER_OF_MECHANISMS = CreateMfModVillagerProfessions.registerProfession("buyer_of_mechanisms", () -> (Block)CreateMfModBlocks.BAYERS_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"ui.loom.select_pattern")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> SELLEROFMECHANISMS = CreateMfModVillagerProfessions.registerProfession("sellerofmechanisms", () -> (Block)CreateMfModBlocks.SELLER_OF_MECHANISMS_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"ui.cartography_table.take_result")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> CONFECTIONER = CreateMfModVillagerProfessions.registerProfession("confectioner", () -> (Block)CreateMfModBlocks.SHOWCASE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"item.dye.use")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> ENGINEER = CreateMfModVillagerProfessions.registerProfession("engineer", () -> (Block)CreateMfModBlocks.ENGINEERS_DESK.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"item.spyglass.use")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> PIPEFITTER = CreateMfModVillagerProfessions.registerProfession("pipefitter", () -> (Block)CreateMfModBlocks.PIPE_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"ambient.underwater.loop.additions.ultra_rare")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> EXCHANGEROFMECHANISMS = CreateMfModVillagerProfessions.registerProfession("exchangerofmechanisms", () -> (Block)CreateMfModBlocks.WORKSHOPS.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"entity.villager.trade")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> CONTRAPTIONSTRADER = CreateMfModVillagerProfessions.registerProfession("contraptionstrader", () -> (Block)CreateMfModBlocks.CONTRAPTIONS_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"block.sweet_berry_bush.pick_berries")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> LINEMAN = CreateMfModVillagerProfessions.registerProfession("lineman", () -> (Block)CreateMfModBlocks.LINEMAN_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"entity.minecart.riding")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> SUNDRIESSELLER = CreateMfModVillagerProfessions.registerProfession("sundriesseller", () -> (Block)CreateMfModBlocks.SUNDRIES_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"entity.villager.work_cartographer")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> GIZMOMASTER = CreateMfModVillagerProfessions.registerProfession("gizmomaster", () -> (Block)CreateMfModBlocks.MASTER_CONTRAPTIONS_TABLE.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"item.armor.equip_chain")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> POSTMAN = CreateMfModVillagerProfessions.registerProfession("postman", () -> (Block)CreateMfModBlocks.REFINED_RADIANCE_CASING.get(), () -> (SoundEvent)BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse((String)"ui.cartography_table.take_result")));

    private static DeferredHolder<VillagerProfession, VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
        POI_TYPES.put(name, new ProfessionPoiType(block, null));
        return PROFESSIONS.register(name, () -> {
            Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> CreateMfModVillagerProfessions.POI_TYPES.get(name).poiType != null && poiTypeHolder.value() == CreateMfModVillagerProfessions.POI_TYPES.get(name).poiType.value();
            return new VillagerProfession("create_mf:" + name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
        });
    }

    @SubscribeEvent
    public static void registerProfessionPointsOfInterest(RegisterEvent event) {
        event.register(Registries.POINT_OF_INTEREST_TYPE, registerHelper -> {
            for (Map.Entry<String, ProfessionPoiType> entry : POI_TYPES.entrySet()) {
                Block block = entry.getValue().block.get();
                String name = entry.getKey();
                Optional<Holder<PoiType>> existingCheck = PoiTypes.forState(block.defaultBlockState());
                if (existingCheck.isPresent()) {
                    CreateMfMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + String.valueOf(block) + " that is already in use by " + String.valueOf(existingCheck));
                    continue;
                }
                PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
                registerHelper.register(ResourceLocation.fromNamespaceAndPath("create_mf", name), poiType);
                entry.getValue().poiType = BuiltInRegistries.POINT_OF_INTEREST_TYPE.wrapAsHolder(poiType);
            }
        });
    }

    private static class ProfessionPoiType {
        final Supplier<Block> block;
        Holder<PoiType> poiType;

        ProfessionPoiType(Supplier<Block> block, Holder<PoiType> poiType) {
            this.block = block;
            this.poiType = poiType;
        }
    }
}
