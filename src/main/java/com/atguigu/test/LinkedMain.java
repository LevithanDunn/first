package com.atguigu.test;

public class LinkedMain {
    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> list = new MyDoubleLinkedList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        System.out.println(list);
        list.add(0, 66);
        list.add(list.size(), 77);
        System.out.println(list);

        list.remove(0);
        list.remove(2);
        list.remove(list.size() - 1);
        System.out.println(list);
    }
}
