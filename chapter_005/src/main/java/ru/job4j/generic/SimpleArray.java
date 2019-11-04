package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int index = 0;
    private int position = 0;

    public SimpleArray(int count) {
        this.array = new Object[count];
    }

    public void add(T model) {
        this.array[this.index++] = model;
    }

    public void set(int index, T model) {
        this.array[index] = model;
    }

    public void remove(int index) {
        if(index < this.index) {
            System.arraycopy(this.array,
                    index + 1,
                    this.array,
                    index,
                    (this.array.length - 1) - index);
        }
        this.index--;
        this.array[this.index] = null;
    }

    public T get(int index) {
        return (T) this.array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return array.length > position;
            }

            @Override
            public T next() {
                if (position == array.length) {
                    throw new NoSuchElementException();
                }
                return (T) array[position++];
            }
        };
    }
}