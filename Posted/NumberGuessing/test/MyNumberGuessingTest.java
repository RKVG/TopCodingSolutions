import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: Patrick Date: 7/13/2014 Time: 7:33 PM Description:
 */
public class MyNumberGuessingTest {

    @Test
    public void test_best_0() {
        int[] guesses = new int[]{1, 500};
        assertEquals(501, new NumberGuessing().bestGuess(1000, guesses, 0));
    }


    @Test
    public void test_best_1() {
        int[] guesses = new int[]{};
        assertEquals(750, new NumberGuessing().bestGuess(1000, guesses, 2));

    }

    @Test
    public void test_calculateYield_1() {
        int[] guesses = new int[]{1, 2};
        int yield = new NumberGuessing().calculateYield(2, guesses, 10);
        assertEquals(9, yield);
    }

    @Test
    public void test_calculateYield_2() {
        int[] guesses = new int[]{1, 3};
        int yield = new NumberGuessing().calculateYield(3, guesses, 10);
        assertEquals(8, yield);
    }

    @Test
    public void test_calculateYield_3() {
        int[] guesses = new int[]{1, 4};
        int yield = new NumberGuessing().calculateYield(4, guesses, 10);
        assertEquals(8, yield);
    }

    @Test
    public void test_calculateYield_4() {
        int[] guesses = new int[]{9, 10};
        int yield = new NumberGuessing().calculateYield(9, guesses, 10);
        assertEquals(9, yield);
    }

    @Test
    public void test_calculateYield_5() {
        int[] guesses = new int[]{8, 10};
        int yield = new NumberGuessing().calculateYield(8, guesses, 10);
        assertEquals(8, yield);
    }

    @Test
    public void test_calculateYield_6() {
        int[] guesses = new int[]{7, 10};
        int yield = new NumberGuessing().calculateYield(7, guesses, 10);
        assertEquals(8, yield);
    }

    @Test
    public void test_calculateYield_7() {
        int[] guesses = new int[]{3, 5, 7};
        int yield = new NumberGuessing().calculateYield(5, guesses, 10);
        assertEquals(1, yield);
    }

    @Test
    public void test_calculateYield_8() {
        int[] guesses = new int[]{3, 5, 8};
        int yield = new NumberGuessing().calculateYield(5, guesses, 10);
        assertEquals(2, yield);
    }

    @Test
    public void test_calculateYield_9() {
        int[] guesses = new int[]{2, 5, 8};
        int yield = new NumberGuessing().calculateYield(5, guesses, 10);
        assertEquals(3, yield);
    }

    @Test
    public void test_calculateYield_10() {
        int[] guesses = new int[]{499, 500};
        int yield = new NumberGuessing().calculateYield(499, guesses, 1000);
        assertEquals(499, yield);
    }

    @Test
    public void test_calculateYield_11() {
        int[] guesses = new int[]{500, 501};
        int yield = new NumberGuessing().calculateYield(501, guesses, 1000);
        assertEquals(500, yield);
    }

    @Test
    public void test_getPossibleGuesses_1()  {
        int[] guesses = new int[] {};
        Set<Integer> possibleGuesses = NumberGuessing.getPossibleGuesses
                (1000, guesses, false);
        assertTrue(possibleGuesses.contains(750));
    }
}
