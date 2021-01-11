package com.sdy.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: sundy
 * @date: 2020/10/14 15:20
 * @description:
 */
public class A {
    public static void main(String[] args) {
        String s = "aaa";
        String ss = "abbxxxxzzy";
        System.out.println(largeGroupPositions(ss));
    }

    public static List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        char[] arr = s.toCharArray();
        int length = 1;
        if (arr.length < 3) {
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1 || arr[i] != arr[i + 1]) {
                if (length >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i - length + 1);
                    list.add(i);
                    result.add(list);
                }
                length = 1;
            } else {
                length++;
            }
        }
        return result;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0) {
            return new ListNode(0);
        }
        ListNode tail = null;
        ListNode head1 = null;
        ListNode head2 = null;
        tail = head1 = l1;
        head2 = l2;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int val1 = head1 == null ? 0 : head1.val;
            int val2 = head2 == null ? 0 : head2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum %= 10;
            head1.val = sum;
            tail = head1;
            head1 = head1.next;
            head2 = head2.next;
        }
        if (carry > 0) {
            tail.next = new ListNode(carry, null);
        }
        return l1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
