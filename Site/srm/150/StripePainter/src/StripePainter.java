public class StripePainter {

    private static final char BLANK_COLOR = 'A' - 1;
    private static final int MAX_COLORS = 27;  // A-Z plus one for blank

    /*
    * Holds all the combinations of starting position, string size, and color
    * that we've encountered before.  If they come up again, we can return
    * the stored value and avoid re-calculating.
    */
    int[][][] alreadySeen;

    public int minStrokes(String stripes) {

        int length = stripes.length();

        /*
        * Initialize the alreadySeen array.  The Java spec guarantees all
        * values will be set to zero.  No need to do it explicitly.
        */
        alreadySeen = new int[length][length + 1][MAX_COLORS];

        /*
        * Calculate minStrokes on the entire stripes String, starting with a
        * blank canvas.
        */
        return minStrokes(stripes, 0, length, BLANK_COLOR);
    }

    private int minStrokes(String stripes, int start, int size, char color) {

        // Breaks the recursive calls.
        if (size == 0) return 0;

        /*
        * If the left-most color matches the given color, then just move
        * on to the next stripe.
        */
        if (stripes.charAt(start) == color) {
            return minStrokes(stripes, start + 1, size - 1, color);
        }

        /*
        * If we've already calculated this combination of starting position,
        * string length, and colore; then just return that value.
        */
        if (alreadySeen[start][size][color - BLANK_COLOR] > 0) {
            return alreadySeen[start][size][color - BLANK_COLOR];
        }

        int min = Integer.MAX_VALUE;

        /*
        * Calculates the minimum number of strokes for all possible
        * combinations of sub-strings to the right of the current position.
        * In the first pass, the first call to minStrokes will be empty, and
        * the entire remainder of the string will be used in the second call
        * to minStrokes.  In each subsequent pass, a character is added to the
        * first call, and removed from the second call.
        */
        for (int i = 1; i <= size; i++) {
            min = Math.min(min, 1 +
                    minStrokes(stripes, start + 1, i - 1, stripes.charAt(start)) +
                    minStrokes(stripes, start + i, size - i, color));
        }

        // Store the calculate value to avoid having to calculate it again.
        alreadySeen[start][size][color - BLANK_COLOR] = min;

        return min;

    }
}

