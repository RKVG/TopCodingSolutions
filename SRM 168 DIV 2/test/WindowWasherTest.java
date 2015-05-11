import org.junit.Test;
import static org.junit.Assert.*;

public class WindowWasherTest {
	
	@Test
	public void test0() {
		int width = 10;
		int height = 10;
		int[] washTimes = new int[] {60};
		assertEquals(6000, new WindowWasher().fastest(width, height, washTimes));
	}
	
	@Test
	public void test1() {
		int width = 10;
		int height = 10;
		int[] washTimes = new int[] {60, 60};
		assertEquals(3000, new WindowWasher().fastest(width, height, washTimes));
	}
	
	@Test
	public void test2() {
		int width = 10;
		int height = 10;
		int[] washTimes = new int[] {60, 30};
		assertEquals(2100, new WindowWasher().fastest(width, height, washTimes));
	}
	
	@Test
	public void test3() {
		int width = 1000;
		int height = 1000;
		int[] washTimes = new int[] {1000};
		assertEquals(1000000000, new WindowWasher().fastest(width, height, washTimes));
	}
	
	@Test
	public void test4() {
		int width = 421;
		int height = 936;
		int[] washTimes = new int[] {111,56,931,22,445,90,14,222};
		assertEquals(2450448, new WindowWasher().fastest(width, height, washTimes));
	}
	
	@Test
	public void test5() {
		int width = 25;
		int height = 25;
		int[] washTimes = new int[] {1,625};
		assertEquals(625, new WindowWasher().fastest(width, height, washTimes));
	}
	
	@Test
	public void test6() {
		int width = 12;
		int height = 754;
		int[] washTimes = new int[] {728, 734, 147, 464, 6, 703, 254};
		assertEquals(54288, new WindowWasher().fastest(width, height, washTimes));
	}
}
