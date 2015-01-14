/*
TopCoder
Single Round Match: 152
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1765
*/

public class FixedPointTheorem {

	// Number of iterations before we being keeping track of high and low.
	private static final int SETTLE_CYCLES = 200_000;

	// Number of iterations where we do track high and low.
	private static final int RANGE_CYCLES = 1000;

	// This is the function that we'll be iterating through
	private static double fnct(double R, double X) {

		return R * X * (1 - X);
	}

	public double cycleRange(double R) {

		double X = 0.25;

		// Run through 200,000 iterations to stabilize the function.
		for (int i = 1; i < SETTLE_CYCLES; i++) {
			X = fnct(R, X);
		}

		// Grab the first number and set it to both the high and low.
		X = fnct(R, X);

		double hi = X;
		double lo = X;

		// Start at 2 since we already grabbed the first one.
		for (int i = 2; i < RANGE_CYCLES; i++) {
			X = fnct(R, X);
			hi = Math.max(hi, X);
			lo = Math.min(lo, X);
		}

		return (hi - lo);
	}
}
