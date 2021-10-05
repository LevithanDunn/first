package com.atguigu.test.single;

import com.atguigu.test.MyList;

public abstract class AbstractList<E> implements MyList<E> {
    protected int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


    protected void checkRange(int index) {
        if (index < 0 || index >= size) {
            outOfBounds(index);
            return;
        }
    }

    protected void checkRangeForAdd(int index) {
        if (index < 0 || index > size) {
            outOfBounds(index);
            return;
        }
    }

    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Size=" + size + ",but Index" + index);
    }

    @Override
    public void add(E element) {
        add(size, element);
    }
}
