import org.junit.Test;
import static org.junit.Assert.*;

public class TennisRalliesTest {
	
	@Test
	public void test0() {
		int numLength = 3;
		String[] forbidden = new String[] {"cc","dd"};
		int allowed = 1;
		assertEquals(2, new TennisRallies().howMany(numLength, forbidden, allowed));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int numLength = 10;
		String[] forbidden = new String[] {"c"};
		int allowed = 1;
		assertEquals(1, new TennisRallies().howMany(numLength, forbidden, allowed));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int numLength = 10;
		String[] forbidden = new String[] {"c"};
		int allowed = 2;
		assertEquals(11, new TennisRallies().howMany(numLength, forbidden, allowed));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int numLength = 18;
		String[] forbidden = new String[] {"c","d"};
		int allowed = 1;
		assertEquals(0, new TennisRallies().howMany(numLength, forbidden, allowed));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int numLength = 18;
		String[] forbidden = new String[] {};
		int allowed = 1;
		assertEquals(262144, new TennisRallies().howMany(numLength, forbidden, allowed));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int numLength = 18;
		String[] forbidden = new String[] {"c","cc","ccc","cccc","ccccc","cccccc","ccccccc",
 "cccccccc","ccccccccc","cccccccccc"};
		int allowed = 100;
		assertEquals(262122, new TennisRallies().howMany(numLength, forbidden, allowed));
	}
}
