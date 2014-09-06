public class PotentialGeometricSequence {

    public int numberOfSubsequences(int[] d)  {

        int count = 0;

        /*
        * j bounces back and forth between i and d.length as i
        * moves from 0 to d.length.
        * This gives us every possible contiguous subsequence.
        */
        for (int i = 0; i < d.length; i++)  {
            for (int j = i; j < d.length; j++)  {
                if (checkSequence(i, j, d))  {
                    count++;
                }
            }
        }

        return count;
    }

    /*
    * Checks to see if the values in d[] decrease by the same amount
    * for each step from j down to i.  If so, return true; otherwise false.
    * For example, if the values in d[] are {3,4,5} it will return true
    * because we decrease by 1 to go from 5 to 4, and then by 1 again to
    * go from 4 to 3.
    */
    private static boolean checkSequence(int i, int j, int[] d)  {

        /*
        * If there are 0 or 1 steps between i and j, then it must be true
        */
        if ((j - i) <= 1) return true;

        /*
        * Get the difference between the two right-most values.  Each step
        * from here on must differ by this same amount.
        */
        int diff = d[i + 1] - d[i];

        /*
        * Work right to left from j down to i.  Ensure that each step
        * differs by diff
        */
        for (int x = i; x < j; x++)  {
            if ((d[x] + diff) != (d[x+1]))  {
                return false;
            }
        }

        return true;
    }

}
