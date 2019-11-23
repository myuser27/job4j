package ru.job4j.list;

import java.util.Iterator;

public class SimpleSet<E> {
    private DinamicArray set;
    private int count = 0;

    public SimpleSet(int size) {
        this.set = new DinamicArray(size);
    }

    public void add(E value) {
        boolean key = true;
        if (this.count > 0) {
            for (int i = 0; i < this.count; i++) {
                if (this.set.get(i).equals(value)) {
                    key = false;
                    break;
                }
            }
        }
        if (this.count == 0 || key) {
            this.set.add(value);
            this.count++;
        }
    }

    public Iterator<E> iterator() {
        return this.set.iterator();
    }
}
