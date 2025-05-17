package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        this.items = (T[]) new Object[8];
        this.size = 0;
        this.nextFirst = 4;
        this.nextLast = 5;
    }

    public void addLast(T item) {
        if (this.items.length == this.size) {
            resize(this.items.length * 2);
        }
        this.items[this.nextLast] = item;
        this.nextLast = (this.nextLast + 1) % this.items.length;
        this.size += 1;
    }

    public void addFirst(T item) {
        if (this.items.length == this.size) {
            resize(this.items.length * 2);
        }
        this.items[this.nextFirst] = item;
        this.nextFirst = (this.nextFirst - 1 + this.items.length) % this.items.length;
        this.size += 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        int startIdx = this.nextFirst + 1;
        int endIdx = startIdx + this.size;
        for (int i = startIdx; i < endIdx; i++) {
            System.out.print(this.items[i % this.items.length] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }
        resizeDown();
        int idxToRemove = (this.nextFirst + 1) % this.items.length;
        T itemToRemove = this.items[idxToRemove];
        this.items[idxToRemove] = null;
        this.size -= 1;
        this.nextFirst = idxToRemove;
        return itemToRemove;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }
        resizeDown();
        int idxToRemove = (this.nextLast - 1 + this.items.length) % this.items.length;
        T itemToRemove = this.items[idxToRemove];
        this.items[idxToRemove] = null;
        this.size -= 1;
        this.nextLast = idxToRemove;
        return itemToRemove;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        }
        int realIdx = ((this.nextFirst + 1) + index) % this.items.length;
        return items[realIdx];
    }

    private void resize(int capacity) {
        T[] newArr = (T[]) new Object[capacity];
        for (int i = 0; i < this.size; i++) {
            newArr[i] = this.get(i);
        }
        this.items = newArr;
        this.nextFirst = capacity - 1;
        this.nextLast = this.size;
    }

    private void resizeDown() {
        if (this.items.length >= 16) {
            double usageRatio = (double) this.size / this.items.length;
            if (usageRatio < 0.25) {
                resize(this.items.length / 2);
            }
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