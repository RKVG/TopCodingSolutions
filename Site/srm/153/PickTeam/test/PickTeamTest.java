import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PickTeamTest {

    @Test
    public void test0() {

        int teamSize = 3;
        String[] people = new String[]{"ALICE 0 1 -1 3",
                "BOB 1 0 2 -4",
                "CAROL -1 2 0 2",
                "DAVID 3 -4 2 0"};
        assertArrayEquals(new String[]{"ALICE", "CAROL", "DAVID"},
                new PickTeam().pickPeople(teamSize, people));
    }

    @Test
    public void test1() {

        int teamSize = 2;
        String[] people = new String[]{"ALICE 0 1 -1 3",
                "BOB 1 0 2 -4",
                "CAROL -1 2 0 2",
                "DAVID 3 -4 2 0"};
        assertArrayEquals(new String[]{"ALICE", "DAVID"},
                new PickTeam().pickPeople(teamSize, people));
    }

    @Test
    public void test2() {

        int teamSize = 2;
        String[] people = new String[]{"A 0 -2 -2", "B -2 0 -1", "C -2 -1 0"};
        assertArrayEquals(new String[]{"B", "C"},
                new PickTeam().pickPeople(teamSize, people));
    }

    @Test
    public void test3() {

        int teamSize = 13;
        String[] people =
                new String[]{"A 0 2 8 7 1 -4 -3 1 8 2 8 2 1 -3 7 1 3 9 -6 -5",
                        "A 2 0 0 7 -7 -5 8 -8 -9 -9 6 -9 -4 -8 8 1 7 0 3 3",
                        "A 8 0 0 -5 -5 -7 1 -3 1 9 -6 6 1 5 6 -9 8 6 -8 -8",
                        "A 7 7 -5 0 7 -5 3 9 8 3 -6 -5 -5 2 -6 2 -2 -1 -2 8",
                        "B 1 -7 -5 7 0 7 -2 -9 3 7 0 -2 1 1 -9 -3 -2 2 1 -2",
                        "B -4 -5 -7 -5 7 0 4 8 6 0 -1 4 1 -2 -9 4 0 -7 6 -2",
                        "B -3 8 1 3 -2 4 0 8 -1 1 -2 -7 5 0 -6 9 0 -3 1 3",
                        "B 1 -8 -3 9 -9 8 8 0 0 -2 5 0 5 8 3 5 2 4 5 4",
                        "C 8 -9 1 8 3 6 -1 0 0 8 -3 8 -6 -4 7 -4 1 -5 5 4",
                        "C 2 -9 9 3 7 0 1 -2 8 0 -9 -6 6 5 -8 -3 -8 2 2 4",
                        "C 8 6 -6 -6 0 -1 -2 5 -3 -9 0 2 7 8 2 -6 -4 -6 4 4",
                        "C 2 -9 6 -5 -2 4 -7 0 8 -6 2 0 0 -3 6 7 -1 2 -4 -2",
                        "D 1 -4 1 -5 1 1 5 5 -6 6 7 0 0 -7 -4 8 -6 -3 4 -6",
                        "D -3 -8 5 2 1 -2 0 8 -4 5 8 -3 -7 0 7 -3 5 -8 5 1",
                        "D 7 8 6 -6 -9 -9 -6 3 7 -8 2 6 -4 7 0 9 -5 -5 -8 3",
                        "D 1 1 -9 2 -3 4 9 5 -4 -3 -6 7 8 -3 9 0 -2 -7 8 -7",
                        "E 3 7 8 -2 -2 0 0 2 1 -8 -4 -1 -6 5 -5 -2 0 6 0 5",
                        "E 9 0 6 -1 2 -7 -3 4 -5 2 -6 2 -3 -8 -5 -7 6 0 4 8",
                        "E -6 3 -8 -2 1 6 1 5 5 2 4 -4 4 5 -8 8 0 4 0 1",
                        "E -5 3 -8 8 -2 -2 3 4 4 4 4 -2 -6 1 3 -7 5 8 1 0"};
        assertArrayEquals(
                new String[]{"A", "A", "B", "B", "B", "B", "C", "C", "C", "D",
                        "D", "D", "E"},
                new PickTeam().pickPeople(teamSize, people)
        );
    }

    @Test
    public void test30() {

        int teamSize = 10;

        String[] people = new String[]
                {"EBBN 0 0 9 2 -7 8 7 5 10 9 13 5 10 7 " +
                        "1 16 12 0 0 0",
                        "O 0 0 6 7 -1 7 9 14 10 -8 5 3 6 -5 15 6 4 3 3 10",
                        "QWGA 9 6 0 1 7 10 3 -2 2 -3 6 4 10 16 2 3 14 5 8 9",
                        "WWXQ 2 7 1 0 14 -8 7 -3 1 0 2 4 0 15 7 6 7 -5 0 6",
                        "R -7 -1 7 14 0 8 0 -8 -5 13 9 4 1 9 10 -4 1 -1 3 0",
                        "AZ 8 7 10 -8 8 0 3 1 18 0 3 -1 1 15 4 -4 2 1 6 2",
                        "OJPIMN 7 9 3 7 0 3 0 4 14 9 1 -1 2 7 9 -1 12 5 7 3",
                        "KU 5 14 -2 -3 -8 1 4 0 6 -4 16 13 2 7 8 11 9 0 3 2",
                        "EY 10 10 2 1 -5 18 14 6 0 9 7 8 6 0 6 -2 0 -1 -1 1",
                        "MI 9 -8 -3 0 13 0 9 -4 9 0 7 6 7 -1 5 -8 -5 5 -6 8",
                        "JGJX 13 5 6 2 9 3 1 16 7 7 0 6 -2 0 8 3 4 6 -1 0",
                        "GA 5 3 4 4 4 -1 -1 13 8 6 6 0 11 2 -4 1 6 14 -9 -3",
                        "AF 10 6 10 0 1 1 2 2 6 7 -2 11 0 10 5 1 3 6 11 11",
                        "E 7 -5 16 15 9 15 7 7 0 -1 0 2 10 0 5 7 4 0 2 6",
                        "YYC 1 15 2 7 10 4 9 8 6 5 8 -4 5 5 0 -6 3 3 11 7",
                        "LN 16 6 3 6 -4 -4 -1 11 -2 -8 3 1 1 7 -6 0 2 8 0 9",
                        "S 12 4 14 7 1 2 12 9 0 -5 4 6 3 4 3 2 0 4 7 4",
                        "ZWFU 0 3 5 -5 -1 1 5 0 -1 5 6 14 6 0 3 8 4 0 2 0",
                        "EJ 0 3 8 0 3 6 7 3 -1 -6 -1 -9 11 2 11 0 7 2 0 1",
                        "RRMXVDE 0 10 9 6 0 2 3 2 1 8 0 -3 11 6 7 9 4 0 1 0"};

        String[] expected = new String[]{"AZ", "EBBN", "EY", "JGJX", "KU",
                "O", "OJPIMN", "QWGA", "S", "YYC"};

        assertArrayEquals(expected, new PickTeam().pickPeople(teamSize,
                people));
    }
}
