/*
TopCoder
Single Round Match: 150
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1346
 */

public class WidgetRepairs {

	public int days(int[] arrivals, int numPerDay) {

		// Holds the number of items available to work on.
		int queue = 0;

		// Counts the number of days worked.
		int workingDays = 0;

		// Loop through each of the days.
		for (int arrival : arrivals) {

            /*
             * Increment the queue by the number of items that arrived that
             * day.  If the queue is > 0, count it as a working day.
             * */
			queue += arrival;
			if (queue > 0) { workingDays++; }

			// Remove from the queue the number of items processed in a day.
			queue -= numPerDay;
			if (queue < 0) { queue = 0; } // But dont' go below 0.
		}

		// Work through the remaining items.
		while (queue > 0) {
			workingDays++;
			queue -= numPerDay;
		}

		return workingDays;
	}
}
