import org.junit.Test;
import static org.junit.Assert.*;

public class CubismTest {
	
	@Test
	public void test0() {
		String[] lattice = new String[] {"BBBBBWWWBWWWBWWW",
 "BWWWWWWWWWWWWWWW",
 "BWWWWWWWWWWWWWWW",
 "BWWWWWWWWWWWWWWW"};
		String color = "black";
		assertEquals(3, new Cubism().lines(lattice, color));
	}
	
	@Test
	public void test1() {
		String[] lattice = new String[] {"BWWWWWWWWWWWWWWW",
 "WWWWWBWWWWWWWWWW",
 "WWWWWWWWWWBWWWWW",
 "WWWWWWWWWWWWWWWB"};
		String color = "black";
		assertEquals(1, new Cubism().lines(lattice, color));
	}
	
	@Test
	public void test2() {
		String[] lattice = new String[] {"WWWWWWWWWWWWWWWW",
 "WWWWWWWWWWWWWWWW",
 "WWWWWWWWWWWWWWWW",
 "WWWWWWWWWWWWWWWW"};
		String color = "black";
		assertEquals(0, new Cubism().lines(lattice, color));
	}
	
	@Test
	public void test3() {
		String[] lattice = new String[] {"WWWWWWWWWWWWWWWW",
 "WWWWWWWWWWWWWWWW",
 "WWWWWWWWWWWWWWWW",
 "WWWWWWWWWWWWWWWW"};
		String color = "white";
		assertEquals(76, new Cubism().lines(lattice, color));
	}
	
	@Test
	public void test4() {
		String[] lattice = new String[] {"WWWWWWWWWBWWWWWW",
 "WWWBWWWWWWWWWWWW",
 "WWWWWWWWWWWWBWWW",
 "WWWBWWWWWWWWWWWW"};
		String color = "white";
		assertEquals(58, new Cubism().lines(lattice, color));
	}
	
	@Test
	public void test5() {
		String[] lattice = new String[] {"BWBWBWBWBWBWBWBW","BWBWBWBWBWBWBWBW",
 "BWBWBWBWBWBWBWBW","BWBWBWBWBWBWBWBW"};
		String color = "white";
		assertEquals(20, new Cubism().lines(lattice, color));
	}
}
