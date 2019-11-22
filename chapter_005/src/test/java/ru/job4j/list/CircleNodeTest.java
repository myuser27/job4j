package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class CircleNodeTest {

    @Test
    public void hasCircleToFirstIsTrueTest() {
        Node one = new Node("1");
        Node two = new Node("2");
        Node three = new Node("3");
        Node four = new Node("4");

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = one;

        assertThat(new CircleNode().hasCircle(one), is(true));
    }

    @Test
    public void hasCircleToNotFirstIsTrueTest() {
        Node one = new Node("1");
        Node two = new Node("2");
        Node three = new Node("3");
        Node four = new Node("4");

        one.next = two;
        two.next = three;
        three.next = two;

        assertThat(new CircleNode().hasCircle(one), is(true));
    }

    @Test
    public void hasCircleIsFalseTest() {
        Node one = new Node("1");
        Node two = new Node("2");
        Node three = new Node("3");
        Node four = new Node("4");

        one.next = two;
        two.next = three;
        three.next = four;

        assertThat(new CircleNode().hasCircle(one), is(false));
    }
}