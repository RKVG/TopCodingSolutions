import org.junit.Test;
import static org.junit.Assert.*;

public class SwimmersTest {
	
	@Test(timeout=2000)
	public void test0() {
		int[] distances = new int[] { 300, 300, 300 };
		int[] speeds = new int[] { 1, 2, 3 };
		int current = 2;
		assertArrayEquals(new int[] { -1,  -1,  360 }, new Swimmers().getSwimTimes(distances, speeds, current));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] distances = new int[] { 500, 500 };
		int[] speeds = new int[] { 4, 5 };
		int current = 2;
		assertArrayEquals(new int[] { 333,  238 }, new Swimmers().getSwimTimes(distances, speeds, current));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] distances = new int[] { 0, 0 };
		int[] speeds = new int[] { 1, 2 };
		int current = 1;
		assertArrayEquals(new int[] { 0,  0 }, new Swimmers().getSwimTimes(distances, speeds, current));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] distances = new int[] { 0, 1 };
		int[] speeds = new int[] { 0, 0 };
		int current = 0;
		assertArrayEquals(new int[] { 0,  -1 }, new Swimmers().getSwimTimes(distances, speeds, current));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] distances = new int[] { 7507, 7517, 7523, 7529, 7537, 7541, 7547, 7549, 7559, 7561, 7573, 7577, 7583,
  7589, 7591, 7603, 7607, 7621, 7639, 7643, 7649, 7669, 7673, 7681, 7687, 7691,
  7699, 7703, 7717, 7723, 7727, 7741, 7753, 7757, 7759, 7789, 7793, 7817, 7823,
  7829, 7841, 7853, 7867, 7873, 7877, 7879, 7883, 7901, 7907, 7919 };
		int[] speeds = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
  73, 79, 83, 89, 97, 99, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30,
  32, 34, 36, 38, 40, 42, 44, 46, 48, 51 };
		int current = 6;
		assertArrayEquals(new int[] { -1,  -1,  -1,  8108,  1950,  1474,  1014,  882,  705,  544,  507,  420,  377,  359,  328,  290,  260,  252,  229,  216,  210,  195,  185,  173,  159,  155,  -1,  -1,  4409,  2413,  1717,  1354,  1127,  969,  852,  764,  692,  635,  585,  543,  507,  476,  449,  424,  402,  383,  365,  349,  334,  314 }, new Swimmers().getSwimTimes(distances, speeds, current));
	}
}
