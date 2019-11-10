package ru.job4j.generic;

public class UserStore<E extends User> extends AbstractStore<User> {
    public UserStore(int count) {
        super(count);
    }
}
