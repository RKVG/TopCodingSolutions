import org.junit.Test;
import static org.junit.Assert.*;

public class PaperFoldTest {
	
	@Test
	public void test0() {
		int[] paper = new int[] {8, 11};
		int[] box = new int[] {6, 10};
		assertEquals(1, new PaperFold().numFolds(paper, box));
	}
	
	@Test
	public void test1() {
		int[] paper = new int[] {11, 17};
		int[] box = new int[] {6, 4};
		assertEquals(4, new PaperFold().numFolds(paper, box));
	}
	
	@Test
	public void test2() {
		int[] paper = new int[] {11, 17};
		int[] box = new int[] {5, 4};
		assertEquals(4, new PaperFold().numFolds(paper, box));
	}
	
	@Test
	public void test3() {
		int[] paper = new int[] {1000,1000};
		int[] box = new int[] {62,63};
		assertEquals(-1, new PaperFold().numFolds(paper, box));
	}
	
	@Test
	public void test4() {
		int[] paper = new int[] {100,30};
		int[] box = new int[] {60,110};
		assertEquals(0, new PaperFold().numFolds(paper, box));
	}
	
	@Test
	public void test5() {
		int[] paper = new int[] {1895, 6416};
		int[] box = new int[] {401, 1000};
		assertEquals(5, new PaperFold().numFolds(paper, box));
	}
}
