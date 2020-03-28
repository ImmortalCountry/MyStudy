package com.sdy.algorithm;

public class Question {

    /**
     * 斐波那契数列非递归
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        int first = 1;
        int second = 2;
        int third = 0;
        for (int i = 3; i < n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public int FibonacciR(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        return FibonacciR(n - 1) + FibonacciR(n - 2);
    }


    /**
     * 青蛙跳台阶， 每次跳 1 步或者 2 步， 问多少种跳法
     *
     * @param n 阶数
     * @return
     */
    public int jumpFloor(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int first = 1;
        int second = 2;
        int third = 3;
        for (int i = 3; i <= n; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }

    /**
     * 青蛙一次可以跳 1 个台阶，也可以 2 个台阶， 也可以 3 。。。n 个台阶
     * 设 n >= 2
     * 所以 f(n) = f(n-1) + f(n-2) + ... + f(1)
     * f(n-1) = f(n-2) + f(n-3) + ... + f(1)
     * 所以 f(n) = 2f(n-1)
     * 又 f(1)=1,
     * 所以f(n)=2^(n-1)
     *
     * @param n 台阶数
     * @return
     */
    public int jumpFloorPro(int n) {
        return 1 << (n - 1); // 即 2^(n-1)
    }

    /**
     * 链表反转
     *
     * @param head
     * @return
     */
    public ListNode ReverseLinkedList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    /**
     * 合并链表
     *
     * @return
     */
    public ListNode MergeLinkedList() {
        // TODO
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
