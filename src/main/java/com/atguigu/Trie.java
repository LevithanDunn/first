package com.atguigu;


import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Objects;

public class Trie<V> {

    private int size;
    private Node<V> root;


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V add(String key, V value) {
        checkBlack(key);
        if (Objects.isNull(root)) {
            root = new Node<>(null);
        }
        Node<V> node = root;
        size++;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            boolean hasChildren = node.children == null;
            node.children = hasChildren ? new HashMap<>() : node.children;
            Node<V> children = hasChildren ? null : node.children.get(c);
            if (Objects.isNull(children)) {
                children = new Node<>(node);
                children.character = c;
                node.children.put(c, children);
            }
            node = children;
        }
        if (node.word) {
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
        node.word = true;
        node.value = value;
        return null;
    }

    private Node<V> node(String key) {
        checkBlack(key);
        Node<V> node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node == null || node.children == null || node.children.isEmpty()) {
                return null;
            }
            char c = key.charAt(i);
            node = node.children.get(c);
        }
        return node;
    }

    private void checkBlack(String key) {
        if (Objects.isNull(key) || key.isEmpty()) {
            throw new IllegalArgumentException("传入字符串不能为空");
        }
    }

    public V remove(String key) {
        Node<V> node = node(key);
        if (node == null || !node.word) {
            return null;
        }
        V oldValue = node.value;
        if (node.children != null && !node.children.isEmpty()) {
            node.value = null;
            node.word = false;
            return oldValue;
        }
        Node<V> parent = null;
        while ((parent = node.parent) != null) {
            parent.children.remove(node.character);
            if (parent.word && !parent.children.isEmpty()) {
                break;
            }
            node = parent;
        }
        return oldValue;
    }


    protected static class Node<V> {
        Node<V> parent;
        HashMap<Character, Node<V>> children;
        V value;
        boolean word;
        Character character;

        public Node(Node<V> parent) {
            this.parent = parent;
        }
    }

}
