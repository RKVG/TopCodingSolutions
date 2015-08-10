import org.junit.Test;
import static org.junit.Assert.*;

public class MineFieldTest {

	@Test
	public void test0() {
		String mineLocations = "(0,0)(1,0)(2,0)(3,0)(4,0)";
		assertArrayEquals(new String[] { "M20000000",  "M30000000",  "M30000000",  "M30000000",  "M20000000",  "110000000",  "000000000",  "000000000",  "000000000" }, new MineField().getMineField(mineLocations));
	}

	@Test
	public void test1() {
		String mineLocations = "(0,0)(0,8)(8,0)(8,8)";
		assertArrayEquals(new String[] { "M1000001M",  "110000011",  "000000000",  "000000000",  "000000000",  "000000000",  "000000000",  "110000011",  "M1000001M" }, new MineField().getMineField(mineLocations));
	}

	@Test
	public void test2() {
		String mineLocations = "(3,2)(3,3)(3,4)(4,2)(4,4)(5,2)(5,3)(5,4)(7,4)(6,7)";
		assertArrayEquals(new String[] { "000000000",  "000000000",  "012321000",  "02MMM2000",  "03M8M3000",  "02MMM2111",  "0124321M1",  "0001M1111",  "000111000" }, new MineField().getMineField(mineLocations));
	}

	@Test
	public void test3() {
		String mineLocations = "";
		assertArrayEquals(new String[] { "000000000",  "000000000",  "000000000",  "000000000",  "000000000",  "000000000",  "000000000",  "000000000",  "000000000" }, new MineField().getMineField(mineLocations));
	}
}
