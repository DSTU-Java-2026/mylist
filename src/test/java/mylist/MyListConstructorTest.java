package mylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListConstructorTest {

    @Test
    void defaultConstructor() {
        MyList list = new MyList();

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        list.add(10);
        assertEquals(1, list.size());
        assertEquals(10, list.get(0));
    }

    @Test
    void capacityConstructor() {
        MyList list = new MyList(5);

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        for (int i = 0; i < 5; i++) {
            list.add(i);
        }

        assertEquals(5, list.size());

        list.add(100);
        assertEquals(6, list.size());
        assertEquals(100, list.get(5));
    }

    @Test
    void capacityConstructorZero() {
        MyList list = new MyList(0);

        assertEquals(0, list.size());

        list.add(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    void capacityConstructorNegative() {
        assertThrows(IllegalArgumentException.class, () -> new MyList(-1));
    }

    @Test
    void arrayConstructor() {
        int[] arr = {1, 2, 3};

        MyList list = new MyList(arr);

        assertEquals(3, list.size());
        assertArrayEquals(new int[]{1, 2, 3}, list.toArray());
    }

    @Test
    void arrayConstructorCopiesArray() {
        int[] arr = {1, 2, 3};

        MyList list = new MyList(arr);

        arr[0] = 999;

        assertEquals(1, list.get(0));
    }
}