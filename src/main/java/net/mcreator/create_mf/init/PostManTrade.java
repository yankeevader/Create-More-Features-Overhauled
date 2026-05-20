package net.mcreator.create_mf.init;

import java.util.List;
import net.mcreator.create_mf.init.CreateMfModVillagerProfessions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

@EventBusSubscriber
public class PostManTrade {
    @SubscribeEvent
    public static void registerTrades(VillagerTradesEvent event) {
        if (event.getType() == CreateMfModVillagerProfessions.POSTMAN.get()) {
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Items.PAPER, 21), new ItemStack((ItemLike)Items.EMERALD, 2), 10, 1, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Blocks.DEEPSLATE), new ItemStack((ItemLike)Blocks.DEEPSLATE), 16, 2, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Blocks.COBBLED_DEEPSLATE), new ItemStack((ItemLike)Blocks.DEEPSLATE), 16, 2, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Blocks.DEEPSLATE), new ItemStack((ItemLike)Blocks.DEEPSLATE), 16, 3, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(2), new BasicItemListing(new ItemStack((ItemLike)Blocks.DEEPSLATE), new ItemStack((ItemLike)Blocks.DEEPSLATE), 16, 3, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Items.IRON_INGOT, 24), new ItemStack((ItemLike)Items.EMERALD), 15, 4, 0.03f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(3), new BasicItemListing(new ItemStack((ItemLike)Blocks.SMOOTH_STONE), new ItemStack((ItemLike)Items.EMERALD, 2), 15, 4, 0.02f));
            CmfTradeGuard.safeAdd((List)event.getTrades().get(1), new BasicItemListing(new ItemStack((ItemLike)Blocks.SMOOTH_STONE), new ItemStack((ItemLike)Items.EMERALD, 14), 5, 5, 0.05f));
        }
    }
}

