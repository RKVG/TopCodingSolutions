import org.junit.Test;
import static org.junit.Assert.*;

public class CircleGameTest {
	
	@Test(timeout=2000)
	public void test0() {
		String deck = "KKKKKKKKKK";
		assertEquals(0, new CircleGame().cardsLeft(deck));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String deck = "KKKKKAQT23";
		assertEquals(1, new CircleGame().cardsLeft(deck));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String deck = "KKKKATQ23J";
		assertEquals(6, new CircleGame().cardsLeft(deck));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String deck = "AT68482AK6875QJ5K9573Q";
		assertEquals(4, new CircleGame().cardsLeft(deck));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String deck = "AQK262362TKKAQ6262437892KTTJA332";
		assertEquals(24, new CircleGame().cardsLeft(deck));
	}
}
