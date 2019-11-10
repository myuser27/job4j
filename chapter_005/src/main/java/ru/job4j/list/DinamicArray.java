package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DinamicArray<E> implements Iterable<E> {
    private Object[] container;
    private int size;
    private int index = 0;
    private int position = 0;
    private int modCount = 0;
    private int expectModCount = 0;

    public DinamicArray(int size) {
        this.size = size;
        this.container = new Object[size];
    }

    private Object[] newContainer(Object[] container) {
        return Arrays.copyOf(container, this.size);
    }

    public void add(E value) {
        if (this.index == this.container.length) {
            this.size++;
            this.container = newContainer(this.container);
            this.modCount++;
        }
        this.container[this.index++] = value;
    }

    public E get(int index) {
        return (E) this.container[index];
    }

    @Override
    public Iterator<E> iterator() {
        expectModCount = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return container.length > position;
            }

            @Override
            public E next() {
                if (expectModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (position == container.length) {
                    throw new NoSuchElementException();
                }
                return (E) container[position++];
            }
        };
    }
}
