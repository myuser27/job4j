package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private final String action;

    protected BaseAction(final String name) {
        this.action = name;
    }

    @Override
    public String name() {
        return this.action;
    }
}
