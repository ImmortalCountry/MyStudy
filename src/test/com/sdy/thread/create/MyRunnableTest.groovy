package com.sdy.thread.create

import spock.lang.Specification

/**
 * @author: sundy* @date: 2021/1/26 18:24
 * @description:
 */
class MyRunnableTest extends Specification {
    def "test implements Runnable"() {
        given:
        def myRunnable = new MyRunnable();
        new Thread(myRunnable).start()
    }
}
