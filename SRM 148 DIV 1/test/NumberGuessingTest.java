import org.junit.Test;
import static org.junit.Assert.*;

public class NumberGuessingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int range = 1000;
		int[] guesses = new int[] {500};
		int numLeft = 1;
		assertEquals(501, new NumberGuessing().bestGuess(range, guesses, numLeft));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int range = 1000000;
		int[] guesses = new int[] {};
		int numLeft = 1;
		assertEquals(500000, new NumberGuessing().bestGuess(range, guesses, numLeft));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int range = 1000;
		int[] guesses = new int[] {};
		int numLeft = 2;
		assertEquals(750, new NumberGuessing().bestGuess(range, guesses, numLeft));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int range = 100;
		int[] guesses = new int[] {27,80};
		int numLeft = 1;
		assertEquals(26, new NumberGuessing().bestGuess(range, guesses, numLeft));
	}
}
