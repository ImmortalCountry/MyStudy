package com.sdy.refactor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author: sundy
 * @date: 2020/10/16 10:53
 * @description: 普通用户需要收取运费，运费是商品价格的 10%，无商品折扣；
 */
public class NormalUserCart {
    public Cart process(long userId, Map<Long, Integer> items) {
        Cart cart = new Cart();

        // 把 Map 的购物车转换为Item列表
        ArrayList<Item> itemList = new ArrayList<>();
        items.entrySet().stream().forEach(entry -> {
            Item item = new Item();
            item.setId(entry.getKey());
            item.setPrice(Db.getItemPrice(entry.getKey()));
            item.setQuantity(entry.getValue());
            itemList.add(item);
        });
        cart.setItems(itemList);

        // 处理运费和商品优惠
        itemList.stream().forEach(item -> {
            // 运费为商品总价的 10%
            item.setDeliveryPrice(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())).multiply(new BigDecimal(("0.1"))));
            // 无优惠
            item.setCouponPrice(BigDecimal.ZERO);
        });

        // 计算商品总价
        cart.setTotalItemPrice(cart.getItems().stream().map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算运费总价
        cart.setTotalDeliveryPrice(cart.getItems().stream().map(Item::getDeliveryPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //计算总优惠
        cart.setTotalDiscount(cart.getItems().stream().map(Item::getCouponPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        //应付总价=商品总价+运费总价-总优惠
        cart.setPayPrice(cart.getTotalItemPrice().add(cart.getTotalDeliveryPrice()).subtract(cart.getTotalDiscount()));
        return cart;
    }
}
