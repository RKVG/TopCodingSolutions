/*
TopCoder
Single Round Match: 144
Division: 2
Level: 1
Points: 200
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1708
 */
public class Time {

    public static final int SECONDS_PER_MINUTE = 60;

    public static final int SECONDS_PER_HOUR = SECONDS_PER_MINUTE * 60;

    public String whatTime(int seconds) {

        /*
        Get the whole number of hours that fits into seconds.
        Store that as h and then subtract the hours portion
         off of seconds.
         */
        int h = seconds / SECONDS_PER_HOUR;
        seconds -= (h * SECONDS_PER_HOUR);

        // Repeat to get the number of minutes.
        int m = seconds / SECONDS_PER_MINUTE;
        seconds -= (m * SECONDS_PER_MINUTE);

        // What's left over is the number of seconds.
        int s = seconds;

        // Create the return String in the appropriate format.
        return h + ":" + m + ":" + s;
    }
}
