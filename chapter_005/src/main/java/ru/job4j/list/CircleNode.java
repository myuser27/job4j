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
            if (current.next == null || next.next == null || next.next.next == null) {
                break;
            } else {
                current = current.next;
                next = next.next.next;
            }
        }
        return result;
    }
}
