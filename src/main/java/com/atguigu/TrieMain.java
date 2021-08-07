package com.atguigu;


public class TrieMain {
    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<>();
        trie.add("aa",1);
        trie.add("cc",5);
        trie.add("dd",7);
        System.out.println(trie.size());
        System.out.println("=====================================================");
        System.out.println(trie.remove("aa"));
    }
}
