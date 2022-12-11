package ru.job4j.tracker;

import ru.job4j.tracker.store.Store;

public class TestLoadDeleteAction implements UserAction {

    private final Output output;

    public TestLoadDeleteAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Test Delete item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Test Load System - Delete Item ===");
        int count = input.askInt("Enter the number of instances: ");
        for (int i = 0; i < count; i++) {
            tracker.delete(i);
        }
        return true;
    }
}
