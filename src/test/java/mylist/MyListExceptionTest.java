package mylist;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyListExceptionTest {

    @Test
    void getOutOfBounds() {
        MyList list = new MyList();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }

    @Test
    void setOutOfBounds() {
        MyList list = new MyList();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, 10));
    }

    @Test
    void addByIndexOutOfBounds() {
        MyList list = new MyList();

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, 10));

        list.add(1);
        list.add(2);

        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, 10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(3, 10));
    }

    @Test
    void removeOutOfBounds() {
        MyList list = new MyList();
        list.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void removeLastFromEmpty() {
        MyList list = new MyList();

        assertThrows(NoSuchElementException.class, list::removeLast);
    }

    @Test
    void constructorNegativeCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new MyList(-1));
    }
}