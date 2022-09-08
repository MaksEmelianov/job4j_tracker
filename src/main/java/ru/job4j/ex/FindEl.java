package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Данного элемента нет");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] value = {"test", null, "test2"};
        try {
            System.out.println(indexOf(value, "test3"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
