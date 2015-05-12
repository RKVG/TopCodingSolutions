import org.junit.Test;
import static org.junit.Assert.*;

public class FairWorkloadTest {
	
	@Test
	public void test0() {
		int[] folders = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int workers = 3;
		assertEquals(170, new FairWorkload().getMostWork(folders, workers));
	}
	
	@Test
	public void test1() {
		int[] folders = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 };
		int workers = 5;
		assertEquals(110, new FairWorkload().getMostWork(folders, workers));
	}
	
	@Test
	public void test2() {
		int[] folders = new int[] { 568, 712, 412, 231, 241, 393, 865, 287, 128, 457, 238, 98, 980, 23, 782 };
		int workers = 4;
		assertEquals(1785, new FairWorkload().getMostWork(folders, workers));
	}
	
	@Test
	public void test3() {
		int[] folders = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1000 };
		int workers = 2;
		assertEquals(1000, new FairWorkload().getMostWork(folders, workers));
	}
	
	@Test
	public void test4() {
		int[] folders = new int[] { 50, 50, 50, 50, 50, 50, 50 };
		int workers = 2;
		assertEquals(200, new FairWorkload().getMostWork(folders, workers));
	}
	
	@Test
	public void test5() {
		int[] folders = new int[] {1,1,1,1,100};
		int workers = 5;
		assertEquals(100, new FairWorkload().getMostWork(folders, workers));
	}
	
	@Test
	public void test6() {
		int[] folders = new int[] { 950, 650, 250, 250, 350, 100, 650, 150, 150, 700 };
		int workers = 6;
		assertEquals(950, new FairWorkload().getMostWork(folders, workers));
	}
}
