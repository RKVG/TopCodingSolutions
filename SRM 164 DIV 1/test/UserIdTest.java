import org.junit.Test;
import static org.junit.Assert.*;

public class UserIdTest {
	
	@Test
	public void test0() {
		String[] inUse = new String[] {"bjones","bjones03","bmjones","old34id"};
		String first = "Bob";
		String middle = "";
		String last = "Jones";
		assertEquals("bjones01", new UserId().id(inUse, first, middle, last));
	}
	
	@Test
	public void test1() {
		String[] inUse = new String[] {"bjones","bjones03","bmjones","old34id"}
;
		String first =  "Bob Mack";
		String middle = "Hertobise";
		String last = "Jone's" ;
		assertEquals("bhjones", new UserId().id(inUse, first, middle, last));
	}
	
	@Test
	public void test2() {
		String[] inUse = new String[] {"bjonesto","bjones01","bjonesto","old34id"}
;
		String first = "BoB-Mack";
		String middle = "Mo";
		String last = "Jonestone" ;
		assertEquals("BAD DATA", new UserId().id(inUse, first, middle, last));
	}
	
	@Test
	public void test3() {
		String[] inUse = new String[] {"momorris","mmmm","momorr01"};
		String first = "'m m";
		String middle = "";
		String last = "O'Morrisy";
		assertEquals("momorr02", new UserId().id(inUse, first, middle, last));
	}
	
	@Test
	public void test4() {
		String[] inUse = new String[] {};
		String first = "'m m";
		String middle = "J.J";
		String last = "O'Morrisy";
		assertEquals("BAD DATA", new UserId().id(inUse, first, middle, last));
	}
}
