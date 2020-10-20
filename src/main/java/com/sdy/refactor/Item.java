package com.sdy.refactor;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: sundy
 * @date: 2020/10/16 10:47
 * @description:
 */
@Data
public class Item {
    /**
     * 商品ID
     */
    private long id;
    /**
     * 商品数量
     */
    private int quantity;
    /**
     * 商品单价
     */
    private BigDecimal price;
    /**
     * 商品优惠
     */
    private BigDecimal couponPrice;
    /**
     * 商品运费
     */
    private BigDecimal deliveryPrice;
}
