package com.sdy.designpatterns.fsm;

/**
 * @author: sundy
 * @date: 2021/1/11 16:54
 * @description:
 */
public interface IMarioStateMachine {

    /**
     * 获得蘑菇
     */
    void obtainMushRoom();

    /**
     * 获得斗篷
     */
    void obtainCape();

    /**
     * 获得火焰
     */
    void obtainFireFlower();

    /**
     * 遇见怪物
     */
    void meetMonster();
}
