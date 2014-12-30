public class Egalitarianism3Easy {

    /*
    * There's a maximum of 10 cities, and a maximum distance of 1,000.  So,
    * no city can be more than 10,000 away from another.
    */
    private static final int INF_DISTANCE = (10 * 1000) + 1;

    public int maxCities(int n, int[] a, int[] b, int[] len) {

        // A matrix to hold the distances between any 2 cities.
        int[][] distances = new int[n][n];

		/*
        * Initialize distances.  Distance from any city to itself is 0.
		* Set distance to all other cities to infinity.
		*/
        for (int i = 0; i < distances.length; i++) {
            for (int j = 0; j < distances[0].length; j++) {
                distances[i][j] = (i == j) ? 0 : INF_DISTANCE;
            }
        }

        // Set distances from the input parameters
        for (int i = 0; i < a.length; i++) {

            // Roads are bi-directional, so set both ways.
            distances[a[i] - 1][b[i] - 1] = len[i];
            distances[b[i] - 1][a[i] - 1] = len[i];
        }

        // Floyd-Warshall's algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = Math.min(distances[i][j],
                            distances[i][k] + distances[k][j]);
                }
            }
        }

        // distances is now populated with the distance between any 2 cities.

        /*
        * The maximum number of cities in a set where the distances between
        * them all are equal.  This is the value we'll return.
        */
        int max = 0;

        /*
        * This will generate a bit pattern representing every possible subset
        * of cities.
        */
        for (int citySetMask = 0; citySetMask < (1 << n); citySetMask++) {

            int citySetDistance = -1;
            boolean allDistancesEqual = true;
            int cityCount = 0;

            int city1 = 0;
            while ((city1 < n) & allDistancesEqual) {

                // Make sure city1 is in the set.
                if ((citySetMask & (1 << city1)) != 0) {

                    cityCount++;

                    int city2 = 0;
                    while ((city2 < n) & allDistancesEqual) {

                        // Make sure city2 is in the set (and != city1)
                        if ((city1 != city2) &&
                                ((citySetMask & (1 << city2)) != 0)) {

                            // Set the distances if this is the first pair.
                            if (citySetDistance == -1) {
                                citySetDistance = distances[city1][city2];
                            }

                            if (distances[city1][city2] != citySetDistance) {
                                allDistancesEqual = false;
                            }

                        }

                        city2++;
                    }
                }

                city1++;
            }

            if (allDistancesEqual) {
                max = Math.max(max, cityCount);
            }

        }

        return max;
    }
}
