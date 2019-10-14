package ru.job4j.tracker;

import java.util.List;

public class ShowAllAction extends BaseAction {
    public ShowAllAction() {
        super("Show all items.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        for (Item i : items) {
            System.out.println("Id: " + i.getId() + ", name: "
                    + i.getName());
        }
        return true;
    }
}
