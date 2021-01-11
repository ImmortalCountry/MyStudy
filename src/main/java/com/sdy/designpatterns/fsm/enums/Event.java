package com.sdy.designpatterns.fsm.enums;

/**
 * @author: sundy
 * @date: 2021/1/11 17:21
 * @description:
 */
public enum Event {
    GOT_MUSHROOM(0),
    GOT_CAPE(1),
    GOT_FIRE(2),
    MET_MONSTER(3);
    private int value;

    private Event(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
