import org.junit.Test;
import static org.junit.Assert.*;

public class SkipRopeTest {
	
	@Test
	public void test0() {
		int[] candidates = new int[] {102, 99, 104};
		int height = 100;
		assertArrayEquals(new int[] { 99,  102 }, new SkipRope().partners(candidates, height));
	}
	
	@Test
	public void test1() {
		int[] candidates = new int[] {102, 97, 104};
		int height = 100;
		assertArrayEquals(new int[] { 97,  102 }, new SkipRope().partners(candidates, height));
	}
	
	@Test
	public void test2() {
		int[] candidates = new int[] {101, 100, 99};
		int height = 100;
		assertArrayEquals(new int[] { 100,  101 }, new SkipRope().partners(candidates, height));
	}
	
	@Test
	public void test3() {
		int[] candidates = new int[] {75, 117, 170, 175, 168, 167, 167, 142, 170, 85, 89, 170};
		int height = 169;
		assertArrayEquals(new int[] { 170,  170 }, new SkipRope().partners(candidates, height));
	}
	
	@Test
	public void test4() {
		int[] candidates = new int[] {134, 79, 164, 86, 131, 78, 99, 150, 105, 163, 150, 110, 90, 137, 127, 130, 121, 
 93, 97, 131, 170, 137, 171, 153, 137, 138, 92, 103, 149, 110, 156};
		int height = 82;
		assertArrayEquals(new int[] { 79,  86 }, new SkipRope().partners(candidates, height));
	}
}
