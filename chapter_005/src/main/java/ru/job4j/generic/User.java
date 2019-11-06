package ru.job4j.generic;

public class User extends Base {
    private String name;

    protected User(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        User other = (User) obj;
        if (this == other
                || (this.getId().equals(((User) obj).getId())
                && this.getName().equals(other.getName()))) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 17 * this.name.hashCode() + super.getId().hashCode();
    }
}
