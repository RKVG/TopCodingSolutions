/*
TopCoder
Single Round Match 147
Division 1
Level 3 - 1000 Points
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Flags {

    /*
    Checks to see if there is at least one color that allows two neighbors.
     */
    private static boolean isLinearGrowth(Map<Integer,
            Set<Integer>> contributes) {

        for (int color : contributes.keySet()) {
            if (contributes.get(color).size() > 1) {
                return false;
            }
        }

        return true;
    }

    public long numStripes(String numFlags, String[] forbidden) {

        int numColors = forbidden.length;

        long numFlagsNeeded = Long.parseLong(numFlags);

        /*
        Maps each ending stripe color with to a set of next stripe colors
         */
        Map<Integer, Set<Integer>> contributes = new HashMap<>();

        for (int color = 0; color < numColors; color++) {

            // Get the forbidden colors for this color and add them to a set.
            String[] forbiddenForColor = forbidden[color].split(" ");
            Set<Integer> forbiddenForColorSet = new HashSet<>();
            for (String s : forbiddenForColor) {
                forbiddenForColorSet.add(Integer.parseInt(s));
            }

            /*
            Create a set that contains all the allowed colors.  That is,
            the colors not in the forbidden colors set.
             */
            Set<Integer> availableForNextColor = new HashSet<>();
            for (int nextColor = 0; nextColor < numColors; nextColor++) {
                if (!forbiddenForColorSet.contains(nextColor)) {
                    availableForNextColor.add(nextColor);
                }
            }

            // Store the color index along with its allowed next colors.
            contributes.put(color, availableForNextColor);
        }

        /*
        Do we have at least one color that can have more than one neighbor.
        If not, then the number of flags grows linearly with the number of
        stripes and we'll do some division to figure out the anser.
         */
        if (isLinearGrowth(contributes)) {
            int divisor = 0;
            int subtract = 0;
            for (int color = 0; color < numColors; color++) {
                if (contributes.get(color).size() == 0) { subtract++; }
                if (contributes.get(color).size() == 1) { divisor++; }
            }
            if (divisor == 0) {
                return -1;  // Impossible to make number of flags.
            }
            return (numFlagsNeeded / divisor) - (subtract / 2); // ??
        }

        // A map to hold how many patterns end with each color.
        Map<Integer, Long> endsWithCount = new HashMap<>();

        // Start of with flags ending in each of the colors
        for (int i = 0; i < numColors; i++) {
            endsWithCount.put(i, 1L);
        }

        long numFlagsFound = numColors;
        long numStripes = 1;

        /*
        Loop until we have the number of flags needed.  With each iterations,
         we look at the last color, and how many neighboring colors it will
         contribute to the next round.
         */
        while (numFlagsFound < numFlagsNeeded) {
            numStripes++;

            /*
             Map holds the number of patterns that end with each color at the
             end of the round.  Starts each color at 0.
              */
            Map<Integer, Long> newEndsWithCount = new HashMap<>();
            for (int color = 0; color < numColors; color++) {
                newEndsWithCount.put(color, 0L);
            }

            /*
            For each color, look at how many neighbors it can have,
            then increments the number of flags ending with each neighboring
            color by the number of the current color elements.  For example,
            if the current round has 10 flags whose pattern ends with color
            0, and color 0 allows 1, 2, and 3; then in the next round,
            patterns ending in 1, 2, and 3 will appear 10 (more) times.
             */
            for (int color = 0; color < numColors; color++) {
                for (int nextColor : contributes.get(color)) {
                    long toAdd = endsWithCount.get(color);
                    newEndsWithCount.put(nextColor, toAdd + newEndsWithCount
                            .get(nextColor));
                    numFlagsFound += toAdd;

                    // Return as soon as possible.
                    if (numFlagsFound >= numFlagsNeeded) { return numStripes; }
                }
            }

            // Set current round to the next.
            endsWithCount = newEndsWithCount;
        }

        return numStripes;
    }
}
