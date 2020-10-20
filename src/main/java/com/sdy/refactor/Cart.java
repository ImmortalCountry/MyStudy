package com.sdy.refactor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: sundy
 * @date: 2020/10/16 10:41
 * @description:
 */
@Data
public class Cart {
    /**
     * 商品清单
     */
    private List<Item> items = new ArrayList<>();
    /**
     * 总优惠
     */
    private BigDecimal totalDiscount;
    /**
     * 商品总价
     */
    private BigDecimal totalItemPrice;
    /**
     * 总运费
     */
    private BigDecimal totalDeliveryPrice;
    /**
     * 应付总价
     */
    private BigDecimal payPrice;
}
