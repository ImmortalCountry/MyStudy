package com.sdy.designpatterns.fsm;

import com.sdy.designpatterns.fsm.enums.State;

/**
 * @author: sundy
 * @date: 2021/1/11 16:56
 * @description: 分支逻辑法实现状态机
 */
public class MarioStateMachine1 extends AbstractMarioStateMachine {

    @Override
    public void obtainMushRoom() {
        if (State.SMALL.equals(currentState)) {
            this.currentState = State.SUPER;
            this.score += 100;
        }
    }

    @Override
    public void obtainCape() {
        if (State.SMALL.equals(currentState) || State.SUPER.equals(currentState)) {
            this.currentState = State.CAPE;
            this.score += 200;
        }
    }

    @Override
    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            this.currentState = State.FIRE;
            this.score += 300;
        }
    }

    @Override
    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
        } else if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
        } else if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
        }
    }
}
