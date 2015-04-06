import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryCardinalityTest {
	
	@Test
	public void test0() {
		int[] numbers = new int[] {4};
		assertArrayEquals(new int[] { 4 }, new BinaryCardinality().arrange(numbers));
	}
	
	@Test
	public void test1() {
		int[] numbers = new int[] {31,15,7,3,2};
		assertArrayEquals(new int[] { 2,  3,  7,  15,  31 }, new BinaryCardinality().arrange(numbers));
	}
	
	@Test
	public void test2() {
		int[] numbers = new int[] {10,9,8,7,6,5,4,3,2,1};
		assertArrayEquals(new int[] { 1,  2,  4,  8,  3,  5,  6,  9,  10,  7 }, new BinaryCardinality().arrange(numbers));
	}
	
	@Test
	public void test3() {
		int[] numbers = new int[] {811385,340578,980086,545001,774872,855585,13848,863414,419523,190151,784903,127461};
		assertArrayEquals(new int[] { 13848,  340578,  545001,  855585,  419523,  811385,  127461,  190151,  774872,  863414,  784903,  980086 }, new BinaryCardinality().arrange(numbers));
	}
}
