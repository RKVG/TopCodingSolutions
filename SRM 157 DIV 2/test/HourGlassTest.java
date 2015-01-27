import org.junit.Test;
import static org.junit.Assert.*;

public class HourGlassTest {
	
	@Test(timeout=2000)
	public void test0() {
		int glass1 = 5;
		int glass2 = 7;
		assertArrayEquals(new int[] { 5,  7,  9,  10,  11,  12,  13,  14,  15,  16 }, new HourGlass().measurable(glass1, glass2));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int glass1 = 13;
		int glass2 = 5;
		assertArrayEquals(new int[] { 5,  10,  13,  15,  16,  17,  18,  19,  20,  21 }, new HourGlass().measurable(glass1, glass2));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int glass1 = 23;
		int glass2 = 23;
		assertArrayEquals(new int[] { 23,  46,  69,  92,  115,  138,  161,  184,  207,  230 }, new HourGlass().measurable(glass1, glass2));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int glass1 = 24;
		int glass2 = 30;
		assertArrayEquals(new int[] { 24,  30,  36,  42,  48,  54,  60,  66,  72,  78 }, new HourGlass().measurable(glass1, glass2));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int glass1 = 1;
		int glass2 = 50;
		assertArrayEquals(new int[] { 1,  2,  3,  4,  5,  6,  7,  8,  9,  10 }, new HourGlass().measurable(glass1, glass2));
	}
}
