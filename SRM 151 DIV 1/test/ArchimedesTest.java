import org.junit.Test;
import static org.junit.Assert.*;

public class ArchimedesTest {
	
	@Test(timeout=2000)
	public void test0() {
		int numSides = 3;
		assertEquals(2.598076211353316, new Archimedes().approximatePi(numSides), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test1() {
		int numSides = 8;
		assertEquals(3.0614674589207183, new Archimedes().approximatePi(numSides), 1e-9);
	}
	
	@Test(timeout=2000)
	public void test2() {
		int numSides = 17280;
		assertEquals(3.1415926362832276, new Archimedes().approximatePi(numSides), 1e-9);
	}
}
