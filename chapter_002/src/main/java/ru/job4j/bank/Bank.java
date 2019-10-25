package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    private Map<User, List<Account>> accounts = new HashMap<User, List<Account>>();

    public Map<User, List<Account>> getUsers() {
        return this.accounts;
    }

    public User findByPassport(String passport) {
        List<User> users = this.accounts.keySet().stream()
                .filter(u -> u.getPassport().equals(passport))
                .collect(Collectors.toList());
        return users.isEmpty() ? null : users.iterator().next();
    }

    public Account findByAccount(User user, String requisite) {
        List<Account> accounts = this.accounts.get(user)
                .stream().filter(a -> a.getRequisites().equals(requisite))
                .collect(Collectors.toList());
        return accounts.isEmpty() ? null : accounts.iterator().next();
    }

    public Account findAccountByPassport(String passport, String requisite) {
        Account result = null;
        User user = this.findByPassport(passport);
        if (user != null) {
            result = this.findByAccount(user, requisite);
        }
        return result;
    }

    public void addUser(User user) {
        this.accounts.put(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        if (!this.accounts.isEmpty()) {
            this.accounts.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        if (!this.accounts.isEmpty()) {
            User user = this.findByPassport(passport);
            if (user != null) {
                this.accounts.get(user).add(account);
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (!this.accounts.isEmpty()) {
            User user = this.findByPassport(passport);
            if (user != null) {
                this.accounts.get(user).remove(account);
            }
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<Account>();
        if (!this.accounts.isEmpty()) {
            User user = this.findByPassport(passport);
            if (user != null) {
                result = this.accounts.get(user);
            }
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        boolean result = false;
        if (!this.accounts.isEmpty()) {
            Account srcAccount = this.findAccountByPassport(srcPassport,
                    srcRequisite);
            Account destAccount = this.findAccountByPassport(destPassport,
                    destRequisite);
            if (srcAccount != null && destAccount != null
                    && srcAccount.getValue() > amount) {
                srcAccount.setValue(srcAccount.getValue() - amount);
                destAccount.setValue(destAccount.getValue() + amount);
                result = true;
            }
        }
        return result;
    }
}
