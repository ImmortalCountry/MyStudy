package com.sdy.javaeight.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sundy
 * @date: 2020/5/14 15:49
 * @description:
 */
public class StreamStudy {
    List<Dish> menu = new ArrayList<>();

    public StreamStudy(){
        menu.add(new Dish("pork", false, 800, Dish.Type.MEAT));
        menu.add(new Dish("beef", false, 700, Dish.Type.MEAT));
        menu.add(new Dish("chicken", false, 400, Dish.Type.MEAT));
        menu.add(new Dish("french fries", true, 530, Dish.Type.OTHER));
        menu.add(new Dish("rice", true, 350, Dish.Type.OTHER));
        menu.add(new Dish("season", true, 120, Dish.Type.OTHER));
        menu.add(new Dish("pizza", true, 550, Dish.Type.OTHER));
        menu.add(new Dish("prawns", false, 300, Dish.Type.FISH));
        menu.add(new Dish("salmon", false, 450, Dish.Type.FISH));
    }
    public List<Dish> getMenu(){
        return menu;
    }
}
