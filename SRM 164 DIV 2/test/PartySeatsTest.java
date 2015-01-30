import org.junit.Test;
import static org.junit.Assert.*;

public class PartySeatsTest {
	
	@Test
	public void test0() {
		String[] attendees = new String[] {"BOB boy","SAM girl","DAVE boy","JO girl"};
		assertArrayEquals(new String[] { "HOST",  "JO",  "BOB",  "HOSTESS",  "DAVE",  "SAM" }, new PartySeats().seating(attendees));
	}
	
	@Test
	public void test1() {
		String[] attendees = new String[] {"JOHN boy"};
		assertArrayEquals(new String[] { }, new PartySeats().seating(attendees));
	}
	
	@Test
	public void test2() {
		String[] attendees = new String[] {"JOHN boy","CARLA girl"};
		assertArrayEquals(new String[] { }, new PartySeats().seating(attendees));
	}
	
	@Test
	public void test3() {
		String[] attendees = new String[] {"BOB boy","SUZIE girl","DAVE boy","JO girl",
"AL boy","BOB boy","CARLA girl","DEBBIE girl"};
		assertArrayEquals(new String[] { "HOST",  "CARLA",  "AL",  "DEBBIE",  "BOB",  "HOSTESS",  "BOB",  "JO",  "DAVE",  "SUZIE" }, new PartySeats().seating(attendees));
	}
}
