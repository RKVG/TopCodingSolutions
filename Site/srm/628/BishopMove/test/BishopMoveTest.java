import org.junit.Test;
import static org.junit.Assert.*;

public class BishopMoveTest {

	@Test
	public void test0() {
		int r1 = 4;
		int c1 = 6;
		int r2 = 7;
		int c2 = 3;
		assertEquals(1, new BishopMove().howManyMoves(r1, c1, r2, c2));
	}

	@Test
	public void test1() {
		int r1 = 2;
		int c1 = 5;
		int r2 = 2;
		int c2 = 5;
		assertEquals(0, new BishopMove().howManyMoves(r1, c1, r2, c2));
	}

	@Test
	public void test2() {
		int r1 = 1;
		int c1 = 3;
		int r2 = 5;
		int c2 = 5;
		assertEquals(2, new BishopMove().howManyMoves(r1, c1, r2, c2));
	}

	@Test
	public void test3() {
		int r1 = 4;
		int c1 = 6;
		int r2 = 7;
		int c2 = 4;
		assertEquals(-1, new BishopMove().howManyMoves(r1, c1, r2, c2));
	}
}
