import org.junit.Test;
import static org.junit.Assert.*;

public class ProgressBarTest {
	
	@Test
	public void test0() {
		int[] taskTimes = new int[] {19,6,23,17};
		int tasksCompleted = 3;
		assertEquals("##############......", new ProgressBar().showProgress(taskTimes, tasksCompleted));
	}
	
	@Test
	public void test1() {
		int[] taskTimes = new int[] {2,3,7,1,4,3};
		int tasksCompleted = 4;
		assertEquals("#############.......", new ProgressBar().showProgress(taskTimes, tasksCompleted));
	}
	
	@Test
	public void test2() {
		int[] taskTimes = new int[] {553,846,816,203,101,120,161,818,315,772};
		int tasksCompleted = 4;
		assertEquals("##########..........", new ProgressBar().showProgress(taskTimes, tasksCompleted));
	}
	
	@Test
	public void test3() {
		int[] taskTimes = new int[] {7,60,468,489,707,499,350,998,1000,716,457,104,597,583,396,862};
		int tasksCompleted = 2;
		assertEquals("....................", new ProgressBar().showProgress(taskTimes, tasksCompleted));
	}
	
	@Test
	public void test4() {
		int[] taskTimes = new int[] {419,337,853,513,632,861,336,594,94,367,336,297,966,627,399,433,846,859,80,2};
		int tasksCompleted = 19;
		assertEquals("###################.", new ProgressBar().showProgress(taskTimes, tasksCompleted));
	}
}
