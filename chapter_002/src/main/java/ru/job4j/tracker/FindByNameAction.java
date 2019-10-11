package ru.job4j.tracker;

public class FindByNameAction extends BaseAction {
    public FindByNameAction() {
        super("Find item by name.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item i : items) {
                System.out.println("Item id: " + i.getId() + ", name: "
                        + i.getName());
            }
        } else {
            System.out.println("Items with name " + name + " not found.");
        }
        return true;
    }
}