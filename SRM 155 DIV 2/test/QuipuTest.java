import org.junit.Test;
import static org.junit.Assert.*;

public class QuipuTest {
	
	@Test(timeout=2000)
	public void test0() {
		String knots = "-XX-XXXX-XXX-";
		assertEquals(243, new Quipu().readKnots(knots));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String knots = "-XX--XXXX---XXX-";
		assertEquals(204003, new Quipu().readKnots(knots));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String knots = "-X-";
		assertEquals(1, new Quipu().readKnots(knots));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String knots = "-X-------";
		assertEquals(1000000, new Quipu().readKnots(knots));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String knots = "-XXXXXXXXX--XXXXXXXXX-XXXXXXXXX-XXXXXXX-XXXXXXXXX-";
		assertEquals(909979, new Quipu().readKnots(knots));
	}
}
