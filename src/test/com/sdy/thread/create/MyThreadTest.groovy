package com.sdy.thread.create

import spock.lang.Specification

/**
 * @author: sundy* @date: 2021/1/26 18:20
 * @description:
 */
class MyThreadTest extends Specification {
    def "test extend Thread"() {
        given:
        def thread = new MyThread()
        thread.start()

    }
}
