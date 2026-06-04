package uz.ds;

public class CustomLinked<T> {
    private Node head;
    private Node last;

    private int size = 0;

    public T add(T element) {
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

    public T add(T element, int index) {
        validIndex(index);

        if (index == size)
            add(element);
        else {
           findAndSet(element, index);
            size++;
        }
        return element;
    }

    public void remove(int index) {
        validIndex(index);

        if (index == 0) {
            head = head.next;
            size--;
        }else {
            Node pointer = head;
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.next;
            }

            Node indexNode = pointer.next;
            pointer.next = indexNode.next;

            size--;
        }
    }

    public T get(int index) {
        validIndex(index);

        Node pointer = head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }

        return pointer.element;
    }

    private void findAndSet(T element, int index) {
        Node pointer = head;

        for (int i = 0; i < index - 1; i++) {
            pointer = pointer.next;
        }

        Node indexElement = pointer.next;
        pointer.next = new Node(element, indexElement);
    }

    private void validIndex(int index) {
        if (index > size || index < 0)
            throw new IllegalArgumentException("Indexxxxx broooooooooo!");
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
