package ru.job4j.bank;

public class Account {
    private double value;
    private String requisites;

    public Account(Double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if(o != null && this.getClass() == o.getClass()) {
            Account account = (Account) o;
            result = this.getRequisites().equals(account.getRequisites())
                    && this.getValue() == account.getValue();
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 37 * result
                + (this.getValue() == 0 ? 0 :(int) this.getValue());
        result = 37 * result
                + (this.getRequisites() == null
                ? 0 : this.getRequisites().hashCode());
        return result;
    }
}
