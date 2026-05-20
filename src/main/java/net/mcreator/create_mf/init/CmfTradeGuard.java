package net.mcreator.create_mf.init;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class CmfTradeGuard {
    private CmfTradeGuard() {
    }

    public static boolean safeAdd(List list, Object object) {
        if (list == null || object == null) {
            return false;
        }
        if (!CmfTradeGuard.isSafeListing(object)) {
            System.err.println("[Create MF TradeGuard] Skipped invalid villager trade listing: " + object.getClass().getName());
            return false;
        }
        return list.add(object);
    }

    private static boolean isSafeListing(Object object) {
        try {
            Field[] fieldArray;
            if (!"net.neoforged.neoforge.common.BasicItemListing".equals(object.getClass().getName())) {
                return true;
            }
            int n = 0;
            int n2 = 0;
            int n3 = 0;
            for (Field field : fieldArray = object.getClass().getDeclaredFields()) {
                if (!"net.minecraft.world.item.ItemStack".equals(field.getType().getName())) continue;
                ++n;
                field.setAccessible(true);
                Object object2 = field.get(object);
                if (object2 == null || CmfTradeGuard.isEmptyItemStack(object2)) {
                    ++n2;
                    continue;
                }
                ++n3;
            }
            if (n >= 3) {
                return n3 >= 2 && n2 <= 1;
            }
            return true;
        }
        catch (Throwable throwable) {
            System.err.println("[Create MF TradeGuard] Could not inspect trade listing safely: " + String.valueOf(throwable));
            return true;
        }
    }

    private static boolean isEmptyItemStack(Object object) throws Exception {
        Method method = object.getClass().getMethod("isEmpty", new Class[0]);
        Object object2 = method.invoke(object, new Object[0]);
        return Boolean.TRUE.equals(object2);
    }
}

