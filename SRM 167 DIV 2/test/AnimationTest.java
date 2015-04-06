import org.junit.Test;
import static org.junit.Assert.*;

public class AnimationTest {
	
	@Test
	public void test0() {
		int speed = 2;
		String init =  "..R...." ;
		assertArrayEquals(new String[] { "..X....",  "....X..",  "......X",  "......." }, new Animation().animate(speed, init));
	}
	
	@Test
	public void test1() {
		int speed = 3;
		String init = "RR..LRL" ;
		assertArrayEquals(new String[] { "XX..XXX",  ".X.XX..",  "X.....X",  "......." }, new Animation().animate(speed, init));
	}
	
	@Test
	public void test2() {
		int speed = 2;
		String init = "LRLR.LRLR";
		assertArrayEquals(new String[] { "XXXX.XXXX",  "X..X.X..X",  ".X.X.X.X.",  ".X.....X.",  "........." }, new Animation().animate(speed, init));
	}
	
	@Test
	public void test3() {
		int speed = 10;
		String init = "RLRLRLRLRL";
		assertArrayEquals(new String[] { "XXXXXXXXXX",  ".........." }, new Animation().animate(speed, init));
	}
	
	@Test
	public void test4() {
		int speed = 1;
		String init = "...";
		assertArrayEquals(new String[] { "..." }, new Animation().animate(speed, init));
	}
	
	@Test
	public void test5() {
		int speed = 1;
		String init = "LRRL.LR.LRR.R.LRRL.";
		assertArrayEquals(new String[] { "XXXX.XX.XXX.X.XXXX.",  "..XXX..X..XX.X..XX.",  ".X.XX.X.X..XX.XX.XX",  "X.X.XX...X.XXXXX..X",  ".X..XXX...X..XX.X..",  "X..X..XX.X.XX.XX.X.",  "..X....XX..XX..XX.X",  ".X.....XXXX..X..XX.",  "X.....X..XX...X..XX",  ".....X..X.XX...X..X",  "....X..X...XX...X..",  "...X..X.....XX...X.",  "..X..X.......XX...X",  ".X..X.........XX...",  "X..X...........XX..",  "..X.............XX.",  ".X...............XX",  "X.................X",  "..................." }, new Animation().animate(speed, init));
	}
}
