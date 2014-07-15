/*
TopCoder
Single Round Match: 148
Division: 2
Level: 1
Points: 250

Single Round Match 215
Division: 2
Level: 1
Points: 250

Description: http://community.topcoder.com/stat?c=problem_statement&pm=1741
 */

public class DivisorDigits {

    public int howMany(int number) {

        int count = 0;

        // Convert the number parameter into a char array
        char[] digits = ("" + number).toCharArray();

        // Test each digit to see if it evenly divides number
        for (char c : digits) {

            // Convert the character into an int
            int i = Integer.valueOf(c) - '0';

            // Don't try to divide by 0.
            if (i == 0) { continue; }

            if ((number % i) == 0) {
                count++;
            }
        }

        return count;
    }
}
