package net.mcreator.create_mf.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;

public class VoidStorageProcedureProcedure {
    private static final double RAYTRACE_DISTANCE = 3.0;
    private static final double MAX_FLUID_AMOUNT = 10.0;

    public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
        if (entity == null || itemstack == null || itemstack.isEmpty()) {
            return;
        }

        BlockPos targetPos = getTargetPos(entity);
        FluidState targetFluid = world.getFluidState(targetPos);

        double storedWater = getStoredFluid(itemstack, "fluid_water");
        double storedLava = getStoredFluid(itemstack, "fluid_lava");

        if (storedWater < MAX_FLUID_AMOUNT && storedLava == 0.0 && targetFluid.isSource() && targetFluid.getType() == Fluids.WATER) {
            swing(entity);
            world.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
            playFillSound(world, targetPos);
            setStoredFluid(itemstack, "fluid_water", storedWater + 1.0);
            return;
        }

        if (storedWater == 0.0 && storedLava < MAX_FLUID_AMOUNT && targetFluid.isSource() && targetFluid.getType() == Fluids.LAVA) {
            swing(entity);
            world.setBlock(targetPos, Blocks.AIR.defaultBlockState(), 3);
            playFillSound(world, targetPos);
            setStoredFluid(itemstack, "fluid_lava", storedLava + 1.0);
            return;
        }

        if (entity.isShiftKeyDown()) {
            if (storedWater > 0.0) {
                playEmptySound(world, x, y, z);
                world.setBlock(targetPos, Blocks.WATER.defaultBlockState(), 3);
                setStoredFluid(itemstack, "fluid_water", storedWater - 1.0);
                return;
            }

            if (storedLava > 0.0) {
                playEmptySound(world, x, y, z);
                world.setBlock(targetPos, Blocks.LAVA.defaultBlockState(), 3);
                setStoredFluid(itemstack, "fluid_lava", storedLava - 1.0);
            }
        }
    }

    private static BlockPos getTargetPos(Entity entity) {
        BlockHitResult hitResult = entity.level().clip(new ClipContext(
                entity.getEyePosition(1.0f),
                entity.getEyePosition(1.0f).add(entity.getViewVector(1.0f).scale(RAYTRACE_DISTANCE)),
                ClipContext.Block.OUTLINE,
                ClipContext.Fluid.NONE,
                entity
        ));

        return hitResult.getBlockPos();
    }

    private static double getStoredFluid(ItemStack stack, String tagName) {
        return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(tagName);
    }

    private static void setStoredFluid(ItemStack stack, String tagName, double amount) {
        CompoundTag tag = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();

        tag.putDouble(tagName, Math.max(0.0, amount));

        stack.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
    }

    private static void swing(Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.swing(InteractionHand.MAIN_HAND, true);
        }
    }

    private static void playFillSound(LevelAccessor world, BlockPos pos) {
        if (world instanceof Level level) {
            if (!level.isClientSide()) {
                level.playSound(null, pos, SoundEvents.BUCKET_FILL, SoundSource.NEUTRAL, 1.0f, 1.0f);
            } else {
                level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BUCKET_FILL, SoundSource.NEUTRAL, 1.0f, 1.0f, false);
            }
        }
    }

    private static void playEmptySound(LevelAccessor world, double x, double y, double z) {
        if (world instanceof Level level) {
            if (!level.isClientSide()) {
                level.playSound(null, BlockPos.containing(x, y + 1.0, z), SoundEvents.BUCKET_EMPTY, SoundSource.NEUTRAL, 1.0f, 0.9f);
            } else {
                level.playLocalSound(x, y + 1.0, z, SoundEvents.BUCKET_EMPTY, SoundSource.NEUTRAL, 1.0f, 0.9f, false);
            }
        }
    }
}