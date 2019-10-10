package ru.job4j.tracker;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(new StubInput(
                new String[] {"invalid", "1"}));
        input.askInt("Enter", 1);
        assertThat(new String(mem.toByteArray()),
                is(String.format("Please enter correct data%n")));
        System.setOut(out);
    }
}
