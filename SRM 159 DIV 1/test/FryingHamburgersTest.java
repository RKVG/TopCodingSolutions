import org.junit.Test;
import static org.junit.Assert.*;

public class FryingHamburgersTest {
	
	@Test(timeout=2000)
	public void test0() {
		int panSize = 2;
		int hamburgers = 3;
		assertEquals(15, new FryingHamburgers().howLong(panSize, hamburgers));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int panSize = 3;
		int hamburgers = 4;
		assertEquals(15, new FryingHamburgers().howLong(panSize, hamburgers));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int panSize = 3;
		int hamburgers = 2;
		assertEquals(10, new FryingHamburgers().howLong(panSize, hamburgers));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int panSize = 100;
		int hamburgers = 0;
		assertEquals(0, new FryingHamburgers().howLong(panSize, hamburgers));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int panSize = 303;
		int hamburgers = 919;
		assertEquals(35, new FryingHamburgers().howLong(panSize, hamburgers));
	}

	@Test(timeout=2000)
	public void test4a() {
		int panSize = 3;
		int hamburgers = 8;
		assertEquals(30, new FryingHamburgers().howLong(panSize, hamburgers));
	}
}
