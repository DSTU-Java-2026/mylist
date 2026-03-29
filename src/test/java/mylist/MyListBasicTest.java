package mylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListBasicTest {

    @Test
    void testEmptyConstructorAndBasicOperations() {
        MyList list = new MyList();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        // add
        list.add(10);
        list.add(20);
        list.add(30);

        assertFalse(list.isEmpty());
        assertEquals(3, list.size());

        // get
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));

        // set
        list.set(1, 99);
        assertEquals(99, list.get(1));

        // add(index)
        list.add(1, 50); // [10, 50, 99, 30]
        assertEquals(4, list.size());
        assertEquals(50, list.get(1));
        assertEquals(99, list.get(2));

        // remove
        list.remove(2); // remove 99
        assertEquals(3, list.size());
        assertEquals(30, list.get(2));

        // contains / indexOf
        assertTrue(list.contains(50));
        assertEquals(1, list.indexOf(50));
        assertFalse(list.contains(999));
        assertEquals(-1, list.indexOf(999));

        // removeLast
        int last = list.removeLast(); // 30
        assertEquals(30, last);
        assertEquals(2, list.size());

        // toArray
        int[] arr = list.toArray();
        assertArrayEquals(new int[]{10, 50}, arr);

        // clear
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testEqualsAndHashCodeBasic() {
        MyList a = new MyList();
        MyList b = new MyList();

        a.add(1);
        a.add(2);

        b.add(1);
        b.add(2);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());

        b.add(3);

        assertNotEquals(a, b);
    }
}