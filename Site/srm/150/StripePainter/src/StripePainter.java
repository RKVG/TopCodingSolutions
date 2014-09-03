01: public class StripePainter {
02: 
03:     private static final char BLANK_COLOR = 'A' - 1;
04:     private static final int MAX_COLORS = 27;  // A-Z plus one for blank
05: 
06:     /*
07:     * Holds all the combinations of starting position, string size, and color
08:     * that we've encountered before.  If they come up again, we can return
09:     * the stored value and avoid re-calculating.
10:     */
11:     int[][][] alreadySeen;
12: 
13:     public int minStrokes(String stripes) {
14: 
15:         int length = stripes.length();
16: 
17:         /*
18:         * Initialize the alreadySeen array.  The Java spec guarantees all
19:         * values will be set to zero.  No need to do it explicitly.
20:         */
21:         alreadySeen = new int[length][length + 1][MAX_COLORS];
22: 
23:         /*
24:         * Calculate calculateMinStrokes on the entire stripes String, starting
25:         * with a blank canvas.
26:         */
27:         return calculateMinStrokes(stripes, 0, length, BLANK_COLOR);
28:     }
29: 
30:     private int calculateMinStrokes(String stripes, int start, int size,
31:                                     char color) {
32: 
33:         // Breaks the recursive calls.
34:         if (size == 0) return 0;
35: 
36:         /*
37:         * If the left-most color matches the given color, then just move
38:         * on to the next stripe.
39:         */
40:         if (stripes.charAt(start) == color) {
41:             return calculateMinStrokes(stripes, start + 1, size - 1, color);
42:         }
43: 
44:         /*
45:         * If we've already calculated this combination of starting position,
46:         * string length, and colore; then just return that value.
47:         */
48:         if (alreadySeen[start][size][color - BLANK_COLOR] > 0) {
49:             return alreadySeen[start][size][color - BLANK_COLOR];
50:         }
51: 
52:         int min = Integer.MAX_VALUE;
53: 
54:         /*
55:         * Calculates the minimum number of strokes for all possible
56:         * combinations of sub-strings to the right of the current position.
57:         * In the first pass, the first call to calculateMinStrokes will be
58:         * empty, and the entire remainder of the string will be used in the
59:         * second call to calculateMinStrokes.  In each subsequent pass, a
60:         * character is added to the first call, and removed from the second
61:         * call.
62:         */
63:         for (int i = 1; i <= size; i++) {
64:             min = Math.min(min, 1 +
65:                     calculateMinStrokes(stripes, start + 1, i - 1, stripes.charAt(start)) +
66:                     calculateMinStrokes(stripes, start + i, size - i, color));
67:         }
68: 
69:         // Store the calculate value to avoid having to calculate it again.
70:         alreadySeen[start][size][color - BLANK_COLOR] = min;
71: 
72:         return min;
73: 
74:     }
75: }
