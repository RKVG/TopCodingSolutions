import org.junit.Test;
import static org.junit.Assert.*;

public class WordFormTest {
	
	@Test
	public void test0() {
		String word = "WHEREABOUTS";
		assertEquals("CVCVCVC", new WordForm().getSequence(word));
	}
	
	@Test
	public void test1() {
		String word = "yoghurt";
		assertEquals("CVCVC", new WordForm().getSequence(word));
	}
	
	@Test
	public void test2() {
		String word = "YipPy";
		assertEquals("CVCV", new WordForm().getSequence(word));
	}
	
	@Test
	public void test3() {
		String word = "AyYyEYye";
		assertEquals("VCVCVCV", new WordForm().getSequence(word));
	}
	
	@Test
	public void test4() {
		String word = "yC";
		assertEquals("C", new WordForm().getSequence(word));
	}
}
