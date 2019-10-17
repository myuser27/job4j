package ru.job4j.bank;

public class User {
    private String name;
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return this.name;
    }

    public String getPassport() {
        return this.passport;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null && this.getClass() == o.getClass()) {
            User user = (User) o;
            result = this.getName().equals(user.getName())
                    && this.getPassport().equals(user.getPassport());
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 37 * result
                + (this.getName() == null ? 0 : this.getName().hashCode());
        result = 37 * result
                + (this.getPassport() == null ? 0 : this.getPassport().hashCode());
        return result;
    }
}
