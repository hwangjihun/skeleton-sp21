package deque;

public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(Node prev, T item, Node next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    /* Create an empty LinkedListDeque (only contains a sentinel node)
    * In this case, my sentinel node item value will just be null*/
    public LinkedListDeque() {
        this.sentinel = new Node(null, null, null);
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
        this.size = 0;
    }

    public void addFirst(T item) {
        Node nodeToAdd = new Node(this.sentinel, item, this.sentinel.next);
        this.sentinel.next = nodeToAdd;
        this.sentinel.next.prev = nodeToAdd;
        this.size += 1;
    }

    public void addLast(T item) {
        Node nodeToAdd = new Node(this.sentinel.prev, item, this.sentinel);
        this.sentinel.prev.next = nodeToAdd;
        this.sentinel.prev = nodeToAdd;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node currentNode = this.sentinel.next;
        for (int i = 0; i < this.size; i++) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        T firstItem = this.sentinel.next.item;
        this.sentinel.next = this.sentinel.next.next;
        this.sentinel.next.prev = this.sentinel;
        this.size -= 1;
        return firstItem;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        T lastItem = this.sentinel.prev.item;
        this.sentinel.prev = this.sentinel.prev.prev;
        this.sentinel.prev.next = this.sentinel;
        this.size -= 1;
        return lastItem;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        Node currentNode = this.sentinel.next;
        for (int i = 0; i < index; i += 1) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    private T getRecursive(int index, Node currentNode) {
        if (index == 0) {
            return currentNode.item;
        }
        return getRecursive(index - 1, currentNode.next);
    }

    public T getRecursive(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        } else {
            return getRecursive(index, this.sentinel.next);
        }
    }

    /*
    (we can implement this after lecture 11)
    public Iterator<T> iterator() {

    }

    public boolean equals(Object o) {
    }
    */
}
