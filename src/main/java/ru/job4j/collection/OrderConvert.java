package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {

    public static HashMap<String, Order> process(List<Order> list) {
        HashMap<String, Order> rsl = new HashMap<>();
        for (Order order : list) {
            rsl.put(order.getNumber(), order);
        }
        return rsl;
    }
}
