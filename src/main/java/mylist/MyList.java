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
            this.array = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                this.array[i] = array[i];
            }
            this.size = array.length;
        }
    }

    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.array[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.array[index] = value;
    }

    public void add(int value) {
        if (this.size == this.array.length) {
            int[] array = new int[this.size < 4 ? 8 : this.size * 2];
            for (int i = 0; i < this.size; i++) {
                array[i] = this.array[i];
            }
            this.array = array;
        }
        this.array[this.size++] = value;
    }

    public void add(int index, int value) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == this.array.length) {
            int[] array = new int[this.size < 4 ? 8 : this.size * 2];
            for (int i = 0; i < index; i++) {
                array[i] = this.array[i];
            }
            array[index] = value;
            for (int i = index; i < this.size; i++) {
                array[i + 1] = this.array[i];
            }
            this.array = array;
            this.size++;
        } else {
            for (int i = this.size++; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            this.array[index] = value;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        this.size--;
        for (int i = index; i < this.size; i++) {
            this.array[i] = this.array[i + 1];
        }
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
        for (int i = 0; i < this.size; i++) {
            array[i] = this.array[i];
        }
        return array;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean equals(Object o) {
        if (o instanceof MyList other) {
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
        return false;
    }

    public int hashCode() {
        int hash = 0;
        for (int i = 0; i < this.size; i++) {
            hash = hash * 2 + this.array[i] + 137;
        }
        return hash;
    }
}
