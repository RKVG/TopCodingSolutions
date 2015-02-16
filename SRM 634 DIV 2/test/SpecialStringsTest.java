import org.junit.Test;
import static org.junit.Assert.*;

public class SpecialStringsTest {
	
	@Test
	public void test0() {
		String current = "01";
		assertEquals("", new SpecialStrings().findNext(current));
	}
	
	@Test
	public void test1() {
		String current = "00101";
		assertEquals("00111", new SpecialStrings().findNext(current));
	}
	
	@Test
	public void test2() {
		String current = "0010111";
		assertEquals("0011011", new SpecialStrings().findNext(current));
	}
	
	@Test
	public void test3() {
		String current = "000010001001011";
		assertEquals("000010001001101", new SpecialStrings().findNext(current));
	}
	
	@Test
	public void test4() {
		String current = "01101111011110111";
		assertEquals("01101111011111111", new SpecialStrings().findNext(current));
	}
}
