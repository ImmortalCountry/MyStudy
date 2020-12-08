package com.sdy.test

import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/11/13 16:04
 * @description:
 */
class SpockTestTest extends Specification {
    def max = new SpockTest();

    def "Max"() {
        expect:
        max.max(1, 2) == 1
    }
}
