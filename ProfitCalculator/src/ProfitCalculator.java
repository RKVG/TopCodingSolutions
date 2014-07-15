public class ProfitCalculator {

    public int percent(String[] items) {

        float totalCustCost = 0f;
        float totalStoreCost = 0f;

        for (String s : items) {
            String[] costs = s.split(" ");
            totalCustCost += Float.parseFloat(costs[0]);
            totalStoreCost += Float.parseFloat(costs[1]);
        }

        float margin = ((totalCustCost - totalStoreCost) / totalCustCost) * 100;

        return (int) margin;
    }
}
