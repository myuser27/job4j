package ru.job4j.generic;

public class UserStore<E extends User> extends AbstractStore<E> {
    public UserStore(int count) {
        super(count);
    }
}
