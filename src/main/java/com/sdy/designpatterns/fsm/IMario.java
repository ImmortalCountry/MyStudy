package com.sdy.designpatterns.fsm;

import com.sdy.designpatterns.fsm.enums.State;

/**
 * @author: sundy
 * @date: 2021/1/11 18:11
 * @description: 所有状态类的接口
 */
public interface IMario {
    State getName();

    void obtainMushRoom();

    void obtainCape();

    void obtainFireFlower();

    void meetMonster();
}
