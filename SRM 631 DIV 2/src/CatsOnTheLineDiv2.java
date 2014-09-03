import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class CatsOnTheLineDiv2 {

    public static String PASS = "Possible";
    public static String FAIL = "Impossible";

    /*
    * This class ties together a position with the number of cats at that
    * position.  It also implements Comparable so we can sort them.  After
    * sorting, we can go through the positions from left to right.
    */
    class Position implements Comparable<Position> {
        int position;
        int numCats;

        Position(int position, int numCats)  {
            this.position = position;
            this.numCats = numCats;
        }

        // Compare based on position.  There should be no duplicates.
        @Override
        public int compareTo(Position o) {
            if (this.position < o.position) return -1;
            if (this.position > o.position) return 1;
            return 0;
        }
    }

	public String getAnswer(int[] position, int[] count, int time) {

        List<Position> initialLine = new ArrayList<>();

        int numCats = 0;

        /*
        * For each element of the position and count arrays, create a new
        * Position object and adds it to initialLine.  Also counts the
        * total number of cats.
        */
        for (int i=0; i<position.length; i++)  {
            initialLine.add(new Position(position[i], count[i]));
            numCats += count[i];
        }

        Collections.sort(initialLine);

        // Calculate the size of the line after allowing that cats to move.
        int minPos = initialLine.get(0).position - time;
        int maxPos = initialLine.get(initialLine.size() - 1).position + time;
        int numPositions = maxPos - minPos + 1;

        // See if there are more cats than positions.  Maybe we can quit early.
        if (numCats > numPositions) return FAIL;

        /*
        * Holds the positions that have a cat after they've moved.  Note that
        * the array cannont have negative indexes, so we'll need to shift
        * the position over by minPos in order to map it.
        * Also, when done, each position can only have 1 cat (or zero), so we
        * can use an array of booleans instead of ints.
        */
        boolean[] newLine = new boolean[numPositions];

        /*
        * Loop through each Position (working left to right, since they were
        * sorted).  At each Position, loop through the number of cats.  For
        * each cat, try to find a final position for them.  If a position
        * cannot be found, then return FAIL.
        */
        for (Position p : initialLine)  {
            for (int i=0; i<p.numCats; i++)  {

                /*
                * Note (p.position - minPos).  This shifts all the values over
                * so they are zero-based.
                */
                if (!findPositionForCat(newLine, p.position - minPos, time))
                    return FAIL;
            }
        }

        // If we've found positions for all the cats, return PASS.
        return PASS;
	}

    /*
    * Attempts to find a position to place the cat.  Returns true if a position
    * can be found; otherwise false.
    * We'll move the cat to the furthest position left as possible given the
    * amount of time.  If that position is full (true), then keep looking to
    * the right.
    */
    private static boolean findPositionForCat(boolean[] line, int p, int time)  {

            for (int i = (p - time); i <= (p + time); i++) {
                if (!line[i]) {
                    line[i] = true;  // Mark the position is occupied.
                    return true;
                }
            }

        return false;
    }

}
