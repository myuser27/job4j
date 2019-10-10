package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    public void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(), new ShowAllAction(),
                new ReplaceAction(), new DeleteAction(), new FindByIdAction(),
                new FindByNameAction(), new ExitAction()};
        new StartUI().init(input, tracker, actions);
    }
}
