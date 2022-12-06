package ru.job4j.tracker;

import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.util.Arrays;
import java.util.List;

public class StartUI {

    private final Output output;

    public StartUI(Output output) {
        this.output = output;
    }

    public void init(Input input, Store tracker, List<UserAction> actions) {
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
        for (int index = 0; index < actions.size(); index++) {
            output.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = Arrays.asList(
                    new CreateAction(out),
                    new ReplaceAction(out),
                    new DeleteAction(out),
                    new FindAllAction(out),
                    new FindByIdAction(out),
                    new FindByNameAction(out),
                    new Exit(out)
            );
            new StartUI(out).init(input, tracker, actions);
        } catch (Exception e) {
            SqlTracker.logging();
        }
    }
}
