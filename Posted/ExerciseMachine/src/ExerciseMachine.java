/*
TopCoder
Single Round Match: 145
Division: 2
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1675
 */

public class ExerciseMachine {

    public static final int SECS_PER_MINUTE = 60;

    public static final int SECS_PER_HOUR = SECS_PER_MINUTE * 60;

    public int getPercentages(String time) {

        // Split the time on the ':' character, and get it's components.
        String[] timeArr = time.split(":");
        int hours = Integer.parseInt(timeArr[0]);
        int minutes = Integer.parseInt(timeArr[1]);
        int secs = Integer.parseInt(timeArr[2]);

        // Calculate the total number of seconds in the workout.
        int totalSeconds = (hours * SECS_PER_HOUR) +
                (minutes * SECS_PER_MINUTE) + secs;

        int counter = 0;

        // For each second, determine if the counter will be displayed.
        for (int i = 1; i < totalSeconds; i++) {
            if (((i * 100) % totalSeconds) == 0) {
                counter++;
            }
        }

        return counter;
    }
}
