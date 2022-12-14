package ru.job4j.tracker;

import ru.job4j.tracker.store.Store;

public class Exit implements UserAction {

    private final Output output;

    public Exit(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Exit Program";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        output.println("=== Exit Program ===");
        return false;
    }
}
