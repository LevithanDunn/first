package com.atguigu.hello;


import com.atguigu.printer.BinaryTrees;

public class TestMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        int data[] = {35, 66, 53, 11, 20, 50, 54, 71, 6, 73, 9};
        for (int datum : data) {
            tree.add(datum);
        }
        BinaryTrees.println(tree);
        tree.remove(6);
        System.out.println();
        BinaryTrees.println(tree);
    }

}
