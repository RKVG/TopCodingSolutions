public class RecurrenceRelation {
	
	public int moduloTen(int[] coefficients, int[] initial, int N) {

        int K = coefficients.length;

        /*
        * Stores the solution to the previous K problems.
        */
		int[] X = new int[K];

        /*
        * Initialize X to contain the values given
        * in initial.  We need to mod these first.
        */
        for (int i = 0; i < X.length; i++)  {
            X[i] = myMod(initial[i], 10);
        }

        // If we already have the answer, just return it.
        if (N < K)  return X[N];

        int n = K;

        while (n <= N)  {

            /*
            * Add up the previous K solutions.
            */
            int sum = 0;

            for (int k = 0; k < K; k++)  {
                sum += coefficients[k] * X[k];
            }

            sum = myMod(sum, 10);

            /*
            * We have our answer, so shuffle everything down to
            * make room for it - dropping the oldes solution off
            * since we won't need it any more.
            */

            for (int i = 0; i < (K - 1); i++)  {
                X[i] = X[i + 1];
            }

            // Insert the current solution into the end of the array.
            X[K - 1] = sum;

            // Start working on the next solution.
            n++;
        }

        // Return the most recently solved.
        return X[K - 1];
   }

    /*
    * This handles mod'ing negative numbers, and is taken
    * straight out of the problem definition.
    */
    private static int myMod(int i, int m)  {

        if (i >= 0) return i % m;

        return ((m - ((-1 * i) % m)) % m);
    }
}
