package com.sdy.refactor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: sundy
 * @date: 2020/10/16 11:09
 * @description: 模拟数据库
 */
public class Db {
    private static Map<Long, String> item = new HashMap<>();
    private static Map<Long, Integer> user = new HashMap<>();

    static {
        for (long i = 1; i < 100; i++) {
            item.put(i, i + "");
        }
        for (long userId = 100; userId <= 110; userId++) {
            Integer coupon = Integer.valueOf((100 - userId) * 10 + "");
            user.put(userId, coupon);
        }
    }

    public static BigDecimal getItemPrice(Long key) {
        return new BigDecimal(item.get(key));
    }

    public static int getUserCouponPercent(Long userId) {
        return 0;
    }

}
