/*
TopCoder
Single Round Match: 147
Division: 1
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1520
 */

import java.math.BigDecimal;

public class Dragons {

	// The side of the cube we'll be returning.
	private static final int SNAUGS_SIDE = 2;

	public String snaug(int[] initialFood, int rounds) {

        /*
        Any two sides are neighbors if their numbers do not add up to 7.
         */
		int[] neighbors = {1, 6, 2, 5, 3, 4};

		// Copy the initialFood amounts into the currentRound.
		Fraction[] currentRound = new Fraction[6];
		for (int i = 0; i < currentRound.length; i++) {
			currentRound[i] = new Fraction(initialFood[i]);
		}

		// Loop for the given number of rounds.
		for (int round = 1; round <= rounds; round++) {

			// Create an array of fractions to hold the results.
			Fraction[] nextRound = new Fraction[6];
			for (int j = 0; j < nextRound.length; j++) {
				nextRound[j] = new Fraction(0);
			}

			// Loop through all size sides.
			for (int side = 0; side < 6; side++) {

				// Loop for all neighboring sides.
				for (int neighbor = 0; neighbor < 6; neighbor++) {

                    /*
                    The side is a neighbor if, and only if, side != neighbor,
                     and their two values in the neighbors array do not add
                     up to 7.
                     */
					if ((neighbor == side) || (neighbors[side] +
							neighbors[neighbor] == 7)) { continue; }

					// Add the neighbors value.
					nextRound[side] = nextRound[side].add
							(currentRound[neighbor]);
				}

				// At the end of the round divide by 4 to get 1/4.
				nextRound[side] = nextRound[side].div(4);
			}

			// Set currentRound to prepare for the next loop.
			currentRound = nextRound;
		}

		return currentRound[SNAUGS_SIDE].toString();
	}

	/*
    This class handles all the fraction operations that we'll need.  The
    tests like to overflow even longs, so the internals are stored as
    BigDecimals.
     */
	public class Fraction {

		// Used in several places, so let's just have one copy.
		final BigDecimal Zero = new BigDecimal(0);

		BigDecimal numerator;

		BigDecimal denominator;

		Fraction(BigDecimal num, BigDecimal den) {
			this.numerator = num;
			this.denominator = den;
			reduce();
		}

		Fraction(long num) {
			this.numerator = new BigDecimal(num);
			this.denominator = new BigDecimal(1);
		}

		/*
        Adds another fraction to this fraction.  Return a new instance.
         */
		public Fraction add(Fraction f) {

			BigDecimal num;
			BigDecimal den;

			// If the denominators are equal, just add the numerators.
			if (this.denominator.equals(f.denominator)) {
				den = this.denominator;
				num = this.numerator.add(f.numerator);

				// Otherwise, cross-multiply.
			} else {
				num = (this.denominator.multiply(f.numerator)).add(
						(this.numerator.multiply(f.denominator)));

				den = (this.denominator).multiply(f.denominator);
			}

			return new Fraction(num, den);
		}

		/*
        Divides this fraction by an int.  Returns a new instance.
         */
		public Fraction div(int x) {

			// Division is done by multiplying the denominator by x.
			return new Fraction(
					this.numerator,
					this.denominator.multiply(new BigDecimal(x))
			);
		}

		public String toString() {

            /*
            If the denominator divides the numerator evenly,
            return a whole number.
             */
			if ((this.numerator.remainder(this.denominator)).equals(Zero)) {
				return "" + this.numerator.divide(this.denominator);

				// Otherwise, display as a fraction.
			} else {
				return this.numerator + "/" + this.denominator;
			}
		}

		/*
        Reduces the fraction by dividing the numerator and denominator by
        their greatest common multiple.
         */
		private void reduce() {
			BigDecimal gcm = greatestCommonMultiple(this.numerator,
					this.denominator);
			this.numerator = this.numerator.divide(gcm);
			this.denominator = this.denominator.divide(gcm);
		}

		// Returns the greatest common multiple of two numbers.
		private BigDecimal greatestCommonMultiple(BigDecimal x, BigDecimal y) {
			if (y.equals(Zero)) {
				return x;
			} else {
				return greatestCommonMultiple(y, x.remainder(y));
			}
		}
	}
}
