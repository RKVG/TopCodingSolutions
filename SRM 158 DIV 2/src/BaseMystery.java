import java.util.ArrayList;
import java.util.List;

public class BaseMystery {

    private static final int MAX_BASE = 20;

    public int[] getBase(String equation) {

        // Saves all of the validBases as they're discovered.
        List<Integer> validBases = new ArrayList<>();

        // Try each base from 2 to MAX_BASE
        for (int base = 2; base <= MAX_BASE; base++) {
            if (isLegal(base, equation)) {
                validBases.add(base);
            }
        }

        // Convert the List<Integer> to the expected return type int[]
        int[] ret = new int[validBases.size()];
        int index = 0;

        for (int i : validBases) {
            ret[index++] = i;
        }

        return ret;
    }

    private boolean isLegal(int base, String equation) {

        // Splits the equation up into it's three parts.
        String[] s = equation.split("[+=]");

        int addend1;
        int addend2;
        int sum;

        // Let the Integer class do all the hard work for you!
        try {
            addend1 = Integer.parseInt(s[0], base);
            addend2 = Integer.parseInt(s[1], base);
            sum = Integer.parseInt(s[2], base);

        } catch (NumberFormatException e) {

            /*
            * An exception is thrown if the number format is invalid for the
            * given base.  i.e. a 2 in base-2 or a G in base-16
            */
            return false;
        }

        return (addend1 + addend2) == sum;
    }
}
