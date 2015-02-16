import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingSurveyDiv2Test {
	
	@Test
	public void test0() {
		int N = 5;
		int[] s = new int[] {3, 3};
		assertEquals(1, new ShoppingSurveyDiv2().minValue(N, s));
	}
	
	@Test
	public void test1() {
		int N = 100;
		int[] s = new int[] {97};
		assertEquals(97, new ShoppingSurveyDiv2().minValue(N, s));
	}
	
	@Test
	public void test2() {
		int N = 10;
		int[] s = new int[] {9, 9, 9, 9, 9};
		assertEquals(5, new ShoppingSurveyDiv2().minValue(N, s));
	}
	
	@Test
	public void test3() {
		int N = 7;
		int[] s = new int[] {1, 2, 3};
		assertEquals(0, new ShoppingSurveyDiv2().minValue(N, s));
	}
	
	@Test
	public void test4() {
		int N = 5;
		int[] s = new int[] {3, 3, 3};
		assertEquals(0, new ShoppingSurveyDiv2().minValue(N, s));
	}
}
