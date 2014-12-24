import java.util.ArrayList;
import java.util.List;

public class Quilting {

    private static final int NO_COLOR = -1;

    // X and Y steps when moving up, left, down, and right
    private static final int[] spiralX = {0, -1, 0, 1};
    private static final int[] spiralY = {-1, 0, 1, 0};

    // Ensures that we move up after the first patch.
    private int direction = 3;

    // Each int is an index into colorList.
    private int[][] quilt;

    /*
    * Keeps track of how often a color was used.  The index matches
    * the index in colorList, and the value is the count.
    */
    private int[] colorUsageQuilt;

    /*
    * Method called by TopCoder
    */
    public String lastPatch(int length, int width, String[] colorList) {

        // Initialize the quilt.  All colors set to NO_COLOR
        quilt = new int[width][length];
        for (int x = 0; x < width; x++)  {
            for (int y = 0; y < length; y++)  {
                quilt[x][y] = NO_COLOR;
            }
        }

        colorUsageQuilt = new int[colorList.length];

        // Starting point, location of first patch.
        int x = width / 2;
        int y = length / 2;

        int lineLength = 0;

        // Change directions when lineLength reaches this.
        int lineLengthMax = 1;

        // Loop through all patches
        for (int i = 0; i < (width * length); i++)  {

            int color = getPatchColor(x, y);
            quilt[x][y] = color;
            colorUsageQuilt[color]++;

            lineLength++;

            if (lineLength == lineLengthMax)  {
                lineLength = 1;
                direction = (direction + 1) % 4;

                // Line length increases when starting up or down.
                if ((direction % 2) == 0)  {
                    lineLengthMax++;
                }
            }

            // Move to next patch position.
            x += spiralX[direction];
            y += spiralY[direction];
        }

        // Back up one to the last patch
        x -= spiralX[direction];
        y -= spiralY[direction];

        return colorList[quilt[x][y]];
    }

    private int getPatchColor(int x, int y)  {

        // Calculate least used neighboring color.
        List<Integer> leastNeighborColors = getLeastNeighborColors(x, y);
        if (leastNeighborColors.size() == 1)  {
            return leastNeighborColors.get(0);
        }

        // Of the least used neighboring colors, calculate least used overall.
        List<Integer> leastOverallColors =
                getLeastOverallColors(leastNeighborColors);
        if (leastOverallColors.size() == 1)  {
            return leastOverallColors.get(0);
        }

        // If still tied, return minimum value in list
        int min = Integer.MAX_VALUE;
        for (int i : leastOverallColors)  {
            min = Math.min(min, i);
        }
        return min;
    }

    private List<Integer> getLeastNeighborColors(int x, int y) {

        int[] colorCount = new int[colorUsageQuilt.length];

        // Loop through the 9x9 grid surrounding x,y and count the colors.
        for (int x1 = x-1; x1 <= x+1; x1++)  {
            for (int y1 = y-1; y1 <= y+1; y1++)  {

                // Ensure we're not out of bounds, and that a color is set.
                if ((x1 >= 0) && (x1 < quilt.length) &&
                        (y1 >= 0) && (y1 < quilt[0].length) &&
                        (quilt[x1][y1] != NO_COLOR))  {

                    // Increment the count for the color at this position.
                    colorCount[quilt[x1][y1]]++;
                }

            }
        }

        // Determine the smallest count.
        int leastCount = Integer.MAX_VALUE;

        for (int i = 0; i < colorCount.length; i++)  {
            leastCount = Math.min(leastCount, colorCount[i]);
        }

        // Add all colors that have the smallest count.
        List<Integer> leastUsedColors = new ArrayList<>();

        for (int i = 0; i < colorCount.length; i++)  {
            if (colorCount[i] == leastCount)  {
                leastUsedColors.add(i);
            }
        }

        return leastUsedColors;
    }

    private List<Integer> getLeastOverallColors(List<Integer> colors)  {

        // Determine the smallest count among all colors.
        int leastCount = Integer.MAX_VALUE;

        for (int color : colors)  {
            leastCount = Math.min(leastCount, colorUsageQuilt[color]);
        }

        // Add all colors that have that smallest count.
        List<Integer> leastUsedColors = new ArrayList<>();

        for (int color : colors)  {
            if (colorUsageQuilt[color] == leastCount)  {
                leastUsedColors.add(color);
            }
        }

        return leastUsedColors;
    }

}
