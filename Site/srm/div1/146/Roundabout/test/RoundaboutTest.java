import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoundaboutTest {

    @Test
    public void test0() {
        String north = "--";
        String east = "--";
        String south = "WE";
        String west = "-S";
        assertEquals(6, new Roundabout().clearUpTime(north, east, south,
                west));
    }

    @Test
    public void test1() {
        String north = "WWW";
        String east = "NNN";
        String south = "---";
        String west = "---";
        assertEquals(9, new Roundabout().clearUpTime(north, east, south,
                west));
    }

    @Test
    public void test2() {
        String north = "SSS";
        String east = "WW-";
        String south = "N";
        String west = "S------";
        assertEquals(13,
                new Roundabout().clearUpTime(north, east, south, west));
    }

    @Test
    public void test3() {
        String north = "SSS-";
        String east = "--W---W";
        String south = "WE";
        String west = "-S";
        assertEquals(14,
                new Roundabout().clearUpTime(north, east, south, west));
    }

    @Test
    public void test4() {
        String north = "E";
        String east = "-N";
        String south = "W";
        String west = "-S";
        assertEquals(5, new Roundabout().clearUpTime(north, east, south,
                west));
    }

    @Test
    public void test5() {
        String north = "";
        String east = "";
        String south = "";
        String west = "";
        assertEquals(0, new Roundabout().clearUpTime(north, east, south,
                west));
    }

    @Test
    public void test6() {
        String north = "W";
        String east = "";
        String south = "--E";
        String west = "";
        assertEquals(6, new Roundabout().clearUpTime(north, east, south,
                west));
    }

    @Test
    public void test7() {
        String north = "ES";
        String east = "N";
        String south = "E";
        String west = "";
        assertEquals(9, new Roundabout().clearUpTime(north, east, south,
                west));
    }

    @Test
    public void test8() {
        String north = "E";
        String east = "SN";
        String south = "-N";
        String west = "S-E";
        assertEquals(12,
                new Roundabout().clearUpTime(north, east, south, west));
    }

    @Test
    public void testA() {
        String north = "W";
        String east = "";
        String south = "";
        String west = "";
        assertEquals(3, new Roundabout().clearUpTime(north, east, south,
                west));
    }
}
