package ru.job4j.tracker;

public class ReplaceAction extends BaseAction {
    public ReplaceAction() {
        super("Change item.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Choose item id:");
        String name = input.askStr("Enter new name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Change success.");
        } else {
            System.out.println("Change failed.");
        }
        return true;
    }
}