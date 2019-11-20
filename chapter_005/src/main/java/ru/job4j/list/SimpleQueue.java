package ru.job4j.list;

public class SimpleQueue<T> {
    private Node<T> first = null;
    private int size = 0;

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public void push(T value) {
        Node<T> newElement = new Node<>(value);
        if (this.first == null) {
            this.first = newElement;
            this.first.next = null;
        } else {
            Node<T> tmp = this.first;
            while (tmp.next != null) {
                tmp = first.next;
            }
            tmp.next = newElement;
            tmp.next.next = null;
        }
        this.size++;
    }

    public T poll() {
        T result = this.first.data;
        this.first = this.first.next;
        return result;
    }
}
