package com.atguigu.test;

import com.atguigu.test.single.MArrayList;

public class MArrayListMain {
    public static void main(String[] args) {
        MArrayList<Integer> mArrayList = new MArrayList<>();
        for (int i = 0; i < 50; i++) {
            mArrayList.add(i);
        }
        System.out.println(mArrayList);
        int size = mArrayList.size();
        for (int i = 0; i < size; i++) {
            mArrayList.remove(0);
        }
        System.out.println(mArrayList);
    }
}
