package com.sdy.calculation;

import java.math.BigDecimal;

/**
 * @author: SunDeYu
 * @date: 2020/8/5 16:55
 * @description: java 简单类型不能对浮点类型进行运算，故封装运算工具。
 * 使用 BigDecimal 并且 必须使用 String 构造
 */
public class Arith {
    /**
     * 默认除法运算精度
     */
    public static final int DEF_DIV_SCALE = 10;

    /**
     * 类不能实例化
     */
    private Arith(){

    }

    public static double add(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }
    public static double sub(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }
    public static double mul(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 默认精确到小数点后十位， 四舍五入。
     * @param v1
     * @param v2
     * @return
     */
    public static double div(double v1, double v2){
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return div(v1,v2, DEF_DIV_SCALE);
    }

    /**
     * 精确到 scale 四舍五入
     * @param v1
     * @param v2
     * @param scale
     * @return
     */
    public static double div(double v1, double v2, int scale){
        if (scale < 0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 四舍五入
     * @param v
     * @param scale
     * @return
     */
    public static double round(double v, int scale){
        if (scale < 0){
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal decimal = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return decimal.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
