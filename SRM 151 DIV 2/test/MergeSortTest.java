import org.junit.Test;
import static org.junit.Assert.*;

public class MergeSortTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] numbers = new int[] {1, 2, 3, 4};
		assertEquals(4, new MergeSort().howManyComparisons(numbers));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] numbers = new int[] {2, 3, 2};
		assertEquals(2, new MergeSort().howManyComparisons(numbers));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] numbers = new int[] {-17};
		assertEquals(0, new MergeSort().howManyComparisons(numbers));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] numbers = new int[] {};
		assertEquals(0, new MergeSort().howManyComparisons(numbers));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] numbers = new int[] {-2000000000,2000000000,0,0,0,-2000000000,2000000000,0,0,0};
		assertEquals(19, new MergeSort().howManyComparisons(numbers));
	}
}
