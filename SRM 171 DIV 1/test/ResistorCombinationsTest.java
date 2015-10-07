import org.junit.Test;
import static org.junit.Assert.*;

public class ResistorCombinationsTest {
	
	@Test
	public void test0() {
		String[] resistances = new String[] {"2","3","5"};
		double target = 2.5;
		assertEquals(2.5, new ResistorCombinations().closestValue(resistances, target), 1e-9);
	}
	
	@Test
	public void test1() {
		String[] resistances = new String[] {"2","3","5"};
		double target = 1;
		assertEquals(0.967741935483871, new ResistorCombinations().closestValue(resistances, target), 1e-9);
	}
	
	@Test
	public void test2() {
		String[] resistances = new String[] {"10.25","13.31","6.777","12.2"};
		double target = 10.5;
		assertEquals(10.510805181371511, new ResistorCombinations().closestValue(resistances, target), 1e-9);
	}
	
	@Test
	public void test3() {
		String[] resistances = new String[] {"10000","2000","300","40","5"};
		double target = 20000;
		assertEquals(12345.0, new ResistorCombinations().closestValue(resistances, target), 1e-9);
	}
	
	@Test
	public void test4() {
		String[] resistances = new String[] {"125.10000","00270.9","000625.55","90.100000","0015.60000"};
		double target = 153;
		assertEquals(152.75975812465552, new ResistorCombinations().closestValue(resistances, target), 1e-9);
	}
}
