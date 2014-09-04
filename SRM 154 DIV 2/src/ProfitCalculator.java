public class ProfitCalculator {

    public int percent(String[] items) {

        // Holds running totals of the customer and stores costs.
        float totalCustCost = 0f;
        float totalStoreCost = 0f;

        for (String s : items) {

            // Splits the item into customer and store components
            String[] costs = s.split(" ");

            totalCustCost += Float.parseFloat(costs[0]);
            totalStoreCost += Float.parseFloat(costs[1]);
        }

        float margin = ((totalCustCost - totalStoreCost) / totalCustCost) * 100;

        return (int) margin;
    }
}
