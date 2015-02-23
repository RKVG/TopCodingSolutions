import org.junit.Test;
import static org.junit.Assert.*;

public class ParallelSpeedupTest {
	
	@Test
	public void test0() {
		int k = 12;
		int overhead = 1;
		assertEquals(2, new ParallelSpeedup().numProcessors(k, overhead));
	}
	
	@Test
	public void test1() {
		int k = 50;
		int overhead = 3;
		assertEquals(3, new ParallelSpeedup().numProcessors(k, overhead));
	}
	
	@Test
	public void test2() {
		int k = 9;
		int overhead = 10;
		assertEquals(1, new ParallelSpeedup().numProcessors(k, overhead));
	}
	
	@Test
	public void test3() {
		int k = 3333;
		int overhead = 2;
		assertEquals(12, new ParallelSpeedup().numProcessors(k, overhead));
	}
	
	@Test
	public void test4() {
		int k = 1000000;
		int overhead = 4;
		assertEquals(63, new ParallelSpeedup().numProcessors(k, overhead));
	}
}
