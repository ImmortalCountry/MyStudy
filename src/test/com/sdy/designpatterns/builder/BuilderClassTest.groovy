package com.sdy.designpatterns.builder

import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/12/22 10:08
 * @description:
 */
class BuilderClassTest extends Specification {

    def "create instance by builder"() {
        def buildClass = new BuilderClass.Builder()
                .setId("1")
                .setName("小明")
                .setSex("男")
                .build()
        expect:
        buildClass.getId() == "1"
        buildClass.getName() == "小明"
        buildClass.getSex() == "男"
        buildClass.getAmount() == 10
    }

}
