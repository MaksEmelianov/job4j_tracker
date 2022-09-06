package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean turn = true;
        System.out.println("Game 11");
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(in.nextLine());
            if (matches > count || matches > 3 || matches < 1) {
                System.out.println("Ошибка! Введите число от 1 до 3 и не больше остатка спичек");
                continue;
            }
            turn = !turn;
            count -= matches;
            System.out.println("Спичек осталось: " + count);
            System.out.println();
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
