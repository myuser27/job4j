package ru.job4j.task;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class DepartmentsSortTest {
    @Test
    public void whereSortArray() {
        DepartmentsSort names = new DepartmentsSort();
        String[] result = names.sort();
        String[] expect = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        assertThat(result, is(expect));
    }

    @Test
    public void whereReversSortArray() {
        DepartmentsSort names = new DepartmentsSort();
        String[] array = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2"};
        String[] result = names.sortRevers(array);
        String[] expect = {"K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1"};
        assertThat(result, is(expect));
    }
}
