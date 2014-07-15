import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberGuessing {

    /*
     * Returns a set of all Integers that should be tried.  If there are no
     * guesses to follow, then the set will be:
     * 1 less than the smallest guess.
     * 1 greater than all previous guesses.
     * If there are more guesses to follow, then return all integers in the
     * range.
     * In either case, do not add any numbers that already appear in guesses.
     */
    public static Set<Integer> getPossibleGuesses(int range, int[] guesses,
                                                  boolean isLast) {

        Set<Integer> possibleGuesses = new HashSet<>();

        if (isLast) {

            // If there are no guesses, and no guesses to follow, just return 1
            if (guesses.length == 0) {
                possibleGuesses.add(1);
                return possibleGuesses;

                /*
                * If there are guesses to follow, return one less than the
                * smallest guess, and one greater than all other guesses.
                * Be sure to check that we're not adding < 1 or > range.
                */
            } else {
                if (guesses[0] > 1) {
                    possibleGuesses.add(guesses[0] - 1);
                }

                for (int g : guesses) {
                    if (g < range) {
                        possibleGuesses.add(g + 1);
                    }
                }
            }

            /*
             * If there are guesses to follow, then we'll check every number
             * in the range that hasn't alredy been guesses.
             */
        } else {
            for (int i = 1; i <= range; i++) {
                possibleGuesses.add(i);
            }
        }

        for (int i : guesses) {
            possibleGuesses.remove(i);
        }

        return possibleGuesses;
    }

    /*
     * Makes the best guess possible based on the guesses that have been taken,
     * and the number of guesses to follow.  Returns an array that equals
     * guesses, except that the new best guess is inserted.
     * The best guess is obtained by following these steps.
     * 1. Obtain possible guesses.
     * 2. For each possible guess, call makeBestGuess recursively to get how
     * all the following guessers will respond.
     * 3. Check what the yield is for that guess (how many numbers = a win)
     * 4. Repeat for all other possible guesses, keeping track of the largest
     * yield.
     */
    public GuessResults makeBestGuess(int range, int[] guesses,
                                      int numLeft) {

        // When numLeft < 0, return to break the recursion.
        if (numLeft < 0) {
            return new GuessResults(guesses);
        }

        // Used to keep track of the best guess tried so far and it's result.
        int maxYield = 0;
        GuessResults maxResults = new GuessResults();

        Set<Integer> possibleGuesses = getPossibleGuesses(range, guesses,
                (numLeft == 0));

        for (int possibleGuess : possibleGuesses) {

            /*
             * Make a copy of the guesses array, and insert the new guess into
             * its proper location.
             */
            int[] beforeTry = Arrays.copyOf(guesses, guesses.length + 1);
            beforeTry[beforeTry.length - 1] = possibleGuess;
            Arrays.sort(beforeTry);

            /*
             * Recursively call makeBestGuess() using this current guess and
             * check the results.
             */
            GuessResults afterTry = makeBestGuess(range, beforeTry,
                    numLeft - 1);
            afterTry.guess = possibleGuess;

            int yield = calculateYield(possibleGuess, afterTry.results, range);

            if ((yield > maxYield) ||
                    ((yield == maxYield) &&
                            (possibleGuess < maxResults.guess))) {
                maxYield = yield;
                maxResults = afterTry;
            }
        }

        return maxResults;
    }

    /*
     * Given an array of guesses, returns how many numbers result in a win
     * for the given guess.
     * The given guess must exist in the array of guesses.
     */
    public int calculateYield(int guess, int[] guesses, int range) {

        int yield;

        // Determine the position of guess in the array of guesses.
        int i = 0;
        while (guesses[i] != guess) {
            i++;
        }

        // This guess is the lowest.
        if (i == 0) {
            yield = guess + ((guesses[i + 1] - guess - 1) / 2);

            // This guess is the highest.
        } else if (i == (guesses.length - 1)) {
            yield = (range - guess + 1) + ((guess - guesses[i - 1] - 1) / 2);

            // This guess is somewhere in between two other guesses.
        } else {
            yield = (((guesses[i + 1] - guess - 1) / 2)
                    + 1 +
                    ((guess - guesses[i - 1] - 1) / 2));
        }

        return yield;
    }

    /*
     * Loops through all possible guesses to determine which one results in
     * the greatest yeild.
     */
    public int bestGuess(int range, int[] guesses, int numLeft) {

        // If there is only one number possible, take it and quit early.
        if (range == 1) {
            return 1;
        }

        return makeBestGuess(range, guesses, numLeft).guess;
    }

    /*
     * Ties a guess to the resulting array of guesses
     */
    private class GuessResults {
        int[] results;
        Integer guess;

        GuessResults() {
            this.results = null;
            this.guess = Integer.MAX_VALUE;
        }

        GuessResults(int[] results) {
            this.results = results;
            this.guess = Integer.MAX_VALUE;
        }
    }
}
