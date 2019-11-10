package ru.job4j.generic;

public class RoleStore<E extends Role> extends AbstractStore<Role> {
    public RoleStore(int count) {
        super(count);
    }
}