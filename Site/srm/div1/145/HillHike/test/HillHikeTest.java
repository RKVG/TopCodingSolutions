import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HillHikeTest {

    @Test
    public void test0() {
        int distance = 5;
        int maxHeight = 2;
        int[] landmarks = new int[]{};
        assertEquals(3L,
                new HillHike().numPaths(distance, maxHeight, landmarks));
    }

    @Test
    public void test1() {
        int distance = 2;
        int maxHeight = 45;
        int[] landmarks = new int[]{};
        assertEquals(0L,
                new HillHike().numPaths(distance, maxHeight, landmarks));
    }

    @Test
    public void test2() {
        int distance = 5;
        int maxHeight = 2;
        int[] landmarks = new int[]{2, 2};
        assertEquals(1L,
                new HillHike().numPaths(distance, maxHeight, landmarks));
    }

    @Test
    public void test3() {
        int distance = 8;
        int maxHeight = 3;
        int[] landmarks = new int[]{2, 2, 3, 1};
        assertEquals(7L,
                new HillHike().numPaths(distance, maxHeight, landmarks));
    }

    @Test
    public void test4() {
        int distance = 38;
        int maxHeight = 11;
        int[] landmarks = new int[]{4, 5, 8, 5, 6};
        assertEquals(201667830444L,
                new HillHike().numPaths(distance, maxHeight, landmarks));
    }
}
