/*
TopCoder
Single Round Match: 155
Division: 2
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1348
 */

public class BenfordsLaw {

    /*
     * Given the number of transactions, returns an array of doubles that
     * represents the expected number of items for each starting digit.  The
     * index of the array corresponds to the starting digit.
     */
    private static double[] calculateExpectedArray(int numTransactions) {

        /*
         * Make the array of length 10, and set the 0 position to 0.0.  0
         * will never be used, but this avoids having to adjust everything by
         * 1.
         */
        double[] exp = new double[10];
        exp[0] = 0.0;

        /*
         * The probabibility for each position is given by the equation
         * log(base 10) of (1 + 1/D)
         * Multiply this by the number of tranactions to get the expected
         * number.
         */
        for (int i = 1; i < 10; i++) {
            exp[i] = (double) numTransactions *
                    Math.log10(1.0 + ((1.0 / (double) i)));
        }

        return exp;

    }

    public int questionableDigit(int[] transactions, int threshold) {

        int[] actual = new int[10];
        double[] expected = calculateExpectedArray(transactions.length);

        // count the number of items that begin with each digit.
        for (int i : transactions) {
            actual[getFirstDigit(i)]++;
        }

        // Look for digits that fall out of their expected range.
        for (int i = 1; i < 10; i++) {
            if (outOfRange((double) actual[i], expected[i], threshold)) {
                return i;
            }
        }

        return -1;
    }

    // Returns the first digit of an integer.
    private int getFirstDigit(int i) {

        while (i >= 10) {
            i /= 10;
        }

        return i;
    }

    // Returns true if the count is outside the expected range.
    private boolean outOfRange(double i, double e, int threshold) {

        double lowerBound = e / (double) threshold;
        double upperBound = e * (double) threshold;

        return ((i < lowerBound) || (i > upperBound));
    }
}
