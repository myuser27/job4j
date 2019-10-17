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
            User srcUser = this.findByPassport(srcPassport);
            User destUser = this.findByPassport(destPassport);
            if (srcUser != null && destUser != null) {
                Account srcAccount = this.findByAccount(srcUser, srcRequisite);
                if (srcAccount != null) {
                    if (srcAccount.getValue() - amount > 0) {
                        srcAccount.setValue(srcAccount.getValue() - amount);
                        result = true;
                    }
                }
                if (result) {
                    result = false;
                    Account destAccount = this.findByAccount(destUser, destRequisite);
                    if (destAccount != null) {
                        destAccount.setValue(destAccount.getValue() + amount);
                        result = true;
                    }
                }
            }
        }
        return result;
    }
}
