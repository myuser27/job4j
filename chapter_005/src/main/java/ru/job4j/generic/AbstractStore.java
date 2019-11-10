package ru.job4j.generic;

public abstract class AbstractStore<E extends Base> implements Store<E> {
    private SimpleArray<E> arrays;
    private int index = 0;

    public AbstractStore(int count) {
        this.arrays = new SimpleArray<>(count);
    }

    @Override
    public void add(E model) {
        this.arrays.add(model);
        this.index++;
    }

    @Override
    public boolean replace(String id, E model) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (this.arrays.get(i).getId().equals(id)) {
                this.arrays.set(i, model);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (this.arrays.get(i).getId().equals(id)) {
                this.arrays.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public E findById(String id) {
        E result = null;
        for (int i = 0; i < this.index; i++) {
            if (this.arrays.get(i).getId().equals(id)) {
                result = this.arrays.get(i);
                break;
            }
        }
        return result;
    }
}
