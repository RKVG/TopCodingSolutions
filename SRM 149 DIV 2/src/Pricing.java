/*
TopCoder
Single Round Match: 149
Division: 2
Level: 3
Points: 1000
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1600
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pricing {

	/*
     * Given an array consisting of the prices that people are willing to
     * pay, and four pricing categories given in increasing price order,
     * this will return the expected sales total.
     * The price of a cat4 ticket > cat 3 > cat 2 > cat1.
     */
	private static int calcSales(int[] prices, int cat1, int cat2,
								 int cat3, int cat4) {

		int sum = 0;

		for (int willingToPay : prices)  {

			if (willingToPay >= cat4)  {  // Big spenders
				sum += cat4;
			} else if (willingToPay >= cat3)  {
				sum += cat3;
			} else if (willingToPay >= cat2)  {
				sum += cat2;
			} else if (willingToPay >= cat1)  {
				sum += cat1;
			} else {
				// do nothing - even cat1 is too expensive.
			}
		}

		return sum;
	}

	/*
     * Returns the number of unique values in the int[]
     */
	private static int numUniqueValues(int[] prices) {

		Set<Integer> s = new HashSet<>();

		for (int i : prices) {
			s.add(i);
		}

		return s.size();
	}

	public int maxSales(int[] price) {

        /*
         * If there are 4 or less unique prices, then we can just assign each
         * customer their maximum price.  Add them up, and return the sum.
         */
		if (numUniqueValues(price) <= 4) {
			int sum = 0;
			for (int aPrice : price) {
				sum += aPrice;
			}
			return sum;
		}

		// Sort the array of prices.
		Arrays.sort(price);

		int maxSales = 0;

		for (int i = 0; i < price.length - 3; i++) {

			for (int j = i + 1; j < price.length - 2; j++) {

				for (int k = j + 1; k < price.length - 1; k++) {

					for (int m = k + 1; m < price.length; m++) {

						int thisSales = calcSales(price, price[i], price[j],
								price[k], price[m]);

						maxSales = Math.max(thisSales, maxSales);
					}
				}
			}
		}

		return maxSales;
	}
}


