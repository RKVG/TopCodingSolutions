/*
TopCoder
Single Round Match: 146
Division: 2
Level: 1
Points: 250 Points
Description: http://community.topcoder.com/stat?c=problem_statement&amp;pm=1692
 */

import java.util.HashMap;
import java.util.Map;

public class YahtzeeScore {

    public int maxPoints(int[] toss) {

        // Holds die points, and the sum of those points.
        Map<Integer, Integer> score = new HashMap<>();

        // Loop through each toss.
        for (int d : toss) {
            Integer s = score.get(d);

            // Add or update total for that value.
            if (s == null) {
                score.put(d, d);
            } else {
                score.put(d, score.get(d) + d);
            }
        }

        // Find the largest score.
        int maxScore = 0;
        for (Integer s : score.values()) {
            if (s > maxScore) {
                maxScore = s;
            }
        }

        return maxScore;
    }
}
