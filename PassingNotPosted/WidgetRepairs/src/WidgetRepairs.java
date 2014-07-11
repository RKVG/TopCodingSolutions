public class WidgetRepairs {

    public int days(int[] arrivals, int numPerDay) {

        int queue = 0;
        int workingDays = 0;

        for (int arrival : arrivals) {
            queue += arrival;
            if (queue > 0) { workingDays++; }
            queue -= numPerDay;
            if (queue < 0) { queue = 0; }
        }

        while (queue > 0) {
            workingDays++;
            queue -= numPerDay;
        }

        return workingDays;
    }
}
