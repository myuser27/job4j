package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> accounts = new HashMap<User, List<Account>>();

    public Map<User, List<Account>> getUsers() {
        return this.accounts;
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User u : this.accounts.keySet()) {
            if (u.getPassport().equals(passport)) {
                user = u;
                break;
            }
        }
        return user;
    }

    public Account findByAccount(User user, String requisite) {
        Account account = null;
        for (Account a : this.accounts.get(user)) {
            if (a.getRequisites().equals(requisite)) {
                account = a;
            }
        }
        return account;
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