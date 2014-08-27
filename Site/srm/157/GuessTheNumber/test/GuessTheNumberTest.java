import org.junit.Test;
import static org.junit.Assert.*;

public class GuessTheNumberTest {
	
	@Test(timeout=2000)
	public void test0() {
		int upper = 9;
		int answer = 6;
		assertEquals(3, new GuessTheNumber().noGuesses(upper, answer));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int upper = 1000;
		int answer = 750;
		assertEquals(2, new GuessTheNumber().noGuesses(upper, answer));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int upper = 643;
		int answer = 327;
		assertEquals(7, new GuessTheNumber().noGuesses(upper, answer));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int upper = 157;
		int answer = 157;
		assertEquals(8, new GuessTheNumber().noGuesses(upper, answer));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int upper = 128;
		int answer = 64;
		assertEquals(1, new GuessTheNumber().noGuesses(upper, answer));
	}
}
