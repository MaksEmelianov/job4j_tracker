package ru.job4j.stream;

import java.util.List;
import java.util.stream.Stream;

public class ProductService {

    public List<String> generateLabel(List<Product> products) {
        return products.stream()
                .flatMap(Stream::ofNullable)
                .filter(product -> product.getDaysLeft() >= 0)
                .filter(product -> product.getDaysLeft() <= 3)
                .map(product -> new Label(product.getName(), product.getPrice() * 0.5f))
                .map(Label::toString)
                .toList();
    }
}
