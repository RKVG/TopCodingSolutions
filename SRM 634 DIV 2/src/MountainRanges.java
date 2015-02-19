public class MountainRanges {

    public int countPeaks(int[] heights) {

        int peaks = 0;

        // If there are no elements, there can be no peaks.
        if (heights.length == 0)  return 0;

        /*
         * If there is just one element, it is bigger than it's (non-existent)
         * neighbors; and therefore a peak.
         */
        if (heights.length == 1) return 1;

        // Lengths must be at least 2 if we've reached this point.

        // Check left edge.
        if (heights[0] > heights[1]) peaks++;

        // Check right edge.
        if (heights[heights.length - 1] > heights[heights.length - 2]) peaks++;


        // Check everything in between
        for (int i = 1; i < heights.length - 1; i++) {
            if ((heights[i] > heights[i - 1]) && (heights[i] > heights[i + 1]))
                peaks++;
        }

        return peaks;
    }
}
