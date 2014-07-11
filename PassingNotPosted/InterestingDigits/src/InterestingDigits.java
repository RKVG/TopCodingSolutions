import java.util.ArrayList;
import java.util.List;

public class InterestingDigits {

    private static boolean isInteresting(int digit, int base) {

        int max = base * base * base;

        for (int i = digit; i < max; i += digit) {
            if (!(sumOfDigits(i, digit, base))) {
                return false;
            }
        }

        return true;
    }

    private static boolean sumOfDigits(int i, int digit, int base) {

        int sum = 0;

        int x = 1;

        while (i > base) {
            while ((x * base) < i) {
                x *= base;
            }
            int div = (i / x);
            sum += div;
            i = i - (x * div);
            x = 1;
        }

        sum += i;

        if (sum > base) {
            return sumOfDigits(sum, digit, base);
        }
        return ((sum % digit) == 0);
    }

    public int[] digits(int base) {

        List<Integer> retList = new ArrayList<>();

        for (int digit = 2; digit < base; digit++) {

            if (isInteresting(digit, base)) {
                retList.add(digit);
            }
        }

        int[] retArray = new int[retList.size()];
        int x = 0;
        for (int i : retList) {
            retArray[x++] = i;
        }

        return retArray;
    }
}
