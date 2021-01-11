package com.sdy.designpatterns.fsm;

import com.sdy.designpatterns.fsm.enums.State;

/**
 * @author: sundy
 * @date: 2021/1/11 16:49
 * @description:
 */
public abstract class AbstractMarioStateMachine implements IMarioStateMachine {
    protected int score;
    protected State currentState;

    public AbstractMarioStateMachine() {
        this.score = 0;
        this.currentState = State.SMALL;
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}
