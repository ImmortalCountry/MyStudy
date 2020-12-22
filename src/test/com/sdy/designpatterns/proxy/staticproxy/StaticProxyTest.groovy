package com.sdy.designpatterns.proxy.staticproxy

import com.sdy.designpatterns.proxy.BuyHouseImpl
import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/12/22 11:25
 * @description:
 */
class StaticProxyTest extends Specification {
    def "static proxy"() {
        given:
        def buyHouse = new BuyHouseImpl();
        def proxy = new StaticProxy(buyHouse);
        proxy.buyHouse();
    }
}
