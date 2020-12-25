package com.sdy.designpatterns.observer.eventbus

import com.google.common.collect.Lists
import com.sdy.designpatterns.observer.eventbus.observer.ObserverA
import com.sdy.designpatterns.observer.eventbus.observer.ObserverB
import com.sdy.designpatterns.observer.eventbus.observer.ObserverC
import com.sdy.designpatterns.observer.eventbus.observer.X
import com.sdy.designpatterns.observer.eventbus.observer.Y
import com.sdy.designpatterns.observer.eventbus.observer.Z
import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/12/25 10:50
 * @description:
 */
class ConcreteSubjectTest extends Specification {
    def "eventBus sync test"() {
        given:
        def subject = new ConcreteSubject();
        def a = new ObserverA();
        def b = new ObserverB();
        def c = new ObserverC();
        subject.setRegObservers(Lists.newArrayList(a, b, c))
        subject.doBusiness(new Y())
    }
}