package ru.job4j.tracker;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream def = System.out;

    @Before
    public void loadOut() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void loadDefault() {
        System.setOut(this.def);
    }

    @Test
    public void whenInit() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(action);
        new StartUI().init(input, new Tracker(), actions);
        assertThat(action.isCall(), is(true));
    }

    @Test
    public void whenShowMenu() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(action);
        new StartUI().init(input, new Tracker(), actions);
        String expect = new StringJoiner(System.lineSeparator(), "",
                System.lineSeparator()).add("Menu:")
                .add("0. Stub action").toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whereShowAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        ShowAllAction action = new ShowAllAction();
        action.execute(new StubInput(new String[]{}), tracker);
        String expect = new StringJoiner(System.lineSeparator(),
                "", System.lineSeparator()).add("Id: " + item.getId()
                + ", name: " + item.getName()).toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }

    @Test
    public void whereFindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        FindByNameAction find = new FindByNameAction();
        find.execute(new StubInput(new String[]{"test1"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(),
                "", System.lineSeparator()).add("Item id: " + item.getId()
                + ", name: " + item.getName()).toString();
        assertThat(new String(out.toByteArray()), is(expect));
    }
}
