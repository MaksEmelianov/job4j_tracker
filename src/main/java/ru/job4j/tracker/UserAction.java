package ru.job4j.tracker;

import ru.job4j.tracker.store.MemTracker;

public interface UserAction {

    String name();

    boolean execute(Input input, MemTracker tracker);
}
