public class MutaliskEasy {

    private static final int[] ATTACKS = {9, 3, 1};
    private static final int MAX_HP = 60;
    
    int[][][] results = new int[MAX_HP + 1][MAX_HP + 1][MAX_HP + 1];

	public int minimalAttacks(int[] x) {

        // Nothing to do.
        if (x.length == 0) return 0;

        // Just divide by the maximum attack value.
        if (x.length == 1)  {
            if (x[0] % ATTACKS[0] == 0)  {
                return x[0] / ATTACKS[0];
            } else  {
                return x[0] / ATTACKS[0] + 1;
            }
        }

        /*
        * The problem does not fall into one of the easy cases,
        * so we'll have to do some work...
        */

        // Initialize results.
        for (int i = 0; i <= MAX_HP; i++)  {
            for (int j = 0; j <= MAX_HP; j++)  {
                for (int k = 0; k <= MAX_HP; k++)  {
                    results[i][j][k] = -1;
                }
            }
        }
        results[0][0][0] = 0;

        /*
        * We'll treat a length of 2 the same as if it had 3.  Just
        * give the 3rd element a value of 0.
        */
        if (x.length == 2) return minimalAttacks(x[0], x[1], 0);
        if (x.length == 3) return minimalAttacks(x[0], x[1], x[2]);

        return -1;  // Length of x must be >= 0 and <= 3

    }

    private int minimalAttacks(int x, int y, int z)  {

        // Don't allow values to go below 0.
        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (z < 0) z = 0;


        // If we've already calculated this result, just return it.
        if (results[x][y][z] >= 0) return results[x][y][z];

        int minAttacks = Integer.MAX_VALUE;

        // Try all possible combinations.
        for (int i = 0; i < ATTACKS.length; i++)  {

            for (int j = 0; j < ATTACKS.length; j++)  {
                if (j == i) continue;

                for (int k = 0; k < ATTACKS.length; k++)  {
                    if ((k == i) || (k == j))  continue;

                    minAttacks = Math.min(minAttacks,
                            minimalAttacks(
                                    x - ATTACKS[i],
                                    y - ATTACKS[j],
                                    z - ATTACKS[k]));
                }
            }
        }

        results[x][y][z] = minAttacks + 1;
        return minAttacks + 1;

    }

}
