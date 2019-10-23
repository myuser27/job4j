package ru.job4j.turism;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ProfilesTest {
    @Test
    public void whereGetAddress() {
        List<Profiles.Profile> profiles = List.of(
                new Profiles.Profile(new Profiles.Address("City1",
                        "Street1", 1, 1)),
                new Profiles.Profile(new Profiles.Address("City1",
                        "Street1", 1, 1)),
                new Profiles.Profile(new Profiles.Address("City2",
                        "Street4", 18, 45)),
                new Profiles.Profile(new Profiles.Address("City3",
                        "Street1", 3, 12)));
        List<Profiles.Address> expect = List.of(
                new Profiles.Address("City1", "Street1",
                        1, 1),
                new Profiles.Address("City2", "Street4",
                        18, 45),
                new Profiles.Address("City3", "Street1",
                        3, 12));
        assertThat(new Profiles().collect(profiles), is(expect));
    }

    @Test
    public void whereAddressSorted() {
        List<Profiles.Profile> profiles = List.of(
                new Profiles.Profile(new Profiles.Address("City3",
                        "Street1", 3, 12)),
                new Profiles.Profile(new Profiles.Address("City1",
                        "Street1", 1, 1)),
                new Profiles.Profile(new Profiles.Address("City1",
                        "Street1", 1, 1)),
                new Profiles.Profile(new Profiles.Address("City2",
                        "Street4", 18, 45)));
        List<Profiles.Address> addresses = new Profiles().collect(profiles);
        List<Profiles.Address> expect = List.of(
                new Profiles.Address("City1", "Street1",
                        1, 1),
                new Profiles.Address("City2", "Street4",
                        18, 45),
                new Profiles.Address("City3", "Street1",
                        3, 12));
        assertThat(new Profiles().sorted(addresses), is(expect));
    }
}
