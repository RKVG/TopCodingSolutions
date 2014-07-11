public class BigBurger {

    public int maxWait(int[] arrival, int[] service) {

        int[] orderFinishTime = new int[arrival.length];

        for (int i = 0; i < arrival.length; i++) {

            if (i == 0) {
                orderFinishTime[i] = arrival[i] + service[i];
            } else {
                int startTime = arrival[i];
                if (startTime < orderFinishTime[i - 1]) {
                    startTime = orderFinishTime[i - 1];
                }
                orderFinishTime[i] = startTime + service[i];
            }
        }

        int max = 0;

        for (int i = 0; i < arrival.length; i++) {
            int waitTime = orderFinishTime[i] - arrival[i] - service[i];
            if (waitTime > max) {
                max = waitTime;
            }
        }

        return max;
    }
}
