import org.junit.Test;
import static org.junit.Assert.*;

public class StairsTest {
	
	@Test
	public void test0() {
		int maxHeight = 22;
		int minWidth = 25;
		int totalHeight = 100;
		int totalWidth = 100;
		assertEquals(1, new Stairs().designs(maxHeight, minWidth, totalHeight, totalWidth));
	}
	
	@Test
	public void test1() {
		int maxHeight = 25;
		int minWidth = 25;
		int totalHeight = 60;
		int totalWidth = 100;
		assertEquals(2, new Stairs().designs(maxHeight, minWidth, totalHeight, totalWidth));
	}
	
	@Test
	public void test2() {
		int maxHeight = 1000;
		int minWidth = 1;
		int totalHeight = 600;
		int totalWidth = 600;
		assertEquals(6, new Stairs().designs(maxHeight, minWidth, totalHeight, totalWidth));
	}
}
