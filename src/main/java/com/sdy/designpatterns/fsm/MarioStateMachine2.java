package com.sdy.designpatterns.fsm;

import com.sdy.designpatterns.fsm.enums.Event;
import com.sdy.designpatterns.fsm.enums.State;

import static com.sdy.designpatterns.fsm.enums.State.*;

/**
 * @author: sundy
 * @date: 2021/1/11 17:09
 * @description:
 */
public class MarioStateMachine2 extends AbstractMarioStateMachine {
    private static final State[][] transitionTable = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}
    };

    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}
    };

    @Override
    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    @Override
    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    @Override
    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    @Override
    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    public void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        this.currentState = transitionTable[stateValue][eventValue];
        this.score += actionTable[stateValue][eventValue];
    }
}
