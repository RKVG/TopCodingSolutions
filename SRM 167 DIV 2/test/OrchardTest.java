import org.junit.Test;
import static org.junit.Assert.*;

public class OrchardTest {

	@Test
	public void test0() {
		String[] orchard = new String[] { "----" , "T---" , "----" , "----" };
		assertArrayEquals(new int[] { 2,  3 }, new Orchard().nextTree(orchard));
	}


	@Test
	public void test1() {
		String[] orchard = new String[] {"---T--","------","------","----T-","------","------"};
		assertArrayEquals(new int[] { 3,  3 }, new Orchard().nextTree(orchard));
	}


	@Test
	public void test2() {
		String[] orchard = new String[] {"------------","------------","------------","------------",
"------------","------------","------------","------------",
"------------","------------","------------","------------"};
		assertArrayEquals(new int[] { 6,  6 }, new Orchard().nextTree(orchard));
	}


	@Test
	public void test3() {
		String[] orchard = new String[] {"-T----T",
 "T---T--",
 "-----TT",
 "---TT--",
 "T-----T",
 "-------",
 "T-T--T-"};
		assertArrayEquals(new int[] { 2,  3 }, new Orchard().nextTree(orchard));
	}

    @Test
    public void test8()  {
        String[] orchard = new String[] {
                "-----T-T",
                "--T---T-",
                "T-T----T",
                "--------",
                "--------",
                "---T----",
                "--------",
                "--------"};
        assertArrayEquals(new int[] { 4,  5 }, new Orchard().nextTree(orchard));

    }
}
