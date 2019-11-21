package ru.job4j.list;

public class SimpleQueue<T> {
    private LinkedContainer stack = new LinkedContainer();

    public void push(T value) {
        stack.add(value);
    }

    public T poll() {
        return (T) stack.deleteFirst();
    }
}
