import org.junit.Test;
import static org.junit.Assert.*;

public class BrickByBrickTest {
	
	@Test(timeout=2000)
	public void test0() {
		String[] map = new String[] { ".B",
  "BB" };
		assertEquals(6, new BrickByBrick().timeToClear(map));
	}
	
	@Test(timeout=2000)
	public void test1() {
		String[] map = new String[] { ".BB",
  "BBB",
  "BBB" };
		assertEquals(-1, new BrickByBrick().timeToClear(map));
	}
	
	@Test(timeout=2000)
	public void test2() {
		String[] map = new String[] { "......B",
  "###.###",
  "B.....B" };
		assertEquals(35, new BrickByBrick().timeToClear(map));
	}
	
	@Test(timeout=2000)
	public void test3() {
		String[] map = new String[] { "..BBB...",
  ".#BB..#.",
  "B.#B.B..",
  "B.B.....",
  "##.B.B#.",
  "#BB.#.B.",
  "B..B.BB.",
  "#..BB..B",
  ".B....#." };
		assertEquals(-1, new BrickByBrick().timeToClear(map));
	}
	
	@Test(timeout=2000)
	public void test4() {
		String[] map = new String[] { ".BB..BBB.B...",
  "B.B...B..BB..",
  "#B...B#B.....",
  "B#B.B##...##B",
  "BB.B#.B##B.B#",
  "B.B#.BBB.BB#B",
  "B#BBB##.#B#B.",
  "B#BB.BBB#BB.#" };
		assertEquals(3912, new BrickByBrick().timeToClear(map));
	}
	
	@Test(timeout=2000)
	public void test5() {
		String[] map = new String[] { ".BBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB",
  "B##############",
  "BBBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB",
  "B##############",
  "BBBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB",
  "B##############",
  "BBBBBBBBBBBBBBB",
  "##############B",
  "BBBBBBBBBBBBBBB" };
		assertEquals(31753, new BrickByBrick().timeToClear(map));
	}
}
