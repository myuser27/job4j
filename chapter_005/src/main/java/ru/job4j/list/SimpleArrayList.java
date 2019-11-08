package ru.job4j.list;

public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    public E delete(E data) {
        E result = null;
        Node<E> tmpLink = this.first;
        while (tmpLink.next != null) {
            if (tmpLink.next.data.equals(data)) {
                result = tmpLink.next.data;
                tmpLink.next = tmpLink.next.next;
                this.size--;
                break;
            }
            tmpLink = tmpLink.next;
        }
        /*result = tmpLink.next.data;
        tmpLink.next = tmpLink.next.next;
        this.size--;*/
        return result;
    }

    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public int getSize() {
        return this.size;
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object obj) {
            boolean result = false;
            E other = (E) obj;
            if (this == other || this.data.equals(other)) {
                result = true;
            }
            return result;
        }

        @Override
        public int hashCode() {
            return 17 * this.data.hashCode();
        }
    }
}
