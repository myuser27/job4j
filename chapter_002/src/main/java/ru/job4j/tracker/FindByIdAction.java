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
            output.accept("name: " + item.getName());
        } else {
            output.accept("Items with id: " + id + " not found.");
        }
        return true;
    }
}