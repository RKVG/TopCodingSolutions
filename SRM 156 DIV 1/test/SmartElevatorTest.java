import org.junit.Test;
import static org.junit.Assert.*;

public class SmartElevatorTest {
	
	@Test
//			(timeout=2000)
	public void test0() {
		int[] arrivalTime = new int[] {5};
		int[] startingFloor = new int[] {30};
		int[] destinationFloor = new int[] {50};
		assertEquals(49, new SmartElevator().timeWaiting(arrivalTime, startingFloor, destinationFloor));
	}
	
	@Test(timeout=2000)
	public void test1() {
		int[] arrivalTime = new int[] {100};
		int[] startingFloor = new int[] {30};
		int[] destinationFloor = new int[] {50};
		assertEquals(120, new SmartElevator().timeWaiting(arrivalTime, startingFloor, destinationFloor));
	}
	
	@Test(timeout=2000)
	public void test2() {
		int[] arrivalTime = new int[] {10,120};
		int[] startingFloor = new int[] {1,100};
		int[] destinationFloor = new int[] {210,200};
		assertEquals(230, new SmartElevator().timeWaiting(arrivalTime, startingFloor, destinationFloor));
	}
	
	@Test(timeout=2000)
	public void test3() {
		int[] arrivalTime = new int[] {10,500};
		int[] startingFloor = new int[] {1,100};
		int[] destinationFloor = new int[] {210,200};
		assertEquals(600, new SmartElevator().timeWaiting(arrivalTime, startingFloor, destinationFloor));
	}
	
	@Test(timeout=2000)
	public void test4() {
		int[] arrivalTime = new int[] {1000,1200,1600,2000,2400};
		int[] startingFloor = new int[] {500,500,500,500,500};
		int[] destinationFloor = new int[] {700,300,700,300,700};
		assertEquals(2600, new SmartElevator().timeWaiting(arrivalTime, startingFloor, destinationFloor));
	}
	
	@Test(timeout=2000)
	public void test5() {
		int[] arrivalTime = new int[] {775397,261225,870141,287698,884334};
		int[] startingFloor = new int[] {82225,958610,998971,413596,21922};
		int[] destinationFloor = new int[] {769962,78706,477861,237168,258488};
		assertEquals(2724059, new SmartElevator().timeWaiting(arrivalTime, startingFloor, destinationFloor));
	}
}
