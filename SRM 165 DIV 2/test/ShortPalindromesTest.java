import org.junit.Test;
import static org.junit.Assert.*;

public class ShortPalindromesTest {
	
	@Test
	public void test0() {
		String base = "RACE";
		assertEquals("ECARACE", new ShortPalindromes().shortest(base));
	}
	
	@Test
	public void test1() {
		String base = "TOPCODER";
		assertEquals("REDTOCPCOTDER", new ShortPalindromes().shortest(base));
	}
	
	@Test
	public void test2() {
		String base = "Q";
		assertEquals("Q", new ShortPalindromes().shortest(base));
	}
	
	@Test
	public void test3() {
		String base = "MADAMIMADAM";
		assertEquals("MADAMIMADAM", new ShortPalindromes().shortest(base));
	}
	
	@Test
	public void test4() {
		String base = "ALRCAGOEUAOEURGCOEUOOIGFA";
		assertEquals("AFLRCAGIOEOUAEOCEGRURGECOEAUOEOIGACRLFA", new ShortPalindromes().shortest(base));
	}
}
