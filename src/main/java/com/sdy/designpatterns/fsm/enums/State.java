package com.sdy.designpatterns.fsm.enums;

/**
 * @author: sundy
 * @date: 2021/1/11 16:46
 * @description:
 */
public enum State {
    /**
     * 小
     */
    SMALL(0),
    /**
     * 获得蘑菇
     */
    SUPER(1),
    /**
     * 获得火焰
     */
    FIRE(2),
    /**
     * 获得斗篷
     */
    CAPE(3);

    private int value;

    private State(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
