package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель пользователя банка,
 * эта модель содержит поля: паспорт и юзернейм.
 * Для доступа к полям были созданы геттеры и сеттеры.
 * @author Maks Emelianov
 * @version 1.0
 */
public class User {

    /**
     * Хранение данных осуществляется в @param passport и @param username
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
