import org.junit.Test;
import static org.junit.Assert.*;

public class SuperRotTest {
	
	@Test(timeout=2000)
	public void test0() {
		String message = "Uryyb 28";
		assertEquals("Hello 73", new SuperRot().decoder(message));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String message = "GbcPbqre";
		assertEquals("TopCoder", new SuperRot().decoder(message));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String message = "";
		assertEquals("", new SuperRot().decoder(message));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String message = "5678901234";
		assertEquals("0123456789", new SuperRot().decoder(message));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String message = "NnOoPpQqRr AaBbCcDdEe";
		assertEquals("AaBbCcDdEe NnOoPpQqRr", new SuperRot().decoder(message));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String message = "Gvzr vf 54 71 CZ ba Whyl 4gu bs gur lrne 7558 NQ";
		assertEquals("Time is 09 26 PM on July 9th of the year 2003 AD", new SuperRot().decoder(message));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String message = "Gur dhvpx oebja sbk whzcf bire n ynml qbt";
		assertEquals("The quick brown fox jumps over a lazy dog", new SuperRot().decoder(message));
	}
}
