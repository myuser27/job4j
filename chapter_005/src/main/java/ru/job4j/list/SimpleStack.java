package ru.job4j.list;

public class SimpleStack<T> {
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
        } else {
            newElement.next = this.first;
            this.first = newElement;
        }
        this.size++;
    }

    public T poll() {
        T result = this.first.data;
        this.first = this.first.next;
        return result;
    }
}
