import org.junit.Test;
import static org.junit.Assert.*;

public class JumpingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int x = 5;
		int y = 4;
		int[] jumpLengths = new int[] {2, 5};
		assertEquals("Able", new Jumping().ableToGet(x, y, jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int x = 3;
		int y = 4;
		int[] jumpLengths = new int[] {4};
		assertEquals("Not able", new Jumping().ableToGet(x, y, jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int x = 3;
		int y = 4;
		int[] jumpLengths = new int[] {6};
		assertEquals("Not able", new Jumping().ableToGet(x, y, jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int x = 0;
		int y = 1;
		int[] jumpLengths = new int[] {100, 100};
		assertEquals("Able", new Jumping().ableToGet(x, y, jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int x = 300;
		int y = 400;
		int[] jumpLengths = new int[] {500};
		assertEquals("Able", new Jumping().ableToGet(x, y, jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int x = 11;
		int y = 12;
		int[] jumpLengths = new int[] {1,2,3,4,5,6,7,8,9,10};
		assertEquals("Able", new Jumping().ableToGet(x, y, jumpLengths));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int x = 11;
		int y = 12;
		int[] jumpLengths = new int[] {1,2,3,4,5,6,7,8,9,100};
		assertEquals("Not able", new Jumping().ableToGet(x, y, jumpLengths));
	}
}
