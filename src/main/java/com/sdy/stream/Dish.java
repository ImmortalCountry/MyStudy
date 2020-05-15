package com.sdy.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: sundy
 * @date: 2020/5/14 16:03
 * @description:
 */
@Data
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public enum Type {
        /**
         * 分类肉、鱼、其他
         */
        MEAT, FISH, OTHER
    }

}
