import org.junit.Test;
import static org.junit.Assert.*;

public class LevelUpTest {
	
	@Test
	public void test0() {
		int[] expNeeded = new int[] {150,450,900,1800};
		int received = 133;
		assertEquals(17, new LevelUp().toNextLevel(expNeeded, received));
	}
	
	@Test
	public void test1() {
		int[] expNeeded = new int[] {150,450,900,1800};
		int received = 312;
		assertEquals(138, new LevelUp().toNextLevel(expNeeded, received));
	}
	
	@Test
	public void test2() {
		int[] expNeeded = new int[] {150,450,900,1800};
		int received = 612;
		assertEquals(288, new LevelUp().toNextLevel(expNeeded, received));
	}
	
	@Test
	public void test3() {
		int[] expNeeded = new int[] {150,450,900,1800};
		int received = 450;
		assertEquals(450, new LevelUp().toNextLevel(expNeeded, received));
	}
}
