package ru.job4j.list;

public class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        Node other = (Node) obj;
        if (this == other) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 17 * this.hashCode() + this.data.hashCode();
    }
}
