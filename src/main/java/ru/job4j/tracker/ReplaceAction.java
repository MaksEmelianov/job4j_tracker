package ru.job4j.tracker;

import ru.job4j.tracker.store.MemTracker;

public class ReplaceAction implements UserAction {

    private final Output output;

    public ReplaceAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        output.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Заявка изменена успешно.");
        } else {
            output.println("Ошибка замены заявки.");
        }
        return true;
    }
}
