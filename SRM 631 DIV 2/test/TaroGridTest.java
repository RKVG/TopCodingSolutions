import org.junit.Test;
import static org.junit.Assert.*;

public class TaroGridTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] grid = new String[] {"W"};
		assertEquals(1, new TaroGrid().getNumber(grid));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] grid = new String[] {"WB",
 "BW"};
		assertEquals(1, new TaroGrid().getNumber(grid));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] grid = new String[] {"BWW",
 "BBB",
 "BWB"};
		assertEquals(3, new TaroGrid().getNumber(grid));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] grid = new String[] {"BWBW",
 "BBWB",
 "WWWB",
 "BWWW"};
		assertEquals(3, new TaroGrid().getNumber(grid));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] grid = new String[] {"BWB",
 "BBW",
 "BWB"};
		assertEquals(3, new TaroGrid().getNumber(grid));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] grid = new String[] {"BBWWBBWW",
 "BBWWBBWW",
 "WWBBWWBB",
 "WWBBWWBB",
 "BBWWBBWW",
 "BBWWBBWW",
 "WWBBWWBB",
 "WWBBWWBB"};
		assertEquals(2, new TaroGrid().getNumber(grid));
	}
}
