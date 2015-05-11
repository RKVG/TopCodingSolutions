import org.junit.Test;
import static org.junit.Assert.*;

public class NumberGuesserTest {
	
	@Test
	public void test0() {
		String leftOver = "087";
		assertEquals(3, new NumberGuesser().guess(leftOver));
	}
	
	@Test
	public void test1() {
		String leftOver = "099";
		assertEquals(9, new NumberGuesser().guess(leftOver));
	}
	
	@Test
	public void test2() {
		String leftOver = "191";
		assertEquals(7, new NumberGuesser().guess(leftOver));
	}
	
	@Test
	public void test3() {
		String leftOver = "689";
		assertEquals(4, new NumberGuesser().guess(leftOver));
	}
}
