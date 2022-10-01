package ru.job4j.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductServiceTest {

    @Test
    void whenGenerateLabels() {
        List<Product> productList = Arrays.asList(
                new Product("bread", 20, 5, 4),
                new Product("butter", 80, 30, 27),
                new Product("orange", 120, 20, 3),
                new Product("coffee", 75, 120, 30),
                new Product("potato", 45, 90, 15),
                new Product("cherry", 150, 10, 8),
                new Product("watermelon", 70, 7, 7)
        );
        Label one = new Label("bread", 10);
        Label two = new Label("butter", 40);
        Label three = new Label("cherry", 75);
        Label four = new Label("watermelon", 35);
        ProductService service = new ProductService();
        List<String> stringList = service.generateLabel(productList);
        List<String> expected = Arrays.asList(
                one.toString(),
                two.toString(),
                three.toString(),
                four.toString()
        );
        assertThat(stringList).containsAll(expected);
    }
}
