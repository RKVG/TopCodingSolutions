/*
TopCoder
Single Round Match: 155
Division: 2 / 1
Level: 3 / 1
Points: 1000 / 300
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1669
 */

import java.util.ArrayList;
import java.util.List;

public class PaternityTest {

    public int[] possibleFathers(String child, String mother, String[] men) {

        // Contains a list of fathers that cannot be ruled out
        List<Integer> possibleList = new ArrayList<>();

        for (int i = 0; i < men.length; i++) {

            // Number of characters that match the father.
            int matches = 0;

            // Is current father still possible?
            boolean isCurrentFatherPossible = true;

            // Loop through each character in the sequence
            for (int j = 0; j < child.length(); j++) {

                String father = men[i];

                /*
                 * If the current character did not come from the mother,
                 * then it must come from the father.  If it did not come
                 * from the father, we can rule him out.
                 */
                if ((child.charAt(j) != mother.charAt(j)) &&
                        ((father.charAt(j)) != (child.charAt(j)))) {
                    isCurrentFatherPossible = false;
                    break;
                }

                // Count the number of matching characters.
                if (father.charAt(j) == child.charAt(j)) {
                    matches++;
                }
            }

            /*
             * If the father has not been ruled out previously,
             * and the number of matches is >= half the length of the
             * sequence, then add the current father to the list of possible
             * fathers.
             */
            if (isCurrentFatherPossible && (matches >= (child.length() / 2))) {
                possibleList.add(i);
            }
        }

        // Convert the possibleList to an array, and return it
        int[] ret = new int[possibleList.size()];

        for (int i = 0; i < ret.length; i++) {
            ret[i] = possibleList.get(i);
        }

        return ret;
    }

}
