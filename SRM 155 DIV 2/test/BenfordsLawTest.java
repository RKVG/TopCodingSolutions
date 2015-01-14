import org.junit.Test;
import static org.junit.Assert.*;

public class BenfordsLawTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] transactions = new int[] { 5236,7290,200,1907,3336,9182,17,4209,8746,7932,
  6375,909,2189,3977,2389,2500,1239,3448,6380,4812 };
		int threshold = 2;
		assertEquals(1, new BenfordsLaw().questionableDigit(transactions, threshold));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] transactions = new int[] { 1,10,100,2,20,200,2000,3,30,300 };
		int threshold = 2;
		assertEquals(2, new BenfordsLaw().questionableDigit(transactions, threshold));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] transactions = new int[] { 9,87,765,6543,54321,43219,321987,21987,1987,345,234,123 };
		int threshold = 2;
		assertEquals(-1, new BenfordsLaw().questionableDigit(transactions, threshold));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] transactions = new int[] { 1,2,3,4,5,6,7,8,7,6,5,4,3,2,1 };
		int threshold = 8;
		assertEquals(9, new BenfordsLaw().questionableDigit(transactions, threshold));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] transactions = new int[] { 987,234,1234,234873487,876,234562,17,
  7575734,5555,4210,678234,3999,8123 };
		int threshold = 3;
		assertEquals(8, new BenfordsLaw().questionableDigit(transactions, threshold));
	}
}
