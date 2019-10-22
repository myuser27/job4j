package ru.job4j.tracker;

public class DeleteAction extends BaseAction {
    public DeleteAction() {
        super("Delete item.");
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Choose item id:");
        if (tracker.delete(id)) {
            output.accept("Delete success.");
        } else {
            output.accept("Delete failed.");
        }
        return true;
    }
}