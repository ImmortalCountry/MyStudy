package com.sdy.algorithm;

public class Main {

    public static void main(String[] args) {
        Question question = new Question();
        System.out.println("斐波那契数列： " + question.Fibonacci(10));
        System.out.println("斐波那契数列： " + question.FibonacciR(10));


        System.out.println("青蛙跳台阶： " + question.jumpFloor(10));
        System.out.println("青蛙跳台阶： " + question.jumpFloorPro(10));

        // 链表反转

        Question.ListNode head = new Question.ListNode(1);
        Question.ListNode temp1 = new Question.ListNode(2);
        head.next = temp1;
        Question.ListNode temp2 = new Question.ListNode(3);
        temp1.next = temp2;


        System.out.println("链表反转： " + question.ReverseLinkedList(head));

    }
}
