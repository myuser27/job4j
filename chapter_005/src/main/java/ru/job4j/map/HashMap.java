package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;

public class HashMap<K, V> implements Iterable<V> {
    private Object[][] map;
    private int index = 0;
    private int size;

    public HashMap() {
        this.size = 10;
        this.map = new Object[this.size][2];
    }

    public HashMap(int size) {
        this.size = size;
        this.map = new Object[this.size][2];
    }

    private Object[][] newMap(Object[][] oldMap) {
        Object[][] map = Arrays.copyOf(oldMap, this.size);
        map[this.index] = new Object[2];
        return map;
    }

    private int getIndex(K key) {
        int result = -1;
        if (this.index > 0) {
            for (int i = 0, j = this.index - 1; i <= j; i++, j--) {
                if ((int) this.map[i][0] == key.hashCode()
                        || (int) this.map[j][0] == key.hashCode()) {
                    result = (int) this.map[i][0] == key.hashCode() ? i : j;
                    break;
                }
            }
        }
        return result;
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        int index = getIndex(key);
        if (index < 0) {
            result = true;
            if (this.index == this.size) {
                this.size++;
                this.map = newMap(this.map);
            }
            this.map[this.index][0] = key.hashCode();
            this.map[this.index++][1] = value;
        }
        return result;
    }

    public V get(K key) {
        V result = null;
        int index = getIndex(key);
        if (index >= 0) {
            result = (V) this.map[index][1];
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = getIndex(key);
        if (index >= 0) {
            result = true;
            for (int j = index; j < this.index - 1; j++) {
                this.map[j][0] = this.map[j + 1][0];
                this.map[j][1] = this.map[j + 1][1];
            }
            this.map[this.index - 1][0] = null;
            this.map[this.index - 1][1] = null;
            this.index--;
            this.size--;
        }
        return result;
    }

    @Override
    public Iterator<V> iterator() {
        return new Iterator<V>() {
            int position = 0;

            @Override
            public boolean hasNext() {
                return position < index;
            }

            @Override
            public V next() {
                V result = null;
                if (hasNext()) {
                    result = (V) map[position][1];
                    position++;
                }
                return result;
            }
        };
    }
}