package net.mcreator.create_mf.init;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class CmfTradeGuard {
    private CmfTradeGuard() {
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static boolean safeAdd(List list, Object object) {
        if (list == null || object == null) {
            return false;
        }

        if (!isSafeListing(object)) {
            System.err.println("[Create MF TradeGuard] Skipped invalid villager trade listing: " + object.getClass().getName());
            return false;
        }

        return list.add(object);
    }

    private static boolean isSafeListing(Object object) {
        try {
            if (!"net.neoforged.neoforge.common.BasicItemListing".equals(object.getClass().getName())) {
                return true;
            }

            int itemStackFieldCount = 0;
            int emptyItemStackCount = 0;
            int nonEmptyItemStackCount = 0;

            for (Field field : object.getClass().getDeclaredFields()) {
                if (!"net.minecraft.world.item.ItemStack".equals(field.getType().getName())) {
                    continue;
                }

                itemStackFieldCount++;
                field.setAccessible(true);

                Object fieldValue = field.get(object);
                if (fieldValue == null || isEmptyItemStack(fieldValue)) {
                    emptyItemStackCount++;
                } else {
                    nonEmptyItemStackCount++;
                }
            }

            if (itemStackFieldCount >= 3) {
                return nonEmptyItemStackCount >= 2 && emptyItemStackCount <= 1;
            }

            return true;
        } catch (Throwable throwable) {
            System.err.println("[Create MF TradeGuard] Could not inspect trade listing safely: " + throwable);
            return true;
        }
    }

    private static boolean isEmptyItemStack(Object object) throws Exception {
        Method method = object.getClass().getMethod("isEmpty");
        Object result = method.invoke(object);
        return Boolean.TRUE.equals(result);
    }
}
