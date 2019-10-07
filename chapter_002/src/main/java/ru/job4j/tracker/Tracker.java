package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            item.setId(id);
            this.items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            this.items[index] = null;
            System.arraycopy(this.items, index + 1, this.items,
                    index, this.items.length - index - 1);
            this.position--;
            result = true;
        }
        return result;
    }

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[this.position + 1];
        int index = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                tmp[index] = this.items[i];
                index++;
            }
        }
        return Arrays.copyOf(tmp, index);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }

    private String generateId() {
        Random rnd = new Random();
        return String.valueOf(rnd.nextLong() + System.currentTimeMillis());
    }
}