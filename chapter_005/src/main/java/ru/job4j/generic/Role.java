package ru.job4j.generic;

public class Role extends Base {
    private String role;

    protected Role(String id, String role) {
        super(id);
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        Role other = (Role) obj;
        if (this == other
                || (this.getId().equals(((Role) obj).getId())
                && this.getRole().equals(other.getRole()))) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 17 * this.role.hashCode() + super.getId().hashCode();
    }
}
