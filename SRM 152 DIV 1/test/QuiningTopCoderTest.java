import org.junit.Test;
import static org.junit.Assert.*;

public class QuiningTopCoderTest {
	
	@Test
	public void test0() {
		String source = ",";
		assertEquals("QUINES 0", new QuiningTopCoder().testCode(source));
	}
	
	@Test
	public void test1() {
		String source = "_";
		assertEquals("TIMEOUT", new QuiningTopCoder().testCode(source));
	}
	
	@Test
	public void test2() {
		String source = "1:+:1J";
		assertEquals("OVERFLOW 147", new QuiningTopCoder().testCode(source));
	}
	
	@Test
	public void test3() {
		String source = "0,1+:#@:$1J";
		assertEquals("QUINES 91", new QuiningTopCoder().testCode(source));
	}
	
	@Test
	public void test4() {
		String source = "0,1+::9W-9W-S1W1W:+2_J_@_@";
		assertEquals("BADEND 437", new QuiningTopCoder().testCode(source));
	}
	
	@Test
	public void test5() {
		String source = "#R,#:+1+:#,R#";
		assertEquals("QUINES 97", new QuiningTopCoder().testCode(source));
	}
	
	@Test
	public void test6() {
		String source = "R,#1+1:";
		assertEquals("MISMATCH 7", new QuiningTopCoder().testCode(source));
	}
}
