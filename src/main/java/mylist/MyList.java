package mylist;
import java.util.NoSuchElementException;

public class MyList {
    private int[] array;
    private int size;

    public MyList() {
        this.array = new int[0];
    };

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.array = new int[capacity];
    }

    public MyList(int[] array) {
        if (array == null) {
            this.array = new int[0];
        } else {
            this.size = array.length;
            this.array = new int[this.size];
            System.arraycopy(array, 0, this.array, 0, this.size);
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int get(int index) {
        this.checkBounds(index);
        return this.array[index];
    }

    public void set(int index, int value) {
        this.checkBounds(index);
        this.array[index] = value;
    }

    public void add(int value) {
        if (this.size == this.array.length) {
            int[] array = new int[this.size < 4 ? 8 : this.size * 2];
            System.arraycopy(this.array, 0, array, 0, this.size);
            this.array = array;
        }
        this.array[this.size++] = value;
    }

    public void add(int index, int value) {
        if (index != this.size) {
            this.checkBounds(index);
        }
        if (this.size == this.array.length) {
            int[] array = new int[this.size < 4 ? 8 : this.size * 2];
            System.arraycopy(this.array, 0, array, 0, index);
            System.arraycopy(this.array, index, array, index + 1, this.size - index);
            this.array = array;
        } else {
            System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        }
        this.array[index] = value;
        this.size++;
    }

    public void remove(int index) {
        this.checkBounds(index);
        this.size--;
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index);
    }

    public int removeLast() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        return this.array[--this.size];
    }

    public int indexOf(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int value) {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        System.arraycopy(this.array, 0, array, 0, this.size);
        return array;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MyList other)) {
            return false;
        }
        if (this.size != other.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != other.array[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.size; i++) {
            hash = hash * 2 + this.array[i] + 137;
        }
        return hash;
    }
}
