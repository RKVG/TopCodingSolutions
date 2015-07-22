

public class BadClock {

    public double nextAgreement(
            String trueTime, String skewTime, int hourlyGain) {

        String[] trueString = trueTime.split(":");
        String[] skewString = skewTime.split(":");

        /*
        * Number of seconds that skewTime is behind trueTime.
        * If skewSeconds is negative, then skewTime is ahead
        * of trueTime.
        */
        int skewSeconds = 0;

        skewSeconds =
                (Integer.parseInt(trueString[0]) -
                        Integer.parseInt(skewString[0])) * 60 * 60;

        skewSeconds +=
                (Integer.parseInt(trueString[1]) -
                        Integer.parseInt(skewString[1])) * 60;

        skewSeconds += Integer.parseInt(trueString[2]) -
                Integer.parseInt(skewString[2]);

        if (skewSeconds == 0) return 0.0;

        if ((skewSeconds > 0) && (hourlyGain < 0)) {
            // Clock is behind, and losing.
            skewSeconds -= 12 * 60 * 60;  // Move skewTime ahead 12 hours

        } else if ((skewSeconds < 0) && (hourlyGain > 0)) {
            // Clock is ahead, and gaining
            skewSeconds += 12 * 60 * 60;  // Move skewTime behind 12 hours
        }

        return (double) skewSeconds / (double) hourlyGain;

    }
}
