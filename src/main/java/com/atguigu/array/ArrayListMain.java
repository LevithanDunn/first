package com.atguigu.array;

public class ArrayListMain {
    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList();
        for (int i = 0; i < 20; i++) {
            arrayList.add(i);
        }
        arrayList.add(null);
        System.out.println(arrayList.indexOf(null));
    }
}
