/*
TopCoder
Single Round Match: 146
Division: 2
Level: 3
Points: 1000
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1599
 */

import java.util.HashSet;
import java.util.Set;

public class BridgeCrossing {

    /*
    Use two hash sets to hold the people that are on
    the starting side (side1) and the finish (side2)
     */
    private final Set<Integer> side1 = new HashSet<>();

    private final Set<Integer> side2 = new HashSet<>();

    /*
    Move people from the "fromSide" set to the "toSide" set.
    numToSend - indicates the number of people moving across together.  It
    must be either 1 or 2.
    fastest - indicates whether we want the fastest people (true), or the
    slowest (false) to go across.
    Returns the amount of time it will take to move the people across.
     */
    private static int sendOver(int numToSend, boolean fastest,
                                Set<Integer> fromSide, Set<Integer> toSide) {

        int eTime = 0;
        int currentMax;

        // Loop either 1 or 2 times, depending on the number being asked to
        // send.
        for (int n = 0; n < numToSend; n++) {

            if (fastest) {
                currentMax = Integer.MAX_VALUE;
            } else {
                currentMax = 0;
            }

            /*
            If we're looking for the fastest person (fastest = true),
            then look for values that are below currentMax.
            If we're looking for the slowest person (fastest = false),
            then look for values that are above currentMax.
             */
            for (int i : fromSide) {
                if ((fastest && (i < currentMax)) ||
                        (!fastest && (i > currentMax))) {
                    currentMax = i;
                }
            }

            /*
            We've found either the fastest or slowest.  Remove them from the
            from side and add them to the to side.
            Set eTime to either eTime (if this is the first time through the
            loop) or the greater of eTime and currentMax if we've been
            through the loop before.  The effect is that eTime will contain the
            slower person's time.
             */
            fromSide.remove(currentMax);
            toSide.add(currentMax);
            eTime = Math.max(eTime, currentMax);
        }

        // Return the slower person's time.  (Just the time if numToSend = 1)
        return eTime;
    }

    public int minTime(int[] times) {

        int eTime = 0;  // Holds the elapsed time.  The return value.

        // Put all the people onto the starting side
        for (int time : times) {
            side1.add(time);
        }

        /*
        Send the two fastest from side1 to side2.
        Check to make sure there are more than 1 people on side 1.
        If there is only one person on side1, then just send that one.
        */
        eTime += sendOver((side1.size() >= 2) ? 2 : 1, true, side1, side2);

        // When side1 no longer has any people, we're done.
        while (side1.size() != 0) {

            // Send the fastest person back from side2 to side1
            eTime += sendOver(1, true, side2, side1);

            /*
            Send the two slowest people from side1 to side2.
            There must be at least two people, since we weren't done,
            and above we've just sent one more back.
             */
            eTime += sendOver(2, false, side1, side2);

            // Check again to see if we're done.
            if (side1.size() == 0) {
                return eTime;
            }

            // Send the fastest person back from side2 to side1
            eTime += sendOver(1, true, side2, side1);

            // Send the two fastest from side1 to side2.
            eTime += sendOver(2, true, side1, side2);
        }

        return eTime;
    }
}
