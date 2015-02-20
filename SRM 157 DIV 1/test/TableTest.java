import org.junit.Test;
import static org.junit.Assert.*;

public class TableTest {
	
	@Test
	public void test0() {
		String[] tbl = new String[] {"(1,1,A)(2,1,B)(1,1,C)(1,1,D)",
 "(1,1,E)(1,1,F)(1,1,G)(1,1,H)(1,1,I)",
 "(1,3,J)(1,1,K)(3,2,L)",
 "(1,1,M)",
 "(1,1,N)(1,1,O)(1,1,P)(1,1,Q)",
 "(1,1,R)(1,1,S)(1,1,T)(1,1,U)(1,1,V)"};
		assertArrayEquals(new String[] { "ABBCD",  "EFGHI",  "JKLLL",  "JMLLL",  "JNOPQ",  "RSTUV" }, new Table().layout(tbl));
	}
	
	@Test
	public void test1() {
		String[] tbl = new String[] {"(1,3,N)(3,2,E)(3,1,M)(1,1,Q)",
 "(1,1,T)(3,1,U)",
 "(1,1,Y)(4,5,A)(1,2,V)(1,2,W)",
 "(1,3,G)(1,3,Z)",
 "(1,2,S)(1,3,D)",
 "",
 "(1,2,P)(1,2,F)(1,3,J)",
 "(1,1,L)(3,3,K)(1,1,R)",
 "(3,2,B)(1,1,D)",
 "(2,1,A)",
 "(2,3,O)(4,1,X)(1,1,I)(1,1,B)",
 "(3,2,H)(3,2,C)",
 ""};
		assertArrayEquals(new String[] { "NEEEMMMQ",  "NEEETUUU",  "NYAAAAVW",  "GZAAAAVW",  "GZAAAASD",  "GZAAAASD",  "PFAAAAJD",  "PFLKKKJR",  "BBBKKKJD",  "BBBKKKAA",  "OOXXXXIB",  "OOHHHCCC",  "OOHHHCCC" }, new Table().layout(tbl));
	}
	
	@Test
	public void test2() {
		String[] tbl = new String[] {"(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
 "","","","","","","","",
 "(9,9,G)(9,9,H)(9,9,I)(9,9,J)(9,9,K)(5,9,L)",
 "","","","","","","","",
 "(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
 "","","","","","","","",
 "(9,9,G)(9,9,H)(9,9,I)(9,9,J)(9,9,K)(5,9,L)",
 "","","","","","","","",
 "(9,9,A)(9,9,B)(9,9,C)(9,9,D)(9,9,E)(5,9,F)",
 "","","","","","","","",
 "(9,5,G)(9,5,H)(9,5,I)(9,5,J)(9,5,K)(5,5,L)",
 "","","",""};
		assertArrayEquals(new String[] { "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "AAAAAAAAABBBBBBBBBCCCCCCCCCDDDDDDDDDEEEEEEEEEFFFFF",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL",  "GGGGGGGGGHHHHHHHHHIIIIIIIIIJJJJJJJJJKKKKKKKKKLLLLL" }, new Table().layout(tbl));
	}
}