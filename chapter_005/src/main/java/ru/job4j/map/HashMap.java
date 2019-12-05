package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;

public class HashMap<K, V> implements Iterable<V> {
    private class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private Node[] map;
    private int index = 0;
    private int size;

    public HashMap() {
        this.size = 10;
        this.map = new Node[this.size];
    }

    public HashMap(int size) {
        this.size = size;
        this.map = new Node[this.size];
    }

    private Node[] newMap(Node[] oldMap) {
        return Arrays.copyOf(oldMap, this.size);
    }

    private int getIndex(K key) {
        int result = -1;
        if (this.index > 0) {
            for (int i = 0, j = this.index - 1; i <= j; i++, j--) {
                if ((int) this.map[i].getKey() == key.hashCode()
                        || (int) this.map[j].getKey() == key.hashCode()) {
                    result = (int) this.map[i].getKey() == key.hashCode() ? i : j;
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
            this.map[this.index++] = new Node(key.hashCode(), value);
        }
        return result;
    }

    public V get(K key) {
        V result = null;
        int index = getIndex(key);
        if (index >= 0) {
            result = (V) this.map[index].getValue();
        }
        return result;
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = getIndex(key);
        if (index >= 0) {
            result = true;
            for (int j = index; j < this.index - 1; j++) {
                this.map[j].setKey(this.map[j + 1].getKey());
                this.map[j].setValue(this.map[j + 1].getValue());
            }
            this.map[this.index - 1] = null;
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
                    result = (V) map[position].getValue();
                    position++;
                }
                return result;
            }
        };
    }
}