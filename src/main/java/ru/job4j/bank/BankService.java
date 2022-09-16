package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {

    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accountList = new ArrayList<Account>();
        users.putIfAbsent(user, accountList);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null && !getAccounts(user).contains(account)) {
            getAccounts(user).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String scrPassport, String srcRequisite,
                                 String dstPassport, String dstRequisite, double amount) {
        boolean rsl = false;
        amount = Math.abs(amount);
        Account srcAccount = findByRequisite(scrPassport, srcRequisite);
        Account dstAccount = findByRequisite(dstPassport, dstRequisite);
        if (srcAccount != null && dstAccount != null
                && srcAccount.getBalance() >= amount) {
            double newSrcBalance = srcAccount.getBalance() - amount;
            srcAccount.setBalance(newSrcBalance);
            double newDstBalance = dstAccount.getBalance() + amount;
            dstAccount.setBalance(newDstBalance);
        }
        return rsl;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
