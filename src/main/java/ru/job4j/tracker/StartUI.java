package ru.job4j.tracker;

import java.util.List;

public class StartUI {

    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                output.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        output.println("Menu:");
        for (UserAction action : actions) {
            output.println(
                    actions.indexOf(action)
                            + ". "
                            + action.name()
            );
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ReplaceAction(out),
                new DeleteAction(out),
                new FindAllAction(out),
                new FindByIdAction(out),
                new FindByNameAction(out),
                new Exit(out)
        );
        new StartUI(out).init(input, tracker, actions);
    }
}
