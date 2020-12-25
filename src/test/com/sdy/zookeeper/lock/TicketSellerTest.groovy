package com.sdy.zookeeper.lock

import spock.lang.Specification

/**
 * @author: sundy* @date: 2020/12/23 22:21
 * @description:
 */
class TicketSellerTest extends Specification {
    def "测试分布式锁"() {
        given:
        TicketSeller ticketSeller = new TicketSeller();
        for (int i = 0; i < 200; i++) {
            ticketSeller.sellTicketWithLock();
        }

    }
}
