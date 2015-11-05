import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleCalculatorTest {
	
	@Test
	public void test0() {
		String input = "5/3";
		assertEquals(1, new SimpleCalculator().calculate(input));
	}
	
	@Test
	public void test1() {
		String input = "15*3";
		assertEquals(45, new SimpleCalculator().calculate(input));
	}
	
	@Test
	public void test2() {
		String input = "1-10000";
		assertEquals(-9999, new SimpleCalculator().calculate(input));
	}
	
	@Test
	public void test3() {
		String input = "17+18";
		assertEquals(35, new SimpleCalculator().calculate(input));
	}
	
	@Test
	public void test4() {
		String input = "0000000000000018/00000000000000000009";
		assertEquals(2, new SimpleCalculator().calculate(input));
	}
}
