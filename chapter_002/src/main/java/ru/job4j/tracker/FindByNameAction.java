package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction extends BaseAction {
    public FindByNameAction() {
        super("Find item by name.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item i : items) {
                output.accept("Item id: " + i.getId() + ", name: " + i.getName());
            }
        } else {
            output.accept("Items with name " + name + " not found.");
        }
        return true;
    }
}