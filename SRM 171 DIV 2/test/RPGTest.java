import org.junit.Test;
import static org.junit.Assert.*;

public class RPGTest {
	
	@Test
	public void test0() {
		String[] dice = new String[] {"3d6"};
		assertArrayEquals(new int[] { 3,  18,  10 }, new RPG().dieRolls(dice));
	}
	
	@Test
	public void test1() {
		String[] dice = new String[] {"3d4","1d6"};
		assertArrayEquals(new int[] { 4,  18,  11 }, new RPG().dieRolls(dice));
	}
	
	@Test
	public void test2() {
		String[] dice = new String[] {"6d5","10d10","10d20"};
		assertArrayEquals(new int[] { 26,  330,  178 }, new RPG().dieRolls(dice));
	}
	
	@Test
	public void test3() {
		String[] dice = new String[] {"1d2","2d2","4d2","6d2","8d2"};
		assertArrayEquals(new int[] { 21,  42,  31 }, new RPG().dieRolls(dice));
	}
}
