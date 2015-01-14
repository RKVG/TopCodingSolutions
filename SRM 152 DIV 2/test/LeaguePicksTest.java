import org.junit.Test;
import static org.junit.Assert.*;

public class LeaguePicksTest {
	
	@Test(timeout=2000)
	public void test0() {
		int position = 3;
		int friends = 6;
		int picks = 15;
		assertArrayEquals(new int[] { 3,  10,  15 }, new LeaguePicks().returnPicks(position, friends, picks));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int position = 1;
		int friends = 1;
		int picks = 10;
		assertArrayEquals(new int[] { 1,  2,  3,  4,  5,  6,  7,  8,  9,  10 }, new LeaguePicks().returnPicks(position, friends, picks));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int position = 1;
		int friends = 2;
		int picks = 39;
		assertArrayEquals(new int[] { 1,  4,  5,  8,  9,  12,  13,  16,  17,  20,  21,  24,  25,  28,  29,  32,  33,  36,  37 }, new LeaguePicks().returnPicks(position, friends, picks));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int position = 5;
		int friends = 11;
		int picks = 100;
		assertArrayEquals(new int[] { 5,  18,  27,  40,  49,  62,  71,  84,  93 }, new LeaguePicks().returnPicks(position, friends, picks));
	}
}
