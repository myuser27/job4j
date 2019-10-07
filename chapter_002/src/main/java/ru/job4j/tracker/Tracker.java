package ru.job4j.tracker;

import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    public int findIndexById(String id) {
        int index = -1;
        for(int i = 0 ; i < this.items.length; i++ ) {
            if(this.items[i].getId() == id) {
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
        if(index != -1) {
            this.items[index] = item;
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        int index = this.findIndexById(id);
        if(index != -1) {
            this.items[index] = null;
            System.arraycopy(this.items, index+1, this.items,
                    index, this.items.length-index-1);
            result = true;
        }
        return result;
    }

    public Item[] findAll() {
        Item[] fillitems = new Item[this.position+1];
        for(int i = 0 ; i < fillitems.length ; i++) {
            fillitems[i] = this.items[i];
        }
        return fillitems;
    }

    public Item[] findByName(String key) {
        Item[] tmp = new Item[this.position+1];
        int index = 0;
        for(Item item : this.items) {
            if(item != null && item.getName().equals(key)) {
                tmp[index] = item;
                index++;
            }
        }

        Item[] result = new Item[index+1];
        for(int i = 0; i < result.length ; i++) {
            result[i] = tmp[i];
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for(Item item : this.items) {
            if(item.getId().equals(id)) {
                result = item;
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
