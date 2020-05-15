package com.sdy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * @author: sundy
 * @date: 2020/5/15 15:31
 * @description:
 */
public class Test2 {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader brian = new Trader("Brian", "Cambridge");
    Trader alan = new Trader("Alan", "Cambridge");
    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /**
     * 找出 2011 年发生的所有交易，并按交易金额排序（从低到高）
     */
    public void test1() {
        List<Transaction> collect = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getValue))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 交易员都在哪些不同的城市工作过
     */
    public void test2(){
        List<String> collect = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);
        Set<String> collect1 = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(Collectors.toSet());
        System.out.println(collect1);
    }

    /**
     * 查找所有来自剑桥的交易员，并按姓名排序
     */
    public void test3(){
        List<Trader> collect = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> "Cambridge".equals(trader.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    /**
     * 返回所有交易员的姓名字符串，按字母排序
     */
    public void test4(){
        String collect = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .collect(Collectors.joining());
        System.out.println(collect);
    }

    /**
     * 有没有交易员是在米兰工作的
     */
    public void test5(){
        boolean milan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(milan);
    }

    /**
     * 打印生活在剑桥的交易员的所有交易额
     */
    public void test6(){
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    /**
     * 所有交易中，最高的交易额是多少
     */
    public void test7(){
        Optional<Integer> reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        reduce.ifPresent(System.out::println);
    }
}
