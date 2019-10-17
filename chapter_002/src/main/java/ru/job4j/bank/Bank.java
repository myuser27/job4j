package ru.job4j.bank;

import java.util.*;

public class Bank {
    private Map<User, List<Account>> accounts = new HashMap<User, List<Account>>();

    public Map<User, List<Account>> getUsers() {
        return this.accounts;
    }

    public void addUser(User user) {
        this.accounts.put(user, new ArrayList<Account>());
    }

    public void deleteUser(User user) {
        if(!this.accounts.isEmpty()){
            this.accounts.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        if(!this.accounts.isEmpty()) {
            for(User u : this.accounts.keySet()) {
                if(u.getPassport().equals(passport)) {
                    this.accounts.get(u).add(account);
                }
            }
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if(!this.accounts.isEmpty()) {
            for(User u : this.accounts.keySet()) {
                if(u.getPassport().equals(passport)) {
                    this.accounts.get(u).remove(account);
                }
            }
        }
    }

    public List<Account> getUserAccounts (String passport) {
        List<Account> result = new ArrayList<Account>();
        if(!this.accounts.isEmpty()) {
            for(User u : this.accounts.keySet()) {
                if(u.getPassport().equals(passport)) {
                    result = this.accounts.get(u);
                }
            }
        }
        return result;
    }

    public boolean transferMoney (String srcPassport, String srcRequisite,
                                  String destPassport, String destRequisite,
                                  double amount) {
        boolean result = false;
        if(!this.accounts.isEmpty()) {
            User srcUser = null, destUser = null;
            for(User u : this.accounts.keySet()) {
                if(u.getPassport().equals(srcPassport)) {
                    srcUser = u;
                }
                if(u.getPassport().equals(destPassport)) {
                    destUser = u;
                }
                if(srcUser != null && destUser !=null) {
                    for(Account a : this.accounts.get(srcUser)) {
                        if (a.getRequisites().equals(srcRequisite)) {
                            if(a.getValue() - amount > 0) {
                                a.setValue(a.getValue() - amount);
                                result = true;
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                    if(result == true) {
                        result = false;
                        for (Account a : this.accounts.get(destUser)) {
                            if (a.getRequisites().equals(destRequisite)) {
                                a.setValue(a.getValue() + amount);
                                result = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
