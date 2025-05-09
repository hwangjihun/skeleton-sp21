package deque;

public class LinkedListDeque<T> {

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    /** Creates an empty LinkedListDeque. */
    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    public LinkedListDeque(T item) {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;

        Node firstNode = new Node(this.sentinel, item, this.sentinel);
        this.sentinel.next = firstNode;
        this.sentinel.prev = firstNode;
        this.size = 1;
    }

    public void addFirst(T item) {
        Node nodeToAdd = new Node(this.sentinel, item, this.sentinel.next);
        this.sentinel.next.prev = nodeToAdd;
        this.sentinel.next = nodeToAdd;
        this.size += 1;
    }

    public void addLast(T item) {
        Node nodeToAdd = new Node(this.sentinel.prev, item, this.sentinel);
        this.sentinel.prev.next = nodeToAdd;
        this.sentinel.prev = nodeToAdd;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        // if the node of next points to a sentinel, then
        // break the loop.
        Node L = this.sentinel.next;
        for (int i = 0; i < this.size(); i++) {
            System.out.print(L.item + " ");
            L = L.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (this.size() == 0) {
            return null;
        }
        T firstItem = this.sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = this.sentinel;
        this.size -= 1;
        return firstItem;
    }

    public T removeLast() {
        if (this.size() == 0) {
            return null;
        }
        T lastItem = this.sentinel.prev.item;
        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = this.sentinel;
        this.size -= 1;
        return lastItem;
    }

    public T get(int index) {
        if (this.size() == 0) {
            return null;
        }
        Node L = this.sentinel.next;
        T item = null;
        for (int i = 0; i < index + 1; i++) {
            item = L.item;
            L = L.next;
        }
        return item;
    }
}
