import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    @Test
    public void test0() {
        int[] sales = new int[]{5};
        int[] daysAvailable = new int[]{15};
        assertEquals(10, new Inventory().monthlyOrder(sales, daysAvailable));
    }

    @Test
    public void test1() {
        int[] sales = new int[]{75, 120, 0, 93};
        int[] daysAvailable = new int[]{24, 30, 0, 30};
        assertEquals(103, new Inventory().monthlyOrder(sales, daysAvailable));
    }

    @Test
    public void test2() {
        int[] sales = new int[]{8773};
        int[] daysAvailable = new int[]{16};
        assertEquals(16450, new Inventory().monthlyOrder(sales, daysAvailable));
    }

    @Test
    public void test3() {
        int[] sales = new int[]{1115, 7264, 3206, 6868, 7301};
        int[] daysAvailable = new int[]{1, 3, 9, 4, 18};
        assertEquals(36091, new Inventory().monthlyOrder(sales, daysAvailable));
    }
}
