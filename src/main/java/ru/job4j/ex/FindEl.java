package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int index = 0; index < value.length; index++) {
            if (key.equals(value[index])) {
                rsl = index;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Данного элемента нет");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementAbuseException {
        for (String abuse : abuses) {
            if (value.equals(abuse)) {
                throw new ElementAbuseException("Есть запрещенный ключ");
            }
        }
        return true;
    }

    public static void process(String[] value, String key, String[] abuses) {
        try {
            if (indexOf(value, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
