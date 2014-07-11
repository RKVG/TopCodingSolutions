public class MostProfitable {

    public String bestItem(int[] costs, int[] prices, int[] sales,
                           String[] items) {

        int maxProfit = 0;

        int[] profit = new int[costs.length];

        for (int i = 0; i < costs.length; i++) {
            profit[i] = (prices[i] - costs[i]) * sales[i];
            if (profit[i] > profit[maxProfit]) {
                maxProfit = i;
            }
        }

        if (profit[maxProfit] > 0) {
            return items[maxProfit];
        } else {
            return "";
        }
    }
}
