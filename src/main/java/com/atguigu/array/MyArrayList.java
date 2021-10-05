package com.atguigu.array;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {
    private int size;
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUNT = -1;

    public MyArrayList(int capacity) {
        capacity = capacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUNT;
    }

    public void add(E element) {
        add(size, element);
        return;
    }

    public E get(int index) {
        checkRange(index);
        return elements[index];
    }

    public E set(int index, E element) {
        checkRange(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    public void add(int index, E element) {
        checkRangeForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
        return;
    }

    private void ensureCapacity(int cap) {
        int oldCap = elements.length;
        if (oldCap >= cap) return;
        int newCap = oldCap + (oldCap >> 1);
        E[] es = Arrays.copyOf(elements, newCap);
        elements = es;
        System.out.println("进行数组的扩容。。。。");
    }

    private void checkRangeForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
            return;
        }
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + "but Size" + size);
    }

    public E remove(int index) {
        checkRange(index);
        E oldVal = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        return oldVal;
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }

    public int indexOf(E element) {
        for (int i = 0; i < elements.length; i++) {
//            if (elements[i] == element) {
//                return i;
//            }
            if (Objects.equals(elements[i], element)) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUNT;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        return;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                builder.append(",");
            }
            builder.append(elements[i]);
        }
        builder.append("]");
        return builder.toString();
    }
}
