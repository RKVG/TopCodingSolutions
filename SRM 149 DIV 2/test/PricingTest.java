import org.junit.Test;
import static org.junit.Assert.*;

public class PricingTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] price = new int[] {9,1,5,5,5,5,4,8,80};
		assertEquals(120, new Pricing().maxSales(price));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] price = new int[] {17,50,2};
		assertEquals(69, new Pricing().maxSales(price));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] price = new int[] {130,110,90,13,6,5,4,3,0};
		assertEquals(346, new Pricing().maxSales(price));
	}
}
