/*
TopCoder
Single Round Match: 146
Division: 1
Level: 2
Points: 600
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1541
 */

public class Masterbrain {

    /*
    A good solution is one in which all the results match the corresponding
    guesses - except for 1.
    Loop through each of the guess/result pairs for the solution checking to
    see if one, and only one, does not match up.
     */
    private static boolean goodSolution(String solution, String[] guesses,
                                        String[] results) {

        boolean lied = false;

        for (int i = 0; i < guesses.length; i++) {

            // Always a single digit, and always in the same spot.
            int numBlack = Integer.parseInt("" + results[i].charAt(0));
            int numWhite = Integer.parseInt("" + results[i].charAt(3));

            if (!resultMatches(guesses[i], solution, numBlack, numWhite)) {
                if (lied) {
                    return false;  // That's two lies - return false.
                } else {
                    lied = true; // First lie.
                }
            }
        }

        return lied;
    }

    /*
    Compares the guess with the solutions, and returns whether or not the
    number of black and white pegs matches up.
     */
    private static boolean resultMatches(String guess, String solution,
                                         int numBlack, int numWhite) {

        // Used to keep tracks of which pegs have already been assigned.
        boolean[] usedBlack = new boolean[guess.length()];
        boolean[] usedWhite = new boolean[guess.length()];

        // Check if numBlack matches
        int numInCorrectPosition = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                numInCorrectPosition++;
                usedBlack[i] = true;
            }
        }

        // If numBlack does not match, no point in checking the white pegs.
        if (numInCorrectPosition != numBlack) {
            return false;
        }

        // Check if numWhite matches
        int numOutOfPositon = 0;
        for (int i = 0; i < guess.length(); i++) {

            /*
            If we're looking at a position that has already been assigned a
            black peg, then continue.
             */
            if (usedBlack[i]) {
                continue;
            }

            for (int j = 0; j < guess.length(); j++) {

                // Again, skip over assigned pegs.
                if (usedBlack[j]) {
                    continue;
                }

                if ((guess.charAt(i) == solution.charAt(j)) && !usedWhite[j]) {
                    numOutOfPositon++;
                    usedWhite[j] = true;
                    break;  // Skip to next i, not j.
                }
            }
        }

        return numOutOfPositon == numWhite;
    }

    public int possibleSecrets(String[] guesses, String[] results) {

        int count = 0;

        /*
        Generate all possible solutions.  For each solution,
        if it meets the criteria of a good solution, then increment count.
        When done, return count.
         */
        for (char h = '1'; h < '8'; h++) {
            for (char i = '1'; i < '8'; i++) {
                for (char j = '1'; j < '8'; j++) {
                    for (char k = '1'; k < '8'; k++) {
                        String solution = "" + h + i + j + k;
                        if (goodSolution(solution, guesses, results)) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
