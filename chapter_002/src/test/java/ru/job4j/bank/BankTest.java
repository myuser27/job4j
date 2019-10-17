package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    @Test
    public void addUserTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        bank.addUser(new User("name3", "passport3"));
        Map<User, List<Account>> test = new HashMap<User, List<Account>>();
        test.put(new User("name1", "passport1"), new ArrayList<Account>());
        test.put(new User("name2", "passport2"), new ArrayList<Account>());
        test.put(new User("name3", "passport3"), new ArrayList<Account>());
        assertThat(bank.getUsers(), is(test));
    }

    @Test
    public void deleteUserTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        bank.addUser(new User("name3", "passport3"));
        bank.deleteUser(new User("name2", "passport2"));
        Map<User, List<Account>> test = new HashMap<User, List<Account>>();
        test.put(new User("name1", "passport1"), new ArrayList<Account>());
        test.put(new User("name3", "passport3"), new ArrayList<Account>());
        assertThat(bank.getUsers(), is(test));
    }

    @Test
    public void addAccountToUserTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addAccountToUser("passport1",
                new Account(1000.0, "req1"));
        Map<User, List<Account>> test = new HashMap<User, List<Account>>();
        List<Account> list = new ArrayList<Account>();
        list.add(new Account(1000.0, "req1"));
        test.put(new User("name1", "passport1"), list);
        assertThat(bank.getUsers(), is(test));
    }

    @Test
    public void deleteAccountFromUserTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.deleteAccountFromUser("passport1", account2);
        Map<User, List<Account>> test = new HashMap<User, List<Account>>();
        List<Account> list = new ArrayList<Account>();
        list.add(new Account(1000.0, "req1"));
        list.add(new Account(3000.0, "req3"));
        test.put(new User("name1", "passport1"), list);
        assertThat(bank.getUsers(), is(test));
    }

    @Test
    public void getUserAccountsTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.addAccountToUser("passport2",
                new Account(100.0, "req11"));
        bank.addAccountToUser("passport2",
                new Account(200.0, "req12"));
        List<Account> test = new ArrayList<Account>();
        test.add(new Account(1000.0, "req1"));
        test.add(new Account(200.0, "req2"));
        test.add(new Account(3000.0, "req3"));
        assertThat(bank.getUserAccounts("passport1"), is(test));
    }

    @Test
    public void transferMoneyDifferentUsersTrueTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        Account account4 = new Account(100.0, "req11");
        Account account5 = new Account(200.0, "req12");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.addAccountToUser("passport2", account4);
        bank.addAccountToUser("passport2", account5);
        boolean result = bank.transferMoney("passport1",
                "req1", "passport2",
                "req11", 900.0);
        assertThat(result, is(true));
    }

    @Test
    public void transferMoneyDifferentUsersFalseTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        Account account4 = new Account(100.0, "req11");
        Account account5 = new Account(200.0, "req12");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.addAccountToUser("passport2", account4);
        bank.addAccountToUser("passport2", account5);
        boolean result = bank.transferMoney("passport1",
                "req2", "passport2",
                "req11", 900.0);
        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyCurrentUserTrueTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        Account account4 = new Account(100.0, "req11");
        Account account5 = new Account(200.0, "req12");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.addAccountToUser("passport2", account4);
        bank.addAccountToUser("passport2", account5);
        boolean result = bank.transferMoney("passport1",
                "req1", "passport1",
                "req3", 900.0);
        assertThat(result, is(true));
    }

    @Test
    public void transferMoneyCurrentUserFalseTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        Account account4 = new Account(100.0, "req11");
        Account account5 = new Account(200.0, "req12");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.addAccountToUser("passport2", account4);
        bank.addAccountToUser("passport2", account5);
        boolean result = bank.transferMoney("passport1",
                "req2", "passport1",
                "req3", 900.0);
        assertThat(result, is(false));
    }

    @Test
    public void transferMoneyUsersWrongRequisitesFalseTest() {
        Bank bank = new Bank();
        bank.addUser(new User("name1", "passport1"));
        bank.addUser(new User("name2", "passport2"));
        Account account1 = new Account(1000.0, "req1");
        Account account2 = new Account(200.0, "req2");
        Account account3 = new Account(3000.0, "req3");
        Account account4 = new Account(100.0, "req11");
        Account account5 = new Account(200.0, "req12");
        bank.addAccountToUser("passport1", account1);
        bank.addAccountToUser("passport1", account2);
        bank.addAccountToUser("passport1", account3);
        bank.addAccountToUser("passport2", account4);
        bank.addAccountToUser("passport2", account5);
        boolean result = bank.transferMoney("passport1",
                "req13", "passport1",
                "req11", 900.0);
        assertThat(result, is(false));
    }
}
