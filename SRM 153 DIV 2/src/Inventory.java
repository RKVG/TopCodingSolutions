public class Inventory {

	private static final double DAYS_IN_MONTH = 30.0;

	/*
    Calculates the average sales for the month. For months that sold out in
    less than 30 days, assume the same rate for the remainder of the month.
     */
	private static double calcAverage(int sales, int days) {
		return ((double) sales) / ((double) days / DAYS_IN_MONTH);
	}

	public int monthlyOrder(int[] sales, int[] daysAvailable) {

        /*
        Keep a running total of the sum of monthly sales,
        and the number of months.  We'll divides these to get the average.
         */
		double sumOfMonthlySales = 0.0;
		int numMonths = 0;

		for (int i = 0; i < sales.length; i++) {

			// If items were available for 0 days, do not count the month.
			if (daysAvailable[i] == 0) { continue; }

			// Add current months sales to the running total.
			sumOfMonthlySales += calcAverage(sales[i], daysAvailable[i]);
			numMonths++;
		}

		double average = sumOfMonthlySales / (double) numMonths;

        /*
        Adjusts for the imprecision of Doubles.  See the Notes in the problem
         statement.
         */
		average -= Double.parseDouble("1e-9");

		// Round up using the ceiling method.
		return (int) Math.ceil(average);
	}
}
