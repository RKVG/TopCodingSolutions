import org.junit.Test;
import static org.junit.Assert.*;

public class CardCountTest {
	
	@Test(timeout=2000)
	public void test0() {
		int numPlayers = 6;
		String deck = "012345012345012345";
		assertArrayEquals(new String[] { "000",  "111",  "222",  "333",  "444",  "555" }, new CardCount().dealHands(numPlayers, deck));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int numPlayers = 4;
		String deck = "111122223333";
		assertArrayEquals(new String[] { "123",  "123",  "123",  "123" }, new CardCount().dealHands(numPlayers, deck));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int numPlayers = 1;
		String deck = "012345012345012345";
		assertArrayEquals(new String[] { "012345012345012345" }, new CardCount().dealHands(numPlayers, deck));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int numPlayers = 6;
		String deck = "01234";
		assertArrayEquals(new String[] { "",  "",  "",  "",  "",  "" }, new CardCount().dealHands(numPlayers, deck));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int numPlayers = 2;
		String deck = "";
		assertArrayEquals(new String[] { "",  "" }, new CardCount().dealHands(numPlayers, deck));
	}
}
