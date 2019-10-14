package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertListTest {
    @Test
    public void whereConvertTest() {
        List<int[]> arr = new ArrayList<int[]>();
        ConvertList cl = new ConvertList();
        arr.add(new int[] {1, 2, 3});
        arr.add(new int[] {4, 5, 6, 7, 8});
        List<Integer> result = cl.convert(arr);
        assertThat(result.toArray(), is(new int[] {1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
