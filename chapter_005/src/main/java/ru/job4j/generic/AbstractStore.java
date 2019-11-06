package ru.job4j.generic;

public abstract class AbstractStore implements Store {
    private Base[] arrays;
    private int index = 0;

    public AbstractStore(int count) {
        this.arrays = new Base[count];
    }

    @Override
    public void add(Base model) {
        this.arrays[this.index++] = model;
    }

    @Override
    public boolean replace(String id, Base model) {
        boolean result = false;
        for (int i = 0; i < this.arrays.length; i++) {
            if (this.arrays[i].getId().equals(id)) {
                this.arrays[i] = model;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.arrays.length; i++) {
            if (this.arrays[i].getId().equals(id)) {
                if (i < this.index) {
                    System.arraycopy(this.arrays,
                            i + 1,
                            this.arrays,
                            i,
                            (this.arrays.length - 1) - i);
                }
                this.index--;
                this.arrays[this.index] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Base findById(String id) {
        Base base = null;
        for (int i = 0; i < this.arrays.length; i++) {
            if (this.arrays[i].getId().equals(id)) {
                base = this.arrays[i];
                break;
            }
        }
        return base;
    }
}
