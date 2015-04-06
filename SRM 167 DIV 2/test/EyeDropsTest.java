import org.junit.Test;
import static org.junit.Assert.*;

public class EyeDropsTest {
	
	@Test(timeout=2000)
	public void test0() {
		int sleepTime = 8;
		int k = 2;
		assertEquals(720.0, new EyeDrops().closest(sleepTime, k), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int sleepTime = 9;
		int k = 3;
		assertEquals(450.0, new EyeDrops().closest(sleepTime, k), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int sleepTime = 23;
		int k = 1;
		assertEquals(1440.0, new EyeDrops().closest(sleepTime, k), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test3() {
		int sleepTime = 9;
		int k = 8;
		assertEquals(128.57142857142856, new EyeDrops().closest(sleepTime, k), 1e-9);
	}
}
