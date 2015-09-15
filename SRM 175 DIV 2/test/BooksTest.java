import org.junit.Test;
import static org.junit.Assert.*;

public class BooksTest {
	
	@Test
	public void test0() {
		String[] titles = new String[] {"Algorithms", "Purely Functional Data Structures",
"Intro to C", "Automata and Computability"};
		assertEquals(2, new Books().sortMoves(titles));
	}
	
	@Test
	public void test1() {
		String[] titles = new String[] {"the fellowship of the ring",
"the return of the king",
"The two towers"};
		assertEquals(1, new Books().sortMoves(titles));
	}
	
	@Test
	public void test2() {
		String[] titles = new String[] {"Basic Engineering Circuit Analysis", "A Course in Combinatorics",
"Artificial Intelligence", "Asimovs Guide to Shakespeare",
"The Nature of Space and Time", "A Time for Trumpets",
"Essentials of Artificial Intelligence", "Life by the Numbers",
"Cognitive Psychology", "ColdFusion"};
		assertEquals(5, new Books().sortMoves(titles));
	}
	
	@Test
	public void test3() {
		String[] titles = new String[] {"A", "B", "A", "A", "B"};
		assertEquals(1, new Books().sortMoves(titles));
	}
	
	@Test
	public void test4() {
		String[] titles = new String[] {"This Book Has No Title", " This Book Does Have A Title"};
		assertEquals(1, new Books().sortMoves(titles));
	}
	
	@Test
	public void test5() {
		String[] titles = new String[] {"What Is The", "What Is The ", "What Is The Title Of This Book"};
		assertEquals(0, new Books().sortMoves(titles));
	}
}
