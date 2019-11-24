package ru.job4j.list;

public class SimpleQueue<T> {
    private SimpleStack stack = new SimpleStack();
    private SimpleStack queue = new SimpleStack();
    private int count = 0;

    public void push(T value) {
        if (this.count == 0) {
            this.queue.push(value);
            this.count++;
        } else {
            for (int i = 1; i < this.count + 1; i++) {
                this.stack.push(this.queue.poll());
            }
            this.stack.push(value);
            this.count++;
            for (int i = 1; i < this.count + 1; i++) {
                this.queue.push(this.stack.poll());
            }
        }
    }

    public T poll() {
        return (T) this.queue.poll();
    }
}
