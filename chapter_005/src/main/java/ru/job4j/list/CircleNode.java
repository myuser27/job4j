package ru.job4j.list;

public class CircleNode {
    public boolean hasCircle(Node first) {
        boolean result = false;
        Node current = first;
        Node next = first.next;
        while (current != null || next != null) {
            if (current.equals(next)) {
                result = true;
                break;
            }
            try {
                current = current.next;
            } catch (NullPointerException e) {
                current = null;
            }
            try {
                next = next.next.next;
            } catch (NullPointerException e) {
                next = null;
            }
        }
        return result;
    }
}
