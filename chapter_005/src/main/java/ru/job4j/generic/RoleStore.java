package ru.job4j.generic;

public class RoleStore<E extends Role> extends AbstractStore<E> {
    public RoleStore(int count) {
        super(count);
    }
}