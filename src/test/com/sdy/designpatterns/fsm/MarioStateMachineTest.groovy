package com.sdy.designpatterns.fsm

import com.sdy.designpatterns.fsm.enums.State
import spock.lang.Specification

/**
 * @author: sundy* @date: 2021/1/11 17:10
 * @description:
 */
class MarioStateMachineTest extends Specification {
    def "if else"() {
        given:
        def mario = new MarioStateMachine1()
        mario.obtainMushRoom()
        print(mario)
    }

    def "search table"() {
        given:
        def mario = new MarioStateMachine2()
        mario.obtainMushRoom()
        print(mario)
    }

    def "state pattern"(){
        given:
        def mario = new MarioStateMachine()
        mario.obtainCape()
        print(mario)
    }

    def "print"(mario) {
        def score = mario.getScore()
        def state = mario.getCurrentState()
        printf("mario score:%d, state:%d", score, state.getValue())
    }
}
