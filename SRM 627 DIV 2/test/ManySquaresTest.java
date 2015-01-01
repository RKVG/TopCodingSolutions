import org.junit.Test;
import static org.junit.Assert.*;

public class ManySquaresTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] sticks = new int[] {1,1,2,2,1,1,2};
		assertEquals(1, new ManySquares().howManySquares(sticks));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] sticks = new int[] {3, 1, 4, 4, 4, 10, 10, 10, 10}
;
		assertEquals(1, new ManySquares().howManySquares(sticks));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] sticks = new int[] {1,2,3,4,1,2,3,4,1,2,3,1,2,3,4,1,2,3,3,3};
		assertEquals(3, new ManySquares().howManySquares(sticks));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] sticks = new int[] {1,1,1,2,2,2,3,3,3,4,4,4};
		assertEquals(0, new ManySquares().howManySquares(sticks));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] sticks = new int[] {1,1,1,2,1,1,1,3,1,1,1};
		assertEquals(2, new ManySquares().howManySquares(sticks));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] sticks = new int[] {2,2,4,4,8,8};
		assertEquals(0, new ManySquares().howManySquares(sticks));
	}
}
