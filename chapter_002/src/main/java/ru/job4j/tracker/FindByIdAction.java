package ru.job4j.tracker;

public class FindByIdAction extends BaseAction {
    public FindByIdAction() {
        super("Find item by ID.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter item id:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("name: " + item.getName());
        } else {
            System.out.println("Items with id: " + id + " not found.");
        }
        return true;
    }
}