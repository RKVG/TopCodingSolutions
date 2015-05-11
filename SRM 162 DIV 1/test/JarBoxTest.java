import org.junit.Test;
import static org.junit.Assert.*;

public class JarBoxTest {
	
	@Test(timeout=2000)
	public void test0() {
		int radius = 1;
		int woodlength = 8;
		assertEquals(1, new JarBox().numJars(radius, woodlength));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int radius = 1;
		int woodlength = 16;
		assertEquals(3, new JarBox().numJars(radius, woodlength));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int radius = 1;
		int woodlength = 18;
		assertEquals(4, new JarBox().numJars(radius, woodlength));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int radius = 1;
		int woodlength = 45;
		assertEquals(32, new JarBox().numJars(radius, woodlength));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int radius = 6;
		int woodlength = 1269;
		assertEquals(784, new JarBox().numJars(radius, woodlength));
	}
}
