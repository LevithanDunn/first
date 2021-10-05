package com.atguigu.test;

import com.atguigu.test.single.MyLinkedList2;

public class LinkedList2Main {
    public static void main(String[] args) {
        MyLinkedList2<Integer> list2 = new MyLinkedList2<>();
        list2.add(52);
        list2.add(11);
        list2.add(23);
        list2.remove(0);
        System.out.println("list2 = " + list2);
    }
}
