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
    private static final Map<String, ProfessionPoiType> POI_TYPES = new HashMap<>();

    public static final DeferredRegister<VillagerProfession> PROFESSIONS = DeferredRegister.create(Registries.VILLAGER_PROFESSION, CreateMfMod.MODID);

    public static final DeferredHolder<VillagerProfession, VillagerProfession> BUYER_OF_MECHANISMS = registerProfession("buyer_of_mechanisms", () -> (Block) CreateMfModBlocks.BAYERS_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.loom.select_pattern")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> SELLEROFMECHANISMS = registerProfession("sellerofmechanisms", () -> (Block) CreateMfModBlocks.SELLER_OF_MECHANISMS_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.cartography_table.take_result")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> CONFECTIONER = registerProfession("confectioner", () -> (Block) CreateMfModBlocks.SHOWCASE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.dye.use")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> ENGINEER = registerProfession("engineer", () -> (Block) CreateMfModBlocks.ENGINEERS_DESK.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.spyglass.use")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> PIPEFITTER = registerProfession("pipefitter", () -> (Block) CreateMfModBlocks.PIPE_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ambient.underwater.loop.additions.ultra_rare")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> EXCHANGEROFMECHANISMS = registerProfession("exchangerofmechanisms", () -> (Block) CreateMfModBlocks.WORKSHOPS.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.trade")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> CONTRAPTIONSTRADER = registerProfession("contraptionstrader", () -> (Block) CreateMfModBlocks.CONTRAPTIONS_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.sweet_berry_bush.pick_berries")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> LINEMAN = registerProfession("lineman", () -> (Block) CreateMfModBlocks.LINEMAN_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.minecart.riding")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> SUNDRIESSELLER = registerProfession("sundriesseller", () -> (Block) CreateMfModBlocks.SUNDRIES_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.villager.work_cartographer")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> GIZMOMASTER = registerProfession("gizmomaster", () -> (Block) CreateMfModBlocks.MASTER_CONTRAPTIONS_TABLE.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("item.armor.equip_chain")));
    public static final DeferredHolder<VillagerProfession, VillagerProfession> POSTMAN = registerProfession("postman", () -> (Block) CreateMfModBlocks.REFINED_RADIANCE_CASING.get(), () -> (SoundEvent) BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("ui.cartography_table.take_result")));

    private static DeferredHolder<VillagerProfession, VillagerProfession> registerProfession(String name, Supplier<Block> block, Supplier<SoundEvent> soundEvent) {
        POI_TYPES.put(name, new ProfessionPoiType(block, null));
        return PROFESSIONS.register(name, () -> {
            Predicate<Holder<PoiType>> poiPredicate = poiTypeHolder -> POI_TYPES.get(name).poiType != null && poiTypeHolder.value() == POI_TYPES.get(name).poiType.value();
            return new VillagerProfession(name, poiPredicate, poiPredicate, ImmutableSet.of(), ImmutableSet.of(), soundEvent.get());
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
                    CreateMfMod.LOGGER.error("Skipping villager profession " + name + " that uses POI block " + block + " that is already in use by " + existingCheck);
                    continue;
                }

                PoiType poiType = new PoiType(ImmutableSet.copyOf(block.getStateDefinition().getPossibleStates()), 1, 1);
                registerHelper.register(ResourceLocation.fromNamespaceAndPath(CreateMfMod.MODID, name), poiType);
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
