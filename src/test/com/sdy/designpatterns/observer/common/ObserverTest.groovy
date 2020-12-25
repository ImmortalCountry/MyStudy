package com.sdy.designpatterns.observer.common

import com.sdy.designpatterns.observer.common.ConcreteObserverOne
import com.sdy.designpatterns.observer.common.ConcreteObserverTwo
import com.sdy.designpatterns.observer.common.ConcreteSubject
import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/12/24 17:53
 * @description:
 */
class ObserverTest extends Specification {
    def "observer test"() {
        given:
        def subject = new ConcreteSubject()
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers();
    }
}
