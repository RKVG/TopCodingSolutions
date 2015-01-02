import org.junit.Test;
import static org.junit.Assert.*;

public class HappyLetterDiv2Test {
	
	@Test
	public void test0() {
		String letters = "aacaaa";
		assertEquals('a', new HappyLetterDiv2().getHappyLetter(letters));
	}
	
	@Test
	public void test1() {
		String letters = "dcdjx";
		assertEquals('.', new HappyLetterDiv2().getHappyLetter(letters));
	}
	
	@Test
	public void test2() {
		String letters = "bcbbbbba";
		assertEquals('b', new HappyLetterDiv2().getHappyLetter(letters));
	}
	
	@Test
	public void test3() {
		String letters = "aabc";
		assertEquals('.', new HappyLetterDiv2().getHappyLetter(letters));
	}

	@Test
	public void test4()  {
		String letters = "aabb";
		assertEquals('.', new HappyLetterDiv2().getHappyLetter(letters));
	}
}
