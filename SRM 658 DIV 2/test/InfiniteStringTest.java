import org.junit.Test;
import static org.junit.Assert.*;

public class InfiniteStringTest {
	
	@Test
	public void test0() {
		String s = "ab";
		String t = "abab";
		assertEquals("Equal", new InfiniteString().equal(s, t));
	}
	
	@Test
	public void test1() {
		String s = "abc";
		String t = "bca";
		assertEquals("Not equal", new InfiniteString().equal(s, t));
	}
	
	@Test
	public void test2() {
		String s = "abab";
		String t = "aba";
		assertEquals("Not equal", new InfiniteString().equal(s, t));
	}
	
	@Test
	public void test3() {
		String s = "aaaaa";
		String t = "aaaaaa";
		assertEquals("Equal", new InfiniteString().equal(s, t));
	}
	
	@Test
	public void test4() {
		String s = "ababab";
		String t = "abab";
		assertEquals("Equal", new InfiniteString().equal(s, t));
	}
	
	@Test
	public void test5() {
		String s = "a";
		String t = "z";
		assertEquals("Not equal", new InfiniteString().equal(s, t));
	}

	@Test
	public void test21() {
		String s = "abcab";
		String t = "abc";
		assertEquals("Not equal", new InfiniteString().equal(s, t));
	}

	@Test
	public void test23() {
		String s = "abc";
		String t = "abca";
		assertEquals("Not equal", new InfiniteString().equal(s, t));
	}
}
