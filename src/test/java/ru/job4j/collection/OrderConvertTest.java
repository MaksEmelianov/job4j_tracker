package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderConvertTest {

    @Test
    void whenSingleOrder() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("123", "Order1"));
        HashMap<String, Order> map = OrderConvert.process(orderList);
        Order expected = new Order("123", "Order1");
        assertThat(map.get("123")).isEqualTo(expected);
    }

    @Test
    void whenDuplicateOrder() {
        List<Order> orderList = new ArrayList<>();
        orderList.add(new Order("123", "Order1"));
        orderList.add(new Order("123", "Order1"));
        orderList.add(new Order("123", "Order1"));
        HashMap<String, Order> map = OrderConvert.process(orderList);
        assertThat(map.size()).isEqualTo(1);
    }
}
