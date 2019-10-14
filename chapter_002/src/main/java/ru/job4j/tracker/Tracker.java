package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>(100);
    private int position = 0;

    public int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < position; i++) {
            if (this.items.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(this.position++, item);
        return item;
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            item.setId(id);
            this.items.set(index, item);
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndexById(id);
        if (index != -1) {
            this.items.remove(index);
            this.position--;
            result = true;
        }
        return result;
    }

    public List<Item> findAll() {
        return this.items.subList(0, this.position);
    }

    public List<Item> findByName(String key) {
        List<Item> tmp = new ArrayList<Item>();
        for (Item i : this.items) {
            if (i.getName().equals(key)) {
                tmp.add(i);
            }
        }
        return tmp;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item i : this.items) {
            if (i.getId().equals(id)) {
                result = i;
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