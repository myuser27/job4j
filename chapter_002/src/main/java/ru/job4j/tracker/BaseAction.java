package ru.job4j.tracker;

import java.util.function.Consumer;

public abstract class BaseAction implements UserAction {
    private final String action;
    protected final Consumer<String> output = System.out::println;

    protected BaseAction(final String name) {
        this.action = name;
    }

    @Override
    public String name() {
        return this.action;
    }
}
