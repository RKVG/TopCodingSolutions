public class EyeDrops {

    public double closest(int sleepTime, int k) {

        double interval = 24.0 * 60.0 / (double) k;

        if (interval > (sleepTime * 60)) return interval;

        return 60.0 * (24 - sleepTime) / (double) (k - 1);
    }
}
