/*
TopCoder
Single Round Match: 145
Division: 1
Level: 1
Points: 250 Points
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1677&rd=4530
 */

public class Bonuses {

    public int[] getDivision(int[] points) {

        // An array to store the bonus amounts.  This is the return value.
        int[] bonuses = new int[points.length];

        // Used to keep track of employees that received the "extra" bonus.
        boolean[] extraBonus = new boolean[points.length];

        // Calculate the total points that have been awarded.
        int totalPoints = 0;
        for (int point : points) {
            totalPoints += point;
        }

        /*
        Assign each employee their bonus percentage based on their points
        and the total points.  Fractions will be rounded down.  Keeps
        track of the percentage remaining.
         */
        int bonusPctRemaining = 100;
        for (int i = 0; i < points.length; i++) {
            bonuses[i] = (points[i] * 100) / totalPoints;
            bonusPctRemaining -= bonuses[i];
        }

        /*
        If there is any bonus percentage remaining, we'll assign 1% to each
        of the top scoring employees until it is used up.
         */
        while (bonusPctRemaining > 0) {

            int maxPoints = -1;
            int employee = -1;

            /*
            Find the employee with the highest points value that has
            not yet been awarded the extraBonus.
            Ties go to the employee positioned earlier in the points array.
             */
            for (int i = 0; i < points.length; i++) {
                if ((!extraBonus[i]) && (points[i] > maxPoints)) {
                    employee = i;
                    maxPoints = points[i];
                }
            }

            /*
            We've found the next top employee, so set extraBonus to true,
            so they are not considered next time; add 1% to their bonus,
            and remove 1% from the amount remaining.
             */
            extraBonus[employee] = true;
            bonuses[employee] += 1;
            bonusPctRemaining -= 1;
        }

        return bonuses;
    }
}
