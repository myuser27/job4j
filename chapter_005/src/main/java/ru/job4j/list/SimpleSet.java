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
        if (this.count > 0 && value != null) {
            for (int i = 0; i < this.count; i++) {
                if (this.set.get(i) != null && this.set.get(i).equals(value)) {
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

    public static void main(String[] args) {
        SimpleSet set = new SimpleSet(3);
        set.add("1");
        set.add(null);
        set.add("2");
        set.add("1");
        Iterator it = set.iterator();
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());
    }
}
