/*
TopCoder
Single Round Match: 156
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1777
 */

import java.util.Arrays;

public class DiskSpace {

	public int minDrives(int[] used, int[] total) {

		int capacityNeeded = 0;

		// Calculate the total amount of space needed.
		for (int u : used) {
			capacityNeeded += u;
		}

        /*
         * Sort the drive capacitites.
         * Then we'll start filling from the largest disc working back to the
         * smallest.
         */
		Arrays.sort(total);

		// Start with the largest drive.
		int i = total.length - 1;

		// The number of drives needed.
		int count = 0;

		while (capacityNeeded > 0) {
			count++;

			// Subtract the current drive's capacity from the amount needed.
			capacityNeeded -= total[i--];
		}

		return count;
	}
}
