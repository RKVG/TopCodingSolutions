import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InterestingDigitsTest {

    @Test
    public void test0() {
        int base = 10;
        assertArrayEquals(new int[]{3, 9},
                new InterestingDigits().digits(base));
    }

    @Test
    public void test1() {
        int base = 3;
        assertArrayEquals(new int[]{2}, new InterestingDigits().digits(base));
    }

    @Test
    public void test2() {
        int base = 9;
        assertArrayEquals(new int[]{2, 4, 8},
                new InterestingDigits().digits(base));
    }

    @Test
    public void test3() {
        int base = 26;
        assertArrayEquals(new int[]{5, 25},
                new InterestingDigits().digits(base));
    }

    @Test
    public void test4() {
        int base = 30;
        assertArrayEquals(new int[]{29}, new InterestingDigits().digits(base));
    }
}
