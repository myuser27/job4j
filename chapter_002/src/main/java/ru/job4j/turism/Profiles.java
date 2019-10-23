package ru.job4j.turism;

import java.util.Comparator;
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

    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(p -> p.address).distinct()
                .collect(Collectors.toList());
    }

    public List<Address> sorted(List<Address> addresses) {
        addresses.sort(new Comparator<Address>() {
            @Override
            public int compare(Address o1, Address o2) {
                int result = o1.city.compareTo(o2.city);
                return result;
            }
        });
        return addresses;
    }
}
