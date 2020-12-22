package com.sdy.designpatterns.singleton

import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/12/22 10:15
 * @description:
 */
class SingletonTest extends Specification {
    def "singleTest"() {
        expect:
        single1 == single2

        where:
        single1                              || single2
        DoubleCheckSingleton.getInstance()   || DoubleCheckSingleton.getInstance()
        DoubleCheckSingletonV2.getInstance() || DoubleCheckSingletonV2.getInstance()
        EagerSingleton.getInstance()         || EagerSingleton.getInstance()
        EnumSingleton.INSTANCE               || EnumSingleton.INSTANCE
        LazySingleton.getInstance()          || LazySingleton.getInstance()
        StaticBlockSingleton.getInstance()   || StaticBlockSingleton.getInstance()
        ThreadSingleton.getInstance()        || ThreadSingleton.getInstance()
    }
}