/*
TopCoder
Single Round Match: 627
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=13277
 */

import java.util.HashMap;
import java.util.Map;

public class ManySquares {

	public int howManySquares(int[] sticks) {

        /*
         * Holds a mapping between the lenght of a stick,
         * and the number of sticks found of that length.
         */
        Map<Integer, Integer> sticksOfLength = new HashMap<>();

        for (int i : sticks)  {

            /*
             * If a stick of this length has already been seen,
             * increment the count.  Otherwise initialize the count for this
             * size to 1.
             */
            if (sticksOfLength.containsKey(i))  {
                sticksOfLength.put(i, sticksOfLength.get(i) +  1);
            } else  {
                sticksOfLength.put(i,1);
            }

        }

        int count = 0;

        /*
         * For each length of stick in the map, divide it's count by 4 to get
         * the number of squares that can be made of that length.  Increase
         * the total count by that amount.
         */
        for (int i : sticksOfLength.keySet())  {
            count += sticksOfLength.get(i) / 4;  // Rounds down, no fractions.
        }

        return count;
	}
}
