package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "Show all items.";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item i : items) {
            System.out.println("Id: " + i.getId() + ", name: "
                    + i.getName());
        }
        return true;
    }
}
