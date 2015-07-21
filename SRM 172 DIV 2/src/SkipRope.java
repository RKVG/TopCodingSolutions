import java.util.Arrays;

public class SkipRope {

    public int[] partners(int[] candidates, int height) {

        int[] heights = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        for (int c : candidates) {
            if (isCloser(c, heights[0], height)) {

				/*
                * If closer that the closest, then bump the closest
				* into 2nd place, and set the candidate to be
				* the new closest.
				*/
                heights[1] = heights[0];
                heights[0] = c;

            } else if (isCloser(c, heights[1], height)) {

                // Set 2nd place to be the candidate.
                heights[1] = c;
            }
        }

        Arrays.sort(heights);

        return heights;
    }

    /*
    * Returns true if the candidate is closer in height than the current
    * person.  If the two are the same distance apart, then ties go
    * to the taller person.
    */
    private static boolean isCloser(int candidate, int current, int height) {

        int diffCandidate = Math.abs(height - candidate);
        int diffCurrent = Math.abs(height - current);

        if (diffCandidate < diffCurrent) return true;

        if (diffCandidate > diffCurrent) return false;

        // Ties go to the taller person.
        return candidate > current;

    }
}
