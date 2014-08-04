/*
TopCoder
Single Round Match: 150
Division: 2 / 1
Level: 2 / 1
Points: 500 / 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1523
 */

import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

    /*
     * Loops through all 3 or fewer digit multiples of digitBase testing each
     * to see if the sum of all digits divides evenly by digitBase
     */
    private static boolean isInteresting(int digitBase, int base) {

        // The largest 3-digit number in the given base
        int max = base * base * base;

        // Loop through all multiples of digit
        for (int digitMultiple = digitBase; digitMultiple < max;
             digitMultiple += digitBase) {

            if (!(sumOfDigitsDividesEvenly(digitMultiple, digitBase, base))) {
                return false;
            }
        }

        return true;
    }

    /*
     * Sums all the digits in multiple and tests to see if it divides evenly
     * by digit.  If the result is multi-digit, then sumOfDigitsDividesEvenly()
     * is call recursively on the result.
     */
    private static boolean sumOfDigitsDividesEvenly(int multiple, int digit,
                                                    int base) {

        int sum = 0;

        while (multiple > base) {

            int x = 1;

            while ((x * base) < multiple) {
                x *= base;
            }
            int div = (multiple / x);  // div now contains left-most digit.

            sum += div;
            multiple = multiple - (x * div);
        }

        sum += multiple;

        /*
         * If the result is larger than base, then recursively call
         * sumOfDigitsDevidesEvenly() on the result.
         */
        if (sum > base) {
            return sumOfDigitsDividesEvenly(sum, digit, base);
        }

        return ((sum % digit) == 0);
    }

    /*
     * Loops through all digits in the given base.  If the digit is
     * interesting for that base, then add it to a List.
     * When done, convert the List to an array and return it.
     */
    public int[] digits(int base) {

        List<Integer> interestingDigits = new ArrayList<>();

        for (int digit = 2; digit < base; digit++) {
            if (isInteresting(digit, base)) {
                interestingDigits.add(digit);
            }
        }

        // Convert the List to an int[]
        int[] retArray = new int[interestingDigits.size()];
        int x = 0;
        for (int i : interestingDigits) {
            retArray[x++] = i;
        }

        return retArray;
    }
}
