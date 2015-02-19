import org.junit.Test;
import static org.junit.Assert.*;

public class MountainRangesTest {
	
	@Test
	public void test0() {
		int[] heights = new int[] {5, 6, 2, 4};
		assertEquals(2, new MountainRanges().countPeaks(heights));
	}
	
	@Test
	public void test1() {
		int[] heights = new int[] {1, 1, 1, 1, 1, 1, 1};
		assertEquals(0, new MountainRanges().countPeaks(heights));
	}
	
	@Test
	public void test2() {
		int[] heights = new int[] {2, 1};
		assertEquals(1, new MountainRanges().countPeaks(heights));
	}
	
	@Test
	public void test3() {
		int[] heights = new int[] {2,5,3,7,2,8,1,3,1};
		assertEquals(4, new MountainRanges().countPeaks(heights));
	}
	
	@Test
	public void test4() {
		int[] heights = new int[] {1};
		assertEquals(1, new MountainRanges().countPeaks(heights));
	}
	
	@Test
	public void test5() {
		int[] heights = new int[] {1,2,3,4,4,3,2,1};
		assertEquals(0, new MountainRanges().countPeaks(heights));
	}
}
