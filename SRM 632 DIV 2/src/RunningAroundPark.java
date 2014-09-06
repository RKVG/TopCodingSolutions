public class RunningAroundPark {

    public int numberOfLap(int N, int[] d) {

        int previousTree = N;
        int numLaps = 0;

        for (int i = 0; i < d.length; i++) {

            // When we see a smaller (or equal) numbered tree, increment numLaps
            if (d[i] <= previousTree) {
                numLaps++;
            }

            previousTree = d[i];
        }

        return numLaps;
    }
}
