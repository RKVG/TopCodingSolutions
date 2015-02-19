import org.junit.Test;
import static org.junit.Assert.*;

public class PoolTest {
	
	@Test
	public void test0() {
		int[] triangle = new int[] {6, 12, 14, 1, 8, 2, 11, 3, 9, 4, 7, 13, 5, 15, 10};
		assertEquals(0, new Pool().rackMoves(triangle));
	}
	
	@Test
	public void test1() {
		int[] triangle = new int[] {2, 10, 7, 1, 8, 12, 6, 11, 4, 9, 13, 3, 14, 15, 5};
		assertEquals(2, new Pool().rackMoves(triangle));
	}
	
	@Test
	public void test2() {
		int[] triangle = new int[] {8, 15, 9, 4, 10, 6, 11, 3, 14, 7, 2, 1, 13, 12, 5};
		assertEquals(3, new Pool().rackMoves(triangle));
	}
	
	@Test
	public void test3() {
		int[] triangle = new int[] {15, 5, 8, 13, 2, 14, 10, 3, 4, 6, 7, 9, 1, 12, 11};
		assertEquals(4, new Pool().rackMoves(triangle));
	}
	
	@Test
	public void test4() {
		int[] triangle = new int[] {1, 5, 15, 6, 10, 9, 11, 13, 7, 4, 3, 8, 2, 12, 14};
		assertEquals(3, new Pool().rackMoves(triangle));
	}
}
