import org.junit.Test;
import static org.junit.Assert.*;

public class PoetryTest {
	
	@Test
	public void test0() {
		String[] poem = new String[] {"I hope this problem",
 "is a whole lot better than",
 "this stupid haiku"};
		assertEquals("abc", new Poetry().rhymeScheme(poem));
	}
	
	@Test
	public void test1() {
		String[] poem = new String[] {"     ",
 "Measure your height",
 "AND WEIGHT      ",
 "said the doctor",
 "",
 "And make sure to take your pills",
 "   to   cure   your    ills",
 "Every",
 "DAY"};
		assertEquals(" aab ccde", new Poetry().rhymeScheme(poem));
	}
	
	@Test
	public void test2() {
		String[] poem = new String[] {"One bright day in the middle of the night",
 "Two dead boys got up to fight",
 "Back to back they faced each other",
 "Drew their swords and shot each other",
 "",
 "A deaf policeman heard the noise",
 "And came to arrest the two dead boys",
 "And if you dont believe this lie is true",
 "Ask the blind man he saw it too"};
		assertEquals("aabb cdef", new Poetry().rhymeScheme(poem));
	}
	
	@Test
	public void test3() {
		String[] poem = new String[] {"",
 "",
 "",
 ""};
		assertEquals("    ", new Poetry().rhymeScheme(poem));
	}
	
	@Test
	public void test4() {
		String[] poem = new String[] {"This poem has uppercase letters",
 "In its rhyme scheme",
 "Alpha", "Blaster", "Cat", "Desert", "Elephant", "Frog", "Gulch", 
 "Horse", "Ireland", "Jam", "Krispy Kreme", "Loofah", "Moo", "Narf",
 "Old", "Pink", "Quash", "Rainbow", "Star", "Tour", "Uvula", "Very",
 "Will", "Xmas", "Young", "Zed", "deception", "comic", "grout",
 "oval", "cable", "rob", "steal", "steel", "weak"};
		assertEquals("abcdefghibjkblmnopqrstcuvwxyzABCbDEFG", new Poetry().rhymeScheme(poem));
	}
	
	@Test
	public void test5() {
		String[] poem = new String[] {" ",
 "     ",
 "This poem",
 "         ",
 " ",
 " ",
 "",
 "Has lots of blank lines",
 " ",
 "      ",
 "                                            ",
 "         ",
 " ",
 "              ",
 "                                                  ",
 "  in      it           "};
		assertEquals("  a    b       c", new Poetry().rhymeScheme(poem));
	}
	
	@Test
	public void test6() {
		String[] poem = new String[] {"too bad   your",
 "     solution went   sour"};
		assertEquals("aa", new Poetry().rhymeScheme(poem));
	}
}
