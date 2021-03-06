import org.junit.Test;
import static org.junit.Assert.*;

public class DoubleLetterTest {
	
	@Test(timeout=2000)
	public void test0() {
		String S = "aabccb";
		assertEquals("Possible", new DoubleLetter().ableToSolve(S));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String S = "aabccbb";
		assertEquals("Impossible", new DoubleLetter().ableToSolve(S));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String S = "abcddcba";
		assertEquals("Possible", new DoubleLetter().ableToSolve(S));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String S = "abab";
		assertEquals("Impossible", new DoubleLetter().ableToSolve(S));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String S = "aaaaaaaaaa";
		assertEquals("Possible", new DoubleLetter().ableToSolve(S));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String S = "aababbabbaba";
		assertEquals("Impossible", new DoubleLetter().ableToSolve(S));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String S = "zzxzxxzxxzzx";
		assertEquals("Possible", new DoubleLetter().ableToSolve(S));
	}
}
