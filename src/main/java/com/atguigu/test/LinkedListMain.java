package com.atguigu.test;

import com.atguigu.test.single.MyLinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(11);
        list.add(0, 33);
        list.remove(0);
        System.out.println(list);
    }
}
