public class QuipuReader {

	private int ropeLength = 0;

	// The method called by TopCoder.
	public int[] readKnots(String[] knots) {

		int[] values = new int[knots.length];

		ropeLength = knots[0].length();

		int clusterStart = findClusterStart(knots, 0);

		while (clusterStart < ropeLength)  {

			int clusterEnd = findClusterEnd(knots, clusterStart);

			/*
			* We've found the start and end indexes for the current cluster.
			* Now count the number of knots that fall in that range for
			* each rope.
			*/
			for (int q = 0; q < knots.length; q++)  {
				values[q] *= 10;
				values[q] += doCount(knots[q], clusterStart, clusterEnd);
			}

			clusterStart = findClusterStart(knots, clusterEnd);
		}

		return values;
	}

	/*
	* Returns the index of the next cluster which starts at or beyond p.
	* This will be the location of the first 'X' found among all ropes.
	*/
	private int findClusterStart(String[] knots, int p)  {

		if (p >= ropeLength)  return ropeLength;

		int minStart = ropeLength;

		for (int q = 0; q < knots.length; q++)  {
			int i = p;

			while ((i < ropeLength) && knots[q].charAt(i) != 'X')  {
				i++;
			}

			// Note the earliest start position found.
			minStart = Math.min(minStart, i);
		}

		return minStart;
	}

	/*
	* Returns the index where the cluster starting at p ends.
	* This will be the position after the last 'X' of the longest continuous
	* string of 'X's starting at p among all the ropes.
	*/
	private int findClusterEnd(String[] knots, int p)  {

		int maxEnd = p;

		for (int q = 0; q < knots.length; q++)  {
			int i = p;
			while ((i < ropeLength) && (knots[q].charAt(i) == 'X'))  {
				i++;
			}

			// Note the greatest ending position found.
			maxEnd = Math.max(maxEnd, i);
		}

		return maxEnd;
	}

	/*
	* Counts the number of knots located between clusterStart and clusterEnd
	* on the given rope.
	*/
	private int doCount(String rope, int start, int end)  {

		int n = 0;

		for (int p = start; p < end; p++)  {
			if (rope.charAt(p) == 'X')  {
				n++;
			}
		}

		return n;
	}
}
