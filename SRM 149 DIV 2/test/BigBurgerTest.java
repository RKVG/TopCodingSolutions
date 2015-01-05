import org.junit.Test;
import static org.junit.Assert.*;

public class BigBurgerTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] arrival = new int[] {3,3,9};
		int[] service = new int[] {2,15,14};
		assertEquals(11, new BigBurger().maxWait(arrival, service));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] arrival = new int[] {182};
		int[] service = new int[] {11};
		assertEquals(0, new BigBurger().maxWait(arrival, service));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] arrival = new int[] {2,10,11};
		int[] service = new int[] {3,4,3};
		assertEquals(3, new BigBurger().maxWait(arrival, service));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] arrival = new int[] {2,10,12};
		int[] service = new int[] {15,1,15};
		assertEquals(7, new BigBurger().maxWait(arrival, service));
	}
}
