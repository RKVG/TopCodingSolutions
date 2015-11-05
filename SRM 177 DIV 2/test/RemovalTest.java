import org.junit.Test;
import static org.junit.Assert.*;

public class RemovalTest {
	
	@Test
	public void test0() {
		int n = 8;
		int k = 3;
		String[] remove = new String[] {"3-4","4-5"};
		assertEquals(5, new Removal().finalPos(n, k, remove));
	}
	
	@Test
	public void test1() {
		int n = 100;
		int k = 13;
		String[] remove = new String[] {"19-50","19-50","19-19"};
		assertEquals(13, new Removal().finalPos(n, k, remove));
	}
	
	@Test
	public void test2() {
		int n = 100;
		int k = 39;
		String[] remove = new String[] {"19-50","19-50","19-19"};
		assertEquals(-1, new Removal().finalPos(n, k, remove));
	}

	@Test
	public void test5() {
		int n = 2000000000;
		int k = 2000000000;
		String[] remove = new String[] {"1-1999999003"};
		assertEquals(-1, new Removal().finalPos(n, k, remove));
	}

	@Test
	public void test23() {
		int n = 2000000000;
		int k = 2000000000;
		String[] remove = new String[] {"1-2000000000"};
		assertEquals(-1, new Removal().finalPos(n, k, remove));
	}

}
