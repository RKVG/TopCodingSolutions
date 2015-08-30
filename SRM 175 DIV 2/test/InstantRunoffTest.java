import org.junit.Test;
import static org.junit.Assert.*;

public class InstantRunoffTest {

	@Test
	public void test0() {
		String candidates = "ABC";
		String[] ballots = new String[] {"ACB", "BCA", "ACB", "BCA", "CBA"};
		assertEquals("B", new InstantRunoff().outcome(candidates, ballots));
	}

	@Test
	public void test1() {
		String candidates = "DCBA";
		String[] ballots = new String[] {"ACBD", "ACBD", "ACBD", "BCAD", "BCAD", "DBCA", "CBDA"};
		assertEquals("B", new InstantRunoff().outcome(candidates, ballots));
	}

	@Test
	public void test2() {
		String candidates = "ACB";
		String[] ballots = new String[] {"ACB", "BCA", "ACB", "BCA", "ACB", "BCA", "CBA", "CAB"};
		assertEquals("", new InstantRunoff().outcome(candidates, ballots));
	}

	@Test
	public void test3() {
		String candidates = "CAB";
		String[] ballots = new String[] {"ACB", "BCA", "ACB", "BCA", "ACB", "BCA", "CAB", "CAB"};
		assertEquals("A", new InstantRunoff().outcome(candidates, ballots));
	}

	@Test
	public void test4() {
		String candidates = "Z";
		String[] ballots = new String[] {"Z"};
		assertEquals("Z", new InstantRunoff().outcome(candidates, ballots));
	}

    @Test
    public void test23() {
        String candidates = "OUT";
        String[] ballots = new String[] {"TUO"};
        assertEquals("T", new InstantRunoff().outcome(candidates, ballots));
    }

}
