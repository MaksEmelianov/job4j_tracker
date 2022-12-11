package ru.job4j.tracker;

import ru.job4j.tracker.store.Store;

public class TestLoadCreateAction implements UserAction {

    private final Output output;

    public TestLoadCreateAction(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Test Add new Item";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Test Load System - Create Item ===");
        int count = input.askInt("Enter the number of instances: ");
        for (int i = 0; i < count; i++) {
            String name = "Name" + i;
            Item item = new Item(name);
            tracker.add(item);
        }
        return true;
    }
}
