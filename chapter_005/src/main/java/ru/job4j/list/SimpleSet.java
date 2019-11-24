package ru.job4j.list;

import java.util.Iterator;

public class SimpleSet<E> {
    private DinamicArray set;
    private int count = 0;

    public SimpleSet(int size) {
        this.set = new DinamicArray(size);
    }

    public void add(E value) {
        if (!isDublicate(value)) {
            this.set.add(value);
            this.count++;
        }
    }

    public boolean isDublicate(E value) {
        boolean result = false;
        if (this.count > 0) {
            for (int i = 0; i < this.count; i++) {
                if (this.set.get(i) == value
                        || (this.set.get(i) != null && this.set.get(i).equals(value))) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public Iterator<E> iterator() {
        return this.set.iterator();
    }
}
