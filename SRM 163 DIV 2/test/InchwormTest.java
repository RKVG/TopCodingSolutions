import org.junit.Test;
import static org.junit.Assert.*;

public class InchwormTest {
	
	@Test(timeout=2000)
	public void test0() {
		int branch = 11;
		int rest = 2;
		int leaf = 4;
		assertEquals(3, new Inchworm().lunchtime(branch, rest, leaf));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int branch = 12;
		int rest = 6;
		int leaf = 4;
		assertEquals(2, new Inchworm().lunchtime(branch, rest, leaf));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int branch = 20;
		int rest = 3;
		int leaf = 7;
		assertEquals(1, new Inchworm().lunchtime(branch, rest, leaf));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int branch = 21;
		int rest = 7;
		int leaf = 3;
		assertEquals(2, new Inchworm().lunchtime(branch, rest, leaf));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int branch = 15;
		int rest = 16;
		int leaf = 5;
		assertEquals(1, new Inchworm().lunchtime(branch, rest, leaf));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int branch = 1000;
		int rest = 3;
		int leaf = 7;
		assertEquals(48, new Inchworm().lunchtime(branch, rest, leaf));
	}
	
	@Test(timeout=2000)
	public void test6() {
		int branch = 1000;
		int rest = 7;
		int leaf = 3;
		assertEquals(48, new Inchworm().lunchtime(branch, rest, leaf));
	}
}
