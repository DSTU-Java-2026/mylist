package mylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListEqualsHashCodeTest {

    @Test
    void equalsSameContent() {
        MyList a = new MyList(new int[]{1, 2, 3});
        MyList b = new MyList(new int[]{1, 2, 3});

        assertEquals(a, b);
        assertEquals(b, a);
    }

    @Test
    void notEqualsDifferentSize() {
        MyList a = new MyList(new int[]{1, 2, 3});
        MyList b = new MyList(new int[]{1, 2});

        assertNotEquals(a, b);
    }

    @Test
    void notEqualsDifferentOrder() {
        MyList a = new MyList(new int[]{1, 2, 3});
        MyList b = new MyList(new int[]{3, 2, 1});

        assertNotEquals(a, b);
    }

    @Test
    void notEqualsDifferentValues() {
        MyList a = new MyList(new int[]{1, 2, 3});
        MyList b = new MyList(new int[]{1, 2, 4});

        assertNotEquals(a, b);
    }

    @Test
    void equalsReflexive() {
        MyList a = new MyList(new int[]{1, 2, 3});

        assertEquals(a, a);
    }

    @Test
    void equalsWithNullAndDifferentType() {
        MyList a = new MyList(new int[]{1, 2, 3});

        assertNotEquals(a, null);
        assertNotEquals(a, "not a list");
    }

    @Test
    void hashCodeEqualsContract() {
        MyList a = new MyList(new int[]{1, 2, 3});
        MyList b = new MyList(new int[]{1, 2, 3});

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }
}