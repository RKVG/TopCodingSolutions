import org.junit.Test;
import static org.junit.Assert.*;

public class TireRotationTest {
	
	@Test(timeout=2000)
	public void test0() {
		String initial = "ABCD";
		String current = "ABCD";
		assertEquals(1, new TireRotation().getCycle(initial, current));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String initial = "ABCD";
		String current = "DCAB";
		assertEquals(2, new TireRotation().getCycle(initial, current));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String initial = "ABCD";
		String current = "CDBA";
		assertEquals(4, new TireRotation().getCycle(initial, current));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String initial = "ABCD";
		String current = "ABDC";
		assertEquals(-1, new TireRotation().getCycle(initial, current));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String initial = "ZAXN";
		String current = "XNAZ";
		assertEquals(4, new TireRotation().getCycle(initial, current));
	}
}
