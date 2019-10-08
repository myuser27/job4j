package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select:"));
            switch (select) {
                case 0:
                    StartUI.createItem(input, tracker);
                    break;
                case 1:
                    StartUI.showAllItems(input, tracker);
                    break;
                case 2:
                    StartUI.replaceItem(input, tracker);
                    break;
                case 3:
                    StartUI.deleteItem(input, tracker);
                    break;
                case 4:
                    StartUI.findItemById(input, tracker);
                    break;
                case 5:
                    StartUI.findItemByName(input, tracker);
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("Create new item.");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("Show all items:");
        Item[] items = tracker.findAll();
        for (Item i : items) {
            System.out.println("Id: " + i.getId() + ", name: "
                    + i.getName());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("Change item.");
        String id = input.askStr("Choose item id:");
        String name = input.askStr("Enter new name:");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Change success.");
        } else {
            System.out.println("Change failed.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("Delete item.");
        String id = input.askStr("Choose item id:");
        if (tracker.delete(id)) {
            System.out.println("Delete success.");
        } else {
            System.out.println("Delete failed.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("Find item by ID.");
        String id = input.askStr("Enter item id:");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("name: " + item.getName());
        } else {
            System.out.println("Items with id: " + id + " not found.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("Find item by name.");
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
    }

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
