package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /* Creates an empty array deque*/
    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFirst = 4;
        this.nextLast = 5;
    }

    private void resize(int capacity) {

    }

    public void addFirst(T item) {
        this.items[nextFirst] = item;
        this.size += 1;
        // Useful technique to know ** (instead of using if condition)
        this.nextFirst = (this.nextFirst - 1 + this.items.length) % this.items.length;
    }

    public void addLast(T item) {
        this.items[nextLast] = item;
        this.size += 1;
        // Useful technique to know ** (instead of using if condition)
        this.nextLast = (this.nextLast + 1) % this.items.length;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = 0; i < this.size(); i++) {
            int idx = (this.nextFirst + 1 + i) % items.length;
            System.out.print(this.items[idx] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (this.size() == 0) {
            return null;
        }
        int firstIdx = (this.nextFirst + 1) % this.items.length;
        T firstItem = this.items[firstIdx];
        this.items[firstIdx] = null;
        this.size -= 1;
        this.nextFirst = firstIdx;
        return firstItem;
    }

    public T removeLast() {
        if (this.size() == 0) {
            return null;
        }
        int lastIdx = (this.nextLast - 1 + this.items.length) % this.items.length;
        T lastItem = this.items[lastIdx];
        this.items[lastIdx] = null;
        this.size -= 1;
        this.nextLast = lastIdx;
        return lastItem;
    }

    public T get(int index) {
        if (index < 0 || index > this.size - 1) {
            return null;
        }
        int realIndex = (this.nextFirst + 1 + index) % this.items.length;
        return this.items[realIndex];
    }
}
