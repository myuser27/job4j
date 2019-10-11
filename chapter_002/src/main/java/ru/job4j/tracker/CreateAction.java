package ru.job4j.tracker;

public class CreateAction extends BaseAction {
    public CreateAction() {
        super("Create new item.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}