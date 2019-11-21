package ru.job4j.list;

public class SimpleStack<T> {
    private LinkedContainer stack = new LinkedContainer();

    public void push(T value) {
        stack.addFirst(value);
    }

    public T poll() {
        return (T) stack.deleteFirst();
    }
}
