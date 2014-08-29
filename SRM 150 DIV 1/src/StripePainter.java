public class StripePainter {

    private static final char BLANK_COLOR = 'A' - 1;
    private static final int MAX_COLORS = 27;  // A-Z plus one for blank
    private static final String INDENT = "-";

    int[][][] alreadySeen;

    public int minStrokes(String stripes) {

        int length = stripes.length();
        alreadySeen = new int[length][length + 1][MAX_COLORS];
        return minStrokes(stripes, 0, length, BLANK_COLOR, "");
    }

    private int minStrokes(String stripes, int start, int size, char color,
                           String spacer) {

        if (spacer.length() == 1) {
            System.out.println(spacer + stripes + '\t' + "Start: " + start + '\t' +
                    "Size:" +
                    " " + size + '\t' + "Color: " + color);
        }

        if (size == 0) return 0;

        if (stripes.charAt(start) == color) {
            return minStrokes(stripes, start + 1, size - 1, color,
                    spacer + INDENT);

        } else {

            if (alreadySeen[start][size][color - BLANK_COLOR] > 0) {
                return alreadySeen[start][size][color - BLANK_COLOR];
            }

            int min = Integer.MAX_VALUE;

            for (int i = 1; i <= size; i++) {
                min = Math.min(min, 1 +
                        minStrokes(stripes, start + 1, i - 1,
                                stripes.charAt(start), spacer + INDENT) +
                        minStrokes(stripes, start + i, size - i, color,
                                spacer + INDENT));
            }

            alreadySeen[start][size][color - BLANK_COLOR] = min;
            return min;
        }
    }


}

