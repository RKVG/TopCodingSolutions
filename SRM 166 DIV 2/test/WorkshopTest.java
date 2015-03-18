import org.junit.Test;
import static org.junit.Assert.*;

public class WorkshopTest {
	
	@Test
	public void test0() {
		int[] pieces = new int[] {1,2,3,4,5};
		assertEquals(3, new Workshop().pictureFrames(pieces));
	}
	
	@Test
	public void test1() {
		int[] pieces = new int[] {8,5,3};
		assertEquals(0, new Workshop().pictureFrames(pieces));
	}
	
	@Test
	public void test2() {
		int[] pieces = new int[] {4,23,76,22,87,3,1,99};
		assertEquals(7, new Workshop().pictureFrames(pieces));
	}
	
	@Test
	public void test3() {
		int[] pieces = new int[] {10000,9999,9998,9997,9996,1,2,3,4,5};
		assertEquals(43, new Workshop().pictureFrames(pieces));
	}
	
	@Test
	public void test4() {
		int[] pieces = new int[] {100};
		assertEquals(0, new Workshop().pictureFrames(pieces));
	}
}
