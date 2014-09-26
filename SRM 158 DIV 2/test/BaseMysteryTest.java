import org.junit.Test;
import static org.junit.Assert.*;

public class BaseMysteryTest {
	
	@Test(timeout=2000)
	public void test0() {
		String equation = "1+1=2";
		assertArrayEquals(new int[] { 3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  14,  15,  16,  17,  18,  19,  20 }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String equation = "1+1=10";
		assertArrayEquals(new int[] { 2 }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String equation = "1+1=3";
		assertArrayEquals(new int[] { }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String equation = "ABCD+211=B000";
		assertArrayEquals(new int[] { 14 }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String equation = "ABCD+322=B000";
		assertArrayEquals(new int[] { 15 }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String equation = "1+0=1";
		assertArrayEquals(new int[] { 2,  3,  4,  5,  6,  7,  8,  9,  10,  11,  12,  13,  14,  15,  16,  17,  18,  19,  20 }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test6() {
		String equation = "GHIJ+1111=HJ00";
		assertArrayEquals(new int[] { 20 }, new BaseMystery().getBase(equation));
	}
	
	@Test(timeout=2000)
	public void test7() {
		String equation = "1234+8765=9999";
		assertArrayEquals(new int[] { 10,  11,  12,  13,  14,  15,  16,  17,  18,  19,  20 }, new BaseMystery().getBase(equation));
	}
}
