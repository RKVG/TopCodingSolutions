import org.junit.Test;
import static org.junit.Assert.*;

public class QuiltingTest {
	
	@Test
	public void test0() {
		int length = 3;
		int width = 2;
		String[] colorList = new String[] {"RED","BLUE","TAN"};
		assertEquals("TAN", new Quilting().lastPatch(length, width, colorList));
	}
	
	@Test
	public void test1() {
		int length = 4;
		int width = 3;
		String[] colorList = new String[] {"E","D","C","B","A"};
		assertEquals("E", new Quilting().lastPatch(length, width, colorList));
	}
	
	@Test
	public void test2() {
		int length = 3;
		int width = 3;
		String[] colorList = new String[] {"A","B","C","D"};
		assertEquals("C", new Quilting().lastPatch(length, width, colorList));
	}
	
	@Test
	public void test3() {
		int length = 1;
		int width = 1;
		String[] colorList = new String[] {"RED","BLUE","YELLOW"};
		assertEquals("RED", new Quilting().lastPatch(length, width, colorList));
	}
	
	@Test
	public void test4() {
		int length = 10;
		int width = 10;
		String[] colorList = new String[] {"X","Y","Z"};
		assertEquals("Z", new Quilting().lastPatch(length, width, colorList));
	}
}
