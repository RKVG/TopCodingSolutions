import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BridgeCrossingTest {

    @Test
    public void test0() {
        int[] times = new int[]{1, 2, 5, 10};
        assertEquals(17, new BridgeCrossing().minTime(times));
    }

    @Test
    public void test1() {
        int[] times = new int[]{1, 2, 3, 4, 5};
        assertEquals(16, new BridgeCrossing().minTime(times));
    }

    @Test
    public void test2() {
        int[] times = new int[]{100};
        assertEquals(100, new BridgeCrossing().minTime(times));
    }

    @Test
    public void test3() {
        int[] times = new int[]{1, 2, 3, 50, 99, 100};
        assertEquals(162, new BridgeCrossing().minTime(times));
    }

    @Test
    public void testMine1() {
        int[] times =
                new int[]{1, 2, 3, 50, 10, 5, 6, 12, 3, 5, 9, 12, 13, 16, 17,
                        50, 15, 30, 1, 4, 33, 99, 100};
        assertEquals(271, new BridgeCrossing().minTime(times));
    }
}
