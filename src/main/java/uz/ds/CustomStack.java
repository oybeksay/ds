package uz.ds;

public class CustomStack<T> {
    private Node head;
    private Node last;

    private int size = 0;

    public T push(T element) {
        if (head == null) {
            head = new Node(element);
            last = head;
        } else {
            Node newNode = new Node(element);
            last.next = newNode;
            last = newNode;
        }
        size++;
        return element;
    }

    public T pop () {
        if (size == 1) {
            Node lastNode = last;
            head = null;
            last = null;
            size--;
            return lastNode.element;
        }

        Node pointer = head;
        for (int i = 0; i < size - 1; i++) {
            pointer = pointer.next;
        }

        Node lastNode = last;
        last = pointer;
        last.next = null;

        size--;
        return lastNode.element;
    }

    public T peek() {
        return last.element;
    }

    public int size() {
        return size;
    }

    private class Node {
        T element;
        Node next;

        public Node(T element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(T element) {
            this.element = element;
        }
    }
}

