package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {

    public static void main(String[] args) {
        Attachment[] attrs = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> comparator = Comparator.comparingInt(Attachment::getSize);
        Comparator<String> cmpSize = Comparator.comparingInt(String::length);
        Comparator<String> cmpDescSize = (o1, o2) -> Integer.compare(o2.length(), o1.length());
        Comparator<String> cmpText = String::compareTo;

        Arrays.sort(attrs, comparator);

        /*
        Comparator<String> cmpText = (o1, o2) -> o1.compareTo(o2);
        Comparator<Attachment> comparator = (o1, o2) -> Integer.compare(o1.getSize(), o2.getSize());
        Comparator<Attachment> comparator = new Comparator<>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
         */
    }
}
