package com.atguigu.test;

import com.atguigu.test.single.MyCircleLinkedList;

public class CircleLinkedMain {
    public static void main(String[] args) {
        MyCircleLinkedList<Integer> list = new MyCircleLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        System.out.println(list);
        list.add(0,55);
        list.add(2,66);
        list.add(list.size(),77);
        System.out.println("list = " + list);
    }
}
