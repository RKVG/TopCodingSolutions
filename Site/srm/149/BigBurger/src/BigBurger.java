/*
TopCoder
Single Round Match: 149
Division: 2 / 1
Level: 2 / 1
Points: 500 / 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1648
 */

public class BigBurger {

    public int maxWait(int[] arrival, int[] service) {

        int maxWaitTime = 0;

        // Holds the time at which the customer's order is fullfulled.
        int[] orderFinishTime = new int[arrival.length];

        // Loop through all the customers.
        for (int i = 0; i < arrival.length; i++) {

            int startTime;

            if (i == 0) {
                startTime = arrival[0];

            /*
             * At the earliest, the customer's start time is when they've
             * arrived.  If the previous order hasn't finished yet,
             * then they must wait until then.
             */
            } else {
                startTime = Math.max(arrival[i], orderFinishTime[i - 1]);
            }

            orderFinishTime[i] = startTime + service[i];

            // Determine how long this customer had to wait.
            int waitTime = orderFinishTime[i] - service[i] - arrival[i];

            if (waitTime > maxWaitTime) {
                maxWaitTime = waitTime;
            }
        }

        return maxWaitTime;
    }
}
