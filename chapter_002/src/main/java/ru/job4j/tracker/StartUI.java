package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        Item item;
        String name, id;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select:"));
            switch (select) {
                case 0:
                    System.out.println("Create new item.");
                    name = input.askStr("Enter name:");
                    item = new Item(name);
                    tracker.add(item);
                    break;
                case 1:
                    System.out.println("Show all items:");
                    Item[] items = tracker.findAll();
                    for (Item i : items) {
                        System.out.println("Id: " + i.getId() + ", name: "
                                + i.getName());
                    }
                    break;
                case 2:
                    System.out.println("Change item.");
                    id = input.askStr("Choose item id:");
                    name = input.askStr("Enter new name:");
                    item = new Item(name);
                    if (tracker.replace(id, item)) {
                        System.out.println("Change success.");
                    } else {
                        System.out.println("Change failed.");
                    }
                    break;
                case 3:
                    System.out.println("Delete item.");
                    id = input.askStr("Choose item id:");
                    if (tracker.delete(id)) {
                        System.out.println("Delete success.");
                    } else {
                        System.out.println("Delete failed.");
                    }
                    break;
                case 4:
                    System.out.println("Find item by ID.");
                    id = input.askStr("Enter item id:");
                    System.out.println("name: " + tracker.findById(id).getName());
                    break;
                case 5:
                    System.out.println("Find item by name.");
                    name = input.askStr("Enter name:");
                    tracker.findByName(name);
                    Item[] itemsname = tracker.findByName(name);
                    for (Item i : itemsname) {
                        System.out.println("Item id: " + i.getId() + ", name: "
                                + i.getName());
                    }
                    break;
                case 6:
                    run = false;
                    break;
                default:
                    break;
            }
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
