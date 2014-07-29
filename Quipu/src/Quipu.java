/*
TopCoder
Single Round Match: 155
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1686
 */

public class Quipu {

    public int readKnots(String knots) {

        int value = 0;
        int current = 0;

        for (int i = 1; i < knots.length(); i++) {

            if (knots.charAt(i) == 'X') {
                current += 1;

            } else {
                value *= 10;
                value += current;
                current = 0;
            }

        }

        return value;
    }
}
