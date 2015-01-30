import org.junit.Test;
import static org.junit.Assert.*;

public class WhatSortTest {
	
	@Test
	public void test0() {
		String[] name = new String[] {"BOB","BOB","DAVE","JOE"};
		int[] age = new int[] {22, 35, 35, 30};
		int[] wt = new int[]  {122, 122, 195,  200};
		assertEquals("IND", new WhatSort().sortType(name, age, wt));
	}
	
	@Test
	public void test1() {
		String[] name = new String[] {"BOB","BOB","DAVE","DAVE"};
		int[] age = new int[] {22, 35, 35, 30};
		int[] wt = new int[]  {122, 122, 195,  200};
		assertEquals("NOT", new WhatSort().sortType(name, age, wt));
	}
	
	@Test
	public void test2() {
		String[] name = new String[] {"BOB","BOB","DAVE","DAVE"};
		int[] age = new int[]  {22, 35, 35, 30};
		int[] wt = new int[] {122, 122, 195,  190};
		assertEquals("NWA", new WhatSort().sortType(name, age, wt));
	}
}
