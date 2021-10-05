package com.atguigu.test.single;

import java.util.Arrays;
import java.util.Objects;

public class MArrayList<E> extends AbstractList<E> {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public MArrayList(int capacity) {
        elements = (E[]) new Object[capacity <= DEFAULT_CAPACITY ? DEFAULT_CAPACITY : capacity];
    }

    public MArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        if (elements != null && elements.length > DEFAULT_CAPACITY) {
            elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, elements[i])) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    public E get(int index) {
        checkRange(index);
        return elements[index];
    }

    public E remove(int index) {
        checkRange(index);
        E oldVal = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        elements[--size] = null;
        trim();
        return oldVal;
    }


    public void add(int index, E element) {
        checkRangeForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        size++;
        elements[index] = element;
    }

    public E set(int index, E element) {
        checkRange(index);
        E oldVal = elements[index];
        elements[index] = element;
        return oldVal;
    }


    private void ensureCapacity(int cap) {
        int oldCap = elements.length;
        if (oldCap >= cap) return;
        int newCap = oldCap + (oldCap >> 1);
        E[] es = Arrays.copyOf(elements, newCap);
        elements = es;
        System.out.println("扩容机制开启。。。。。");
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

    private void trim() {
        int capacity = elements.length;
        int newCap = capacity >> 1;
        if (size >= newCap || size <= DEFAULT_CAPACITY) {
            return;
        }
        System.out.println("进行缩容操作");
        elements = Arrays.copyOf(elements, newCap);
    }
}
