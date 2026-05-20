package net.mcreator.create_mf.init;

import net.mcreator.create_mf.block.AndesitecasingslabBlock;
import net.mcreator.create_mf.block.AndesitecasingstairsBlock;
import net.mcreator.create_mf.block.BayerstableBlock;
import net.mcreator.create_mf.block.BlockOfShadesBlock;
import net.mcreator.create_mf.block.BrasscasingslabBlock;
import net.mcreator.create_mf.block.BrasscasingstairsBlock;
import net.mcreator.create_mf.block.ColortimeblockBlock;
import net.mcreator.create_mf.block.ContraptionstableBlock;
import net.mcreator.create_mf.block.CopperCasingSlabBlock;
import net.mcreator.create_mf.block.CopperCasingStairsBlock;
import net.mcreator.create_mf.block.CopperplatingBlock;
import net.mcreator.create_mf.block.CultivatedTreeSaplingBlock;
import net.mcreator.create_mf.block.CulturalButtonBlock;
import net.mcreator.create_mf.block.CulturalFenceBlock;
import net.mcreator.create_mf.block.CulturalFenceGateBlock;
import net.mcreator.create_mf.block.CulturalLeavesBlock;
import net.mcreator.create_mf.block.CulturalLogBlock;
import net.mcreator.create_mf.block.CulturalPlanksBlock;
import net.mcreator.create_mf.block.CulturalPressurePlateBlock;
import net.mcreator.create_mf.block.CulturalSlabBlock;
import net.mcreator.create_mf.block.CulturalStairsBlock;
import net.mcreator.create_mf.block.CulturalWoodBlock;
import net.mcreator.create_mf.block.DimmablerosequartzlampBlock;
import net.mcreator.create_mf.block.EngineersdeskBlock;
import net.mcreator.create_mf.block.FlyingBlockBlock;
import net.mcreator.create_mf.block.HoneycombCollectorBlock;
import net.mcreator.create_mf.block.IncompletedimmablerosequartzlampBlock;
import net.mcreator.create_mf.block.IncompleterailwaydecorativecasingBlock;
import net.mcreator.create_mf.block.IncompletesignallingBlock;
import net.mcreator.create_mf.block.LinemantableBlock;
import net.mcreator.create_mf.block.MastercontraptionstableBlock;
import net.mcreator.create_mf.block.NetheralavsBlock;
import net.mcreator.create_mf.block.PipetableBlock;
import net.mcreator.create_mf.block.RailwaycasingslabBlock;
import net.mcreator.create_mf.block.RailwaycasingstairsBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingfancegateBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingfenceBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingslabBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingstairsBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingtrapdoorBlock;
import net.mcreator.create_mf.block.RailwaydecorativecasingwallBlock;
import net.mcreator.create_mf.block.RefinedradianceblockBlock;
import net.mcreator.create_mf.block.RefinedradiancecasingBlock;
import net.mcreator.create_mf.block.RefinedradiancecasingslabBlock;
import net.mcreator.create_mf.block.RefinedradiancecasingstairsBlock;
import net.mcreator.create_mf.block.SellerofmechanismstableBlock;
import net.mcreator.create_mf.block.ShowcaseBlock;
import net.mcreator.create_mf.block.SignallingBlock;
import net.mcreator.create_mf.block.SulfurbasaltoreBlock;
import net.mcreator.create_mf.block.SulfurlampBlock;
import net.mcreator.create_mf.block.SulfurlampupBlock;
import net.mcreator.create_mf.block.SulfuroreBlock;
import net.mcreator.create_mf.block.SundriestableBlock;
import net.mcreator.create_mf.block.VelcroBlock;
import net.mcreator.create_mf.block.WorkshopsBlock;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreateMfModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks((String)"create_mf");
    public static final DeferredBlock<Block> SIGNALLING = REGISTRY.register("signalling", SignallingBlock::new);
    public static final DeferredBlock<Block> DIMMABLE_ROSE_QUARTZ_LAMP = REGISTRY.register("dimmable_rose_quartz_lamp", DimmablerosequartzlampBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING = REGISTRY.register("railway_decorative_casing", RailwaydecorativecasingBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING_SLAB = REGISTRY.register("railway_decorative_casing_slab", RailwaydecorativecasingslabBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING_STAIRS = REGISTRY.register("railway_decorative_casing_stairs", RailwaydecorativecasingstairsBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING_WALL = REGISTRY.register("railway_decorative_casing_wall", RailwaydecorativecasingwallBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING_FENCE = REGISTRY.register("railway_decorative_casing_fence", RailwaydecorativecasingfenceBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING_TRAPDOOR = REGISTRY.register("railway_decorative_casing_trapdoor", RailwaydecorativecasingtrapdoorBlock::new);
    public static final DeferredBlock<Block> RAILWAY_DECORATIVE_CASING_FENCE_GATE = REGISTRY.register("railway_decorative_casing_fence_gate", RailwaydecorativecasingfancegateBlock::new);
    public static final DeferredBlock<Block> REFINED_RADIANCE_CASING = REGISTRY.register("refined_radiance_casing", RefinedradiancecasingBlock::new);
    public static final DeferredBlock<Block> REFINED_RADIANCE_CASING_SLAB = REGISTRY.register("refined_radiance_casing_slab", RefinedradiancecasingslabBlock::new);
    public static final DeferredBlock<Block> REFINED_RADIANCE_CASING_STAIRS = REGISTRY.register("refined_radiance_casing_stairs", RefinedradiancecasingstairsBlock::new);
    public static final DeferredBlock<Block> ANDESITE_CASING_SLAB = REGISTRY.register("andesite_casing_slab", AndesitecasingslabBlock::new);
    public static final DeferredBlock<Block> ANDESITE_CASING_STAIRS = REGISTRY.register("andesite_casing_stairs", AndesitecasingstairsBlock::new);
    public static final DeferredBlock<Block> BRASS_CASING_SLAB = REGISTRY.register("brass_casing_slab", BrasscasingslabBlock::new);
    public static final DeferredBlock<Block> BRASS_CASING_STAIRS = REGISTRY.register("brass_casing_stairs", BrasscasingstairsBlock::new);
    public static final DeferredBlock<Block> RAILWAY_CASING_SLAB = REGISTRY.register("railway_casing_slab", RailwaycasingslabBlock::new);
    public static final DeferredBlock<Block> RAILWAY_CASING_STAIRS = REGISTRY.register("railway_casing_stairs", RailwaycasingstairsBlock::new);
    public static final DeferredBlock<Block> REFINED_RADIANCE_BLOCK = REGISTRY.register("refined_radiance_block", RefinedradianceblockBlock::new);
    public static final DeferredBlock<Block> COPPER_PLATING = REGISTRY.register("copper_plating", CopperplatingBlock::new);
    public static final DeferredBlock<Block> INCOMPLETE_DIMMABLE_ROSE_QUARTZ_LAMP = REGISTRY.register("incomplete_dimmable_rose_quartz_lamp", IncompletedimmablerosequartzlampBlock::new);
    public static final DeferredBlock<Block> INCOMPLETE_RAILWAY_DECORATIVE_CASING = REGISTRY.register("incomplete_railway_decorative_casing", IncompleterailwaydecorativecasingBlock::new);
    public static final DeferredBlock<Block> INCOMPLETE_SIGNALLING = REGISTRY.register("incomplete_signalling", IncompletesignallingBlock::new);
    public static final DeferredBlock<Block> BAYERS_TABLE = REGISTRY.register("bayers_table", BayerstableBlock::new);
    public static final DeferredBlock<Block> SELLER_OF_MECHANISMS_TABLE = REGISTRY.register("seller_of_mechanisms_table", SellerofmechanismstableBlock::new);
    public static final DeferredBlock<Block> SHOWCASE = REGISTRY.register("showcase", ShowcaseBlock::new);
    public static final DeferredBlock<Block> VELCRO = REGISTRY.register("velcro", VelcroBlock::new);
    public static final DeferredBlock<Block> FLYING_BLOCK = REGISTRY.register("flying_block", FlyingBlockBlock::new);
    public static final DeferredBlock<Block> ENGINEERS_DESK = REGISTRY.register("engineers_desk", EngineersdeskBlock::new);
    public static final DeferredBlock<Block> CONTRAPTIONS_TABLE = REGISTRY.register("contraptions_table", ContraptionstableBlock::new);
    public static final DeferredBlock<Block> PIPE_TABLE = REGISTRY.register("pipe_table", PipetableBlock::new);
    public static final DeferredBlock<Block> LINEMAN_TABLE = REGISTRY.register("lineman_table", LinemantableBlock::new);
    public static final DeferredBlock<Block> WORKSHOPS = REGISTRY.register("workshops", WorkshopsBlock::new);
    public static final DeferredBlock<Block> NETHERALAVS = REGISTRY.register("netheralavs", NetheralavsBlock::new);
    public static final DeferredBlock<Block> SUNDRIES_TABLE = REGISTRY.register("sundries_table", SundriestableBlock::new);
    public static final DeferredBlock<Block> MASTER_CONTRAPTIONS_TABLE = REGISTRY.register("master_contraptions_table", MastercontraptionstableBlock::new);
    public static final DeferredBlock<Block> SULFUR_BASALT_ORE = REGISTRY.register("sulfur_basalt_ore", SulfurbasaltoreBlock::new);
    public static final DeferredBlock<Block> SULFUR_ORE = REGISTRY.register("sulfur_ore", SulfuroreBlock::new);
    public static final DeferredBlock<Block> SULFUR_LAMP = REGISTRY.register("sulfur_lamp", SulfurlampBlock::new);
    public static final DeferredBlock<Block> SULFUR_LAMP_UP = REGISTRY.register("sulfur_lamp_up", SulfurlampupBlock::new);
    public static final DeferredBlock<Block> BLOCK_OF_SHADES = REGISTRY.register("block_of_shades", BlockOfShadesBlock::new);
    public static final DeferredBlock<Block> COLOR_TIME_BLOCK = REGISTRY.register("color_time_block", ColortimeblockBlock::new);
    public static final DeferredBlock<Block> COPPER_CASING_SLAB = REGISTRY.register("copper_casing_slab", CopperCasingSlabBlock::new);
    public static final DeferredBlock<Block> COPPER_CASING_STAIRS = REGISTRY.register("copper_casing_stairs", CopperCasingStairsBlock::new);
    public static final DeferredBlock<Block> CULTURAL_WOOD = REGISTRY.register("cultural_wood", CulturalWoodBlock::new);
    public static final DeferredBlock<Block> CULTURAL_LOG = REGISTRY.register("cultural_log", CulturalLogBlock::new);
    public static final DeferredBlock<Block> CULTURAL_PLANKS = REGISTRY.register("cultural_planks", CulturalPlanksBlock::new);
    public static final DeferredBlock<Block> CULTURAL_LEAVES = REGISTRY.register("cultural_leaves", CulturalLeavesBlock::new);
    public static final DeferredBlock<Block> CULTURAL_STAIRS = REGISTRY.register("cultural_stairs", CulturalStairsBlock::new);
    public static final DeferredBlock<Block> CULTURAL_SLAB = REGISTRY.register("cultural_slab", CulturalSlabBlock::new);
    public static final DeferredBlock<Block> CULTURAL_FENCE = REGISTRY.register("cultural_fence", CulturalFenceBlock::new);
    public static final DeferredBlock<Block> CULTURAL_FENCE_GATE = REGISTRY.register("cultural_fence_gate", CulturalFenceGateBlock::new);
    public static final DeferredBlock<Block> CULTURAL_PRESSURE_PLATE = REGISTRY.register("cultural_pressure_plate", CulturalPressurePlateBlock::new);
    public static final DeferredBlock<Block> CULTURAL_BUTTON = REGISTRY.register("cultural_button", CulturalButtonBlock::new);
    public static final DeferredBlock<Block> CULTIVATED_TREE_SAPLING = REGISTRY.register("cultivated_tree_sapling", CultivatedTreeSaplingBlock::new);
    public static final DeferredBlock<Block> HONEYCOMB_COLLECTOR = REGISTRY.register("honeycomb_collector", HoneycombCollectorBlock::new);

    @EventBusSubscriber(bus=EventBusSubscriber.Bus.MOD, value={Dist.CLIENT})
    public static class BlocksClientSideHandler {
        @SubscribeEvent
        public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
            BlockOfShadesBlock.blockColorLoad(event);
            CulturalLeavesBlock.blockColorLoad(event);
        }

        @SubscribeEvent
        public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
            BlockOfShadesBlock.itemColorLoad(event);
            CulturalLeavesBlock.itemColorLoad(event);
        }
    }
}

