package com.sdy.designpatterns.fsm;

import com.sdy.designpatterns.fsm.enums.State;

/**
 * @author: sundy
 * @date: 2021/1/11 18:25
 * @description:
 */
public class SuperMario implements IMario {
    private MarioStateMachine stateMachine;

    public SuperMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SUPER;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
