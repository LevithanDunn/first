package com.atguigu.test;

import com.atguigu.test.single.AbstractList;

public class MyDoubleLinkedList<E> extends AbstractList<E> {

    private Node<E> first;
    private Node<E> last;

    @Override
    public void clear() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldVal = node.element;
        node.element = element;
        return oldVal;
    }

    @Override
    public void add(int index, E element) {
//        if (index == 0) {
//            first = new Node<>(element, first);
//        } else {
//            Node<E> prev = node(index - 1);
//            prev.next = new Node<E>(element, prev.next);
//        }
        if (size == index) {
            Node<E> oldLast = last;
            last = new Node<>(last, element, null);
            if (oldLast == null) {
                first = last;
            } else {
                oldLast.next = last;
            }
        } else {
            Node<E> node = node(index);
            Node<E> newNode = new Node<>(node.prev, element, node);
            Node<E> prev = node.prev;
            Node<E> next = node.next;
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }
            next.prev = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkRange(index);
        Node<E> node = first;
//        if (index == 0) {
//            first = first.next;
//        } else {
//            Node<E> prev = node(index - 1);
//            node = prev.next;
//            prev.next = prev.next.next;
//        }
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
        }
        size--;

        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (node.element.equals(element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<E> node(int index) {
        checkRange(index);
        Node<E> node = first;
        if (index < (size >> 1)) {
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node<E> node = first;
        builder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(node.element);
            node = node.next;
        }
        builder.append("]");
        return builder.toString();
    }
}
