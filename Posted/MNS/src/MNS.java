/*
TopCoder
Single Round Match: 148
Division: 2
Level 3:
Points: 1000

Single Round Match: 148
Division: 1
Level: 2
Points: 450
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MNS {

    /*
    Given the indexes for squares 1,2,3, 4,and 5 - determine the number
    of magic squares that can be formed from the remaining numbers.
     */
    private static Set<Long> generateMagicSquare(int[] numbers, int sq1,
                                                 int sq2, int sq3, int sq4,
                                                 int sq5) {

        Set<Long> retSet = new HashSet<>();

        // Set the values for squares 1,2,3,4, and 5
        int sq1Val = numbers[sq1];
        int sq2Val = numbers[sq2];
        int sq3Val = numbers[sq3];
        int sq4Val = numbers[sq4];
        int sq5Val = numbers[sq5];

        /*
        All the numbers that were not assigned to the five squares above are
        available to be used in squares 3,6,7,8 and 9.
         */
        List<Integer> availableMaster = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if ((i != sq1) && (i != sq2) && (i != sq3)
                    && (i != sq4) && (i != sq5)) {
                availableMaster.add(numbers[i]);
            }
        }

        // Determine the value of the magic square.
        int msNum = sq1Val + sq2Val + sq3Val;

        /*
        Loop through all the available numbers setting square 6 equal to
        their value.
         */
        for (int sq6Val : availableMaster) {

            if ((sq4Val + sq5Val + sq6Val) != msNum) { continue; }

            // copy availableMaster into a new variable for this loop.
            List<Integer> availableCurrent = new ArrayList<>();
            availableCurrent.addAll(availableMaster);

            // Square 7 = magic square value - 1 - 4
            int sq7Val = msNum - sq1Val - sq4Val;
            if (availableCurrent.contains(sq7Val)) {
                availableCurrent.remove(new Integer(sq7Val));
            } else {
                continue;
            }

            // Square 8 = magic square value - 2 - 5
            int sq8Val = msNum - sq2Val - sq5Val;
            if (availableCurrent.contains(sq8Val)) {
                availableCurrent.remove(new Integer(sq8Val));
            } else {
                continue;
            }

            /*
            Square 9 = magic square value - 3 - 6.
            If availableCurrent contains that value,
            then we have a valid magic square.  We'll compute a key for it to
             prevent duplicates, and add it to the result set.
             */
            int sq9Val = msNum - sq3Val - sq6Val;
            if (availableCurrent.contains(sq9Val)) {
                retSet.add(
                        msValue(sq1Val, sq2Val, sq3Val, sq4Val, sq5Val, sq6Val,
                                sq7Val, sq8Val, sq9Val)
                );
            }
        }

        return retSet;
    }

    /*
    Generates a unique key for each possible magic square.
     */
    private static long msValue(long sq1Val, long sq2Val, long sq3Val,
                                long sq4Val, long sq5Val,
                                long sq6Val, long sq7Val, long sq8Val,
                                long sq9Val) {

        long val = 0L;

        val = (val * 10L) + sq1Val;
        val = (val * 10L) + sq2Val;
        val = (val * 10L) + sq3Val;
        val = (val * 10L) + sq4Val;
        val = (val * 10L) + sq5Val;
        val = (val * 10L) + sq6Val;
        val = (val * 10L) + sq7Val;
        val = (val * 10L) + sq8Val;
        val = (val * 10L) + sq9Val;

        return val;
    }

    public int combos(int[] numbers) {

        /*
        Contains a identifier for each magic square that we generate.  Since
        it's a Set, there will be no duplicates.
         */
        Set<Long> results = new HashSet<>();

        /*
        Loop through all possible values for squares 1,2,3,4,
        and 5.
        From these, the values of all other square can be determined.
        i.e. square 6 = square 4 + square 5.
        square 8 = square 2 + square 5. etc.
         */
        for (int sq1 = 0; sq1 < numbers.length; sq1++) {

            for (int sq2 = 0; sq2 < numbers.length; sq2++) {
                if (sq2 == sq1) { continue; }

                for (int sq3 = 0; sq3 < numbers.length; sq3++) {
                    if ((sq3 == sq2) || (sq3 == sq1)) { continue; }

                    for (int sq4 = 0; sq4 < numbers.length; sq4++) {
                        if ((sq4 == sq3) || (sq4 == sq2) || (sq4 == sq1)) {
                            continue;
                        }

                        for (int sq5 = 0; sq5 < numbers.length; sq5++) {
                            if ((sq5 == sq4) || (sq5 == sq3) || (sq5 == sq2)
                                    || (sq5 == sq1)) { continue; }

                            results.addAll(
                                    generateMagicSquare(numbers, sq1, sq2,
                                            sq3, sq4, sq5)
                            );
                        }
                    }
                }
            }
        }

        return results.size();
    }
}
