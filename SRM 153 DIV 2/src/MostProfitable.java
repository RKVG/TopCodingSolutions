public class MostProfitable {

	public String bestItem(int[] costs, int[] prices, int[] sales,
						   String[] items) {

		int maxProfitIdx = -1;
		int maxProfitAmt = Integer.MIN_VALUE;

        /*
         * For each item, calculate the profit.  If it's greater than any
         * we've seen so far, store that amount and its index.
         * The profit is calculated as the (price - cost) times the number of
         * sales.
         */
		for (int i = 0; i < costs.length; i++) {
			int profit = (prices[i] - costs[i]) * sales[i];
			if (profit > maxProfitAmt) {
				maxProfitIdx = i;
				maxProfitAmt = profit;
			}
		}

        /*
         * If the profit on our most profitable item is greater than 0,
         * return it's name.  If there are no profitable items,
         * return an empty string.
         */
		if (maxProfitAmt > 0) {
			return items[maxProfitIdx];
		} else {
			return "";
		}
	}
}
