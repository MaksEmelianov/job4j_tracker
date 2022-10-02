package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает функиональность главный сервис управления банкосвкой системой.
 * Возможности: Добавление пользователей, Добавление аккаунтов, Поиск юзера по пасторту,
 * Поиск аккаунта по реквизитам, Совершение переводов между аккаунтами по паспорту и реквизитам.
 *
 * @author Maks Emelianov
 * @version 1.0
 */
public class BankService {

    /**
     * Хранение данных осуществляется в коллекции типа HashMap с ключем модели пользователя
     * и данными принаждежащих ему аккаунтов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в систему с пустым список принадлежащих ему акканутов.
     * Если пользователь не найден, то поисходит добавление.
     *
     * @param user пользователь которого добавляют
     */
    public void addUser(User user) {
        List<Account> accountList = new ArrayList<>();
        users.putIfAbsent(user, accountList);
    }

    /**
     * Метод принимает на вход паспорт пользователя и новый аккаунт, который присвает этому пользователю.
     * Если пользователь не найден, то добавление аккаунта не произойдет.
     *
     * @param passport паспорт пользователя
     * @param account  добавляемый аккаунт
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = getAccounts(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }

    /**
     * Метод выполняет поиск по данным паспорта, который принимаются на вход.
     *
     * @param passport данные паспорта пользователя
     * @return возвращает найденного пользователя, если пользователь не найден - возвращает null
     */

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> passport.equals(user.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод выполняет поиск аккаунта по паспорту и реквизитам, которые принимает на вход.
     * Если пользователь не найден, прерывается поиск аккаунта.
     *
     * @param passport  паспорт пользователя
     * @param requisite реквизиты аккаунта
     * @return возвращает найденый аккаунт, либо null если ничего не найдено
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(account -> requisite.equals(account.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод выполняет функционал обмена денежными средствами.
     * Принимает на сход данные "Отправителя" и "Получателя".
     * Перевод производится если найдены все аккаунты и пользователи,
     * и выполняется условие наличие денег у отправителя.
     *
     * @param scrPassport  паспортные данные "Отправителя"
     * @param srcRequisite реквизиты аккаунта "Отправителя"
     * @param dstPassport  паспортные данные "Получателя"
     * @param dstRequisite реквизиты аккаунта "Получателя"
     * @param amount       переводимые денежные средства
     * @return возвращает true если перевод совершен,
     * false если какое либо из условий не было выполенно
     */
    public boolean transferMoney(String scrPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(scrPassport, srcRequisite);
        Account dstAccount = findByRequisite(dstPassport, dstRequisite);
        if (srcAccount != null && dstAccount != null
                && srcAccount.getBalance() >= amount) {
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            dstAccount.setBalance(dstAccount.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод позволяет получить список прикрепленных аккаунтов к пользователю,
     * которого принимает на вход
     *
     * @param user пользователь, чьи аккауты получаем
     * @return возвращает список аккаунтов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
