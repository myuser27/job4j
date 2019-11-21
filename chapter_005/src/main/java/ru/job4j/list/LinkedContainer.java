package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedContainer<E> implements Iterable<E> {
    private Node<E> first = null;
    private Node<E> last = null;
    private Node<E> current = null;
    private int size = 0;
    private int position = 0;
    private int modCount = 0;

    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    public void add(E value) {
        Node<E> newElement = new Node<>(value);
        if (this.first == null) {
            this.first = newElement;
            this.first.next = this.last;
            this.last = newElement;
        } else {
            this.last.next = newElement;
            this.last = newElement;
            this.modCount++;
        }
        this.size++;
    }

    public void addFirst(E value) {
        Node<E> newElement = new Node<>(value);
        if (this.first == null) {
            this.first = newElement;
        } else {
            newElement.next = this.first;
            this.first = newElement;
        }
        this.size++;
    }

    public E deleteFirst() {
        E result = this.first.data;
        this.first = this.first.next;
        return result;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    @Override
    public Iterator<E> iterator() {
        position = 0;
        current = null;
        int expectModCount = modCount;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return size > position;
            }

            @Override
            public E next() {
                if (expectModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (position == size) {
                    throw new NoSuchElementException();
                }
                if (current == null) {
                    current = first;
                }
                Node<E> result = current;
                current = current.next;
                position++;
                return result.data;
            }
        };
    }
}
