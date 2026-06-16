package mylist;

import java.util.NoSuchElementException;

public class MyList {
    private static final int INITIAL_CAPACITY = 8;

    private int[] elements;
    private int length;

    public MyList() {
        elements = new int[INITIAL_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must not be negative");
        }
        elements = new int[capacity];
    }

    public MyList(int[] array) {
        if (array == null) {
            elements = new int[INITIAL_CAPACITY];
            return;
        }

        elements = new int[array.length];
        System.arraycopy(array, 0, elements, 0, array.length);
        length = array.length;
    }

    public int get(int index) {
        requireExistingIndex(index);
        return elements[index];
    }

    public void set(int index, int value) {
        requireExistingIndex(index);
        elements[index] = value;
    }

    public void add(int value) {
        makeRoomFor(length + 1);
        elements[length] = value;
        length++;
    }

    public void add(int index, int value) {
        requireInsertIndex(index);
        makeRoomFor(length + 1);

        if (index < length) {
            System.arraycopy(elements, index, elements, index + 1, length - index);
        }

        elements[index] = value;
        length++;
    }

    public void remove(int index) {
        requireExistingIndex(index);

        int tailLength = length - index - 1;
        if (tailLength > 0) {
            System.arraycopy(elements, index + 1, elements, index, tailLength);
        }

        length--;
    }

    public int removeLast() {
        if (length == 0) {
            throw new NoSuchElementException("list is empty");
        }

        length--;
        return elements[length];
    }

    public int indexOf(int value) {
        for (int i = 0; i < length; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int[] toArray() {
        int[] copy = new int[length];
        System.arraycopy(elements, 0, copy, 0, length);
        return copy;
    }

    public void clear() {
        length = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyList other)) {
            return false;
        }
        if (length != other.length) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (elements[i] != other.elements[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        for (int i = 0; i < length; i++) {
            hash = hash * 37 + elements[i];
        }
        return hash;
    }

    private void makeRoomFor(int wantedCapacity) {
        if (wantedCapacity <= elements.length) {
            return;
        }

        int nextCapacity = elements.length == 0 ? 1 : elements.length + elements.length / 2 + 1;
        if (nextCapacity < wantedCapacity) {
            nextCapacity = wantedCapacity;
        }

        int[] expanded = new int[nextCapacity];
        System.arraycopy(elements, 0, expanded, 0, length);
        elements = expanded;
    }

    private void requireExistingIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds for size " + length);
        }
    }

    private void requireInsertIndex(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("index " + index + " out of bounds for insertion");
        }
    }
}
