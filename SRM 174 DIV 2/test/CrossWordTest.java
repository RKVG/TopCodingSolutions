import org.junit.Test;
import static org.junit.Assert.*;

public class CrossWordTest {
	
	@Test
	public void test0() {
		String[] board = new String[] {"X....X",
 "X.XX.X",
 "...X..",
 "X.XX.X",
 "..X..."};
		int size = 3;
		assertEquals(2, new CrossWord().countWords(board, size));
	}
	
	@Test
	public void test1() {
		String[] board = new String[] {"...X...",
 ".X...X.",
 "..X.X..",
 "X..X..X",
 "..X.X..",
 ".X...X.",
 "...X..."};
		int size = 3;
		assertEquals(6, new CrossWord().countWords(board, size));
	}
	
	@Test
	public void test2() {
		String[] board = new String[] {".....X....X....",
 ".....X....X....",
 "..........X....",
 "....X....X.....",
 "...X....X....XX",
 "XXX...X....X...",
 ".....X....X....",
 ".......X.......",
 "....X....X.....",
 "...X....X...XXX",
 "XX....X....X...",
 ".....X....X....",
 "....X..........",
 "....X....X.....",
 "....X....X....."}
;
		int size = 5;
		assertEquals(8, new CrossWord().countWords(board, size));
	}
	
	@Test
	public void test3() {
		String[] board = new String[] {"...",
 "...",
 "..."};
		int size = 50;
		assertEquals(0, new CrossWord().countWords(board, size));
	}
	
	@Test
	public void test4() {
		String[] board = new String[] {"....",
 "....",
 "...."};
		int size = 3;
		assertEquals(0, new CrossWord().countWords(board, size));
	}
}
