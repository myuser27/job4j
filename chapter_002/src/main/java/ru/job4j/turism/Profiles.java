package ru.job4j.turism;

import ru.job4j.prof.Profession;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static class Profile {
        private Address address;

        public Profile(Address address) {
            this.address = address;
        }
    }

    public static class Address {
        private String city;
        private String street;
        private int home;
        private int apartment;

        public Address(String city, String street, int home, int apartment) {
            this.city = city;
            this.street = street;
            this.home = home;
            this.apartment = apartment;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            Address other = (Address) obj;
            if (this == obj || (this.city.equals(other.city)
                    && this.street.equals(other.street)
                    && this.apartment == other.apartment
                    && this.home == other.home)) {
                result = true;
            }
            return result;
        }

        @Override
        public int hashCode() {
            return 17 * this.apartment + this.home
                    + this.street.hashCode() + this.city.hashCode();
        }
    }

    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(p -> p.address).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Profile> profiles = List.of(
                new Profile(new Address("City1", "Street1", 1, 1)),
                new Profile(new Address("City1", "Street2", 10, 5)),
                new Profile(new Address("City2", "Street4", 18, 45)),
                new Profile(new Address("City3", "Street1", 3, 12)));
        Profiles pr = new Profiles();
        List<Address> a = pr.collect(profiles);
    }
}
