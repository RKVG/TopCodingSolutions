import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FixedPointTheoremTest {

    @Test
    public void test0() {
        double R = 0.1;
        assertEquals(0.0, new FixedPointTheorem().cycleRange(R), 1e-9);
    }

    @Test
    public void test1() {
        double R = 3.05;
        assertEquals(0.14754098360655865, new FixedPointTheorem().cycleRange(R),
                1e-9);
    }

    @Test
    public void test2() {
        double R = 3.4499;
        assertEquals(0.4175631735867292, new FixedPointTheorem().cycleRange(R),
                1e-9);
    }

    @Test
    public void test3() {
        double R = 3.55;
        assertEquals(0.5325704489850351, new FixedPointTheorem().cycleRange(R),
                1e-9);
    }

    @Test
    public void test4() {
        double R = 3.565;
        assertEquals(0.5454276003030636, new FixedPointTheorem().cycleRange(R),
                1e-9);
    }

    @Test
    public void test5() {
        double R = 3.5689;
        assertEquals(0.5489996297493569, new FixedPointTheorem().cycleRange(R),
                1e-9);
    }

    @Test
    public void test6() {
        double R = 3.00005;
        assertEquals(0.004713996108955176,
                new FixedPointTheorem().cycleRange(R), 1e-9);
    }
}
