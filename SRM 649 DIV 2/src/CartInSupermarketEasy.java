public class CartInSupermarketEasy {

	int[][] knownTimes;

	public int calc(int numCarts, int numSplits)  {

		knownTimes = new int[numCarts + 1][numSplits + 1];

		for (int i = 0; i <= numCarts; i++)  {
			for (int j = 0; j <= numSplits; j++)  {

				/*
				* It's clear that:
				* 0 carts will take 0 minutes
				* 1 cart will take 1 minute
				* 2 carts will take 2 minutes.
				*/
				knownTimes[i][j] = (i <= 2) ? i : -1;

				/*
				* If there are no splits, the solution
				* is just the number of carts.
				*/
				if (j == 0)  knownTimes[i][j] = i;
			}
		}

		int result = solve(numCarts, numSplits);

		return result;
	}

	private int solve(int numCarts, int numSplits)  {


		if (knownTimes[numCarts][numSplits] != -1)  {
			return knownTimes[numCarts][numSplits];
		}

		/*
		* In the worst case, we can solve this by removing 1 cart.
		* This will take 1 additional minute.
		*/
		int time = solve(numCarts - 1, numSplits) + 1;

		/*
		* Try all combinations of splitting the carts and of dividing
		* up the number of splits remaining.  The time to handle
		* the whole segment will be the larger of the times it takes
		* to handle the two resulting split segments.
		*/
		for (int x = 1; x < numCarts; x++)  {
			for (int y = 0; y < numSplits; y++)  {
				int timeSeg1 = solve(x, y);
				int timeSeg2 = solve(numCarts - x, numSplits - y - 1);
				int timeToProcessSegments = Math.max(timeSeg1, timeSeg2) + 1;
				time = Math.min(time, timeToProcessSegments);
			}
		}

		knownTimes[numCarts][numSplits] = time;
		return time;
	}
}
