package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Пароль пуст");
        }
        if (!checkAbusePass(password)) {
            throw new IllegalArgumentException("Пароль слишком легкий");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Пароль несоответсвует шаблону длины: 8 - 32 символа");
        }
        if (checkChars(password) == 0) {
            throw new IllegalArgumentException("Добавьте в пароль хотя бы одну строчную будку");
        }
        if (checkChars(password) == 1) {
            throw new IllegalArgumentException("Добавьте в пароль хотя бы одну прописную будку");
        }
        if (checkChars(password) == 2) {
            throw new IllegalArgumentException("Добавьте в пароль хотя бы одну цифру");
        }
        if (checkChars(password) == 3) {
            throw new IllegalArgumentException("Добавьте в пароль хотя бы однин спец. знак");
        }
        return "Пароль валидный";
    }

    public static void main(String[] args) {
        System.out.println(validate("admiiiiiiiiI1n"));
    }

    private static int checkChars(String password) {
        String msg = "";
        char[] chars = password.toCharArray();
        boolean[] flags = new boolean[4];
        for (char ch : chars) {
            if (Character.isLowerCase(ch)) {
                flags[0] = true;
            }
            if (Character.isUpperCase(ch)) {
                flags[1] = true;
            }
            if (Character.isDigit(ch)) {
                flags[2] = true;
            }
            if (!Character.isLetterOrDigit(ch)) {
                flags[3] = true;
            }
        }
        for (int index = 0; index < flags.length; index++) {
            if (!flags[index]) {
                return index;
            }
        }
        return -1;
    }

    private static boolean checkAbusePass(String password) {
        String[] abuses = {"qwerty", "12345", "password", "admin", "user"};
        String normPass = password.toLowerCase().trim();
        for (String abuse : abuses) {
            if (normPass.contains(abuse)) {
                return false;
            }
        }
        return true;
    }
}
