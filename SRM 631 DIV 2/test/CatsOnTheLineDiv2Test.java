import org.junit.Test;
import static org.junit.Assert.*;

public class CatsOnTheLineDiv2Test {
	
	@Test(timeout = 2000)
	public void test0() {
		int[] position = new int[] {0};
		int[] count = new int[] {7};
		int time = 3;
		assertEquals("Possible", new CatsOnTheLineDiv2().getAnswer(position, count, time));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] position = new int[] {0};
		int[] count = new int[] {8};
		int time = 2;
		assertEquals("Impossible", new CatsOnTheLineDiv2().getAnswer(position, count, time));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] position = new int[] {0, 1};
		int[] count = new int[] {3, 1};
		int time = 0;
		assertEquals("Impossible", new CatsOnTheLineDiv2().getAnswer(position, count, time));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] position = new int[] {5, 0, 2};
		int[] count = new int[] {2, 3, 5};
		int time = 2;
		assertEquals("Impossible", new CatsOnTheLineDiv2().getAnswer(position, count, time));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] position = new int[] {5, 1, -10, 7, 12, 2, 10, 20};
		int[] count = new int[] {3, 4, 2, 7, 1, 4, 3, 4};
		int time = 6;
		assertEquals("Possible", new CatsOnTheLineDiv2().getAnswer(position, count, time));
	}
}
