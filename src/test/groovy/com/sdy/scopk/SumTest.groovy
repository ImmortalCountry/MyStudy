package com.sdy.scopk

import spock.lang.Specification

/**
 * @author: Sun Deyu
 * @date: 2020/6/1 16:49
 * @description:
 */
class SumTest extends Specification {
    def sum = new Sum()

    /**
     * run before every feature method
     */
    void setup() {
    }

    /**
     * run after every feature method
     */
    void cleanup() {
    }

    /**
     * run before the first feature method
     */
    void setupSpec() {

    }

    /**
     * run after the last feature method
     */
    void cleanupSpec() {

    }

    def "sum should return param1+param2"() {
        give:
        // 定义 mock 函数， 初始化局部变量
        expect:
        sum.exector(first, sencond) == result
        print(a)
        where:
        first | sencond | result
        1     | 1       | 2
        2     | 2       | 4
        0     | 0       | 0
        -1    | 2       | 1
        where:
        a | _
        3 | _
        7 | _
        0 | _

        b << [5, 0, 0]

        c = a > b ? a : b
    }
}
