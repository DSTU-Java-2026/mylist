package mylist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListPerformanceTest {

    @Test
    void addShouldBeAmortizedConstant() {
        MyList list = new MyList();

        int n = 100_000;

        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000L, "add is too slow");
    }

    @Test
    void getShouldBeConstantTime() {
        MyList list = new MyList();

        int n = 100_000;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long start = System.nanoTime();

        for (int i = 0; i < n; i++) {
            list.get(i);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 500_000_000L, "get is too slow");
    }

    @Test
    void addManyShouldScaleLinearly() {
        MyList list1 = new MyList();
        MyList list2 = new MyList();

        int n1 = 50_000;
        int n2 = 100_000;

        long start1 = System.nanoTime();
        for (int i = 0; i < n1; i++) {
            list1.add(i);
        }
        long time1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        for (int i = 0; i < n2; i++) {
            list2.add(i);
        }
        long time2 = System.nanoTime() - start2;

        assertTrue(time2 < time1 * 5, "add scale badly");
    }

    @Test
    void removeFromStartShouldBeLinear() {
        MyList list = new MyList();

        int n = 50_000;
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        long start = System.nanoTime();

        for (int i = 0; i < n / 2; i++) {
            list.remove(0);
        }

        long duration = System.nanoTime() - start;

        assertTrue(duration < 1_000_000_000L, "remove is too slow");
    }
}