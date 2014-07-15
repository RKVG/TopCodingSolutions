import java.util.*;

public class NumberGuessing {

    public static Set<Integer> getPossibleGuesses(int range, int[] guesses,
                                                  int numLeft) {

        return null;
    }

    /*
    Makes the best guess possible, and contains a new array of guesses that
    contains that best guess.
     */
    public GuessAndResult makeBestGuess(int range, int[] guesses,
                                        int guess, int numLeft) {

        if (numLeft > 0) { return new GuessAndResult(guesses, guess); }

        int maxYield = 0;
        int maxYieldingGuess = 0;
        int[] maxYieldingArray = guesses;

        Set<Integer> possibleGuesses = getPossibleGuesses(range, guesses,
                numLeft);

        for (int possibleGuess : possibleGuesses) {
            int[] beforeTry = Arrays.copyOf(guesses, guesses.length + 1);
            beforeTry[beforeTry.length - 1] = possibleGuess;
            Arrays.sort(beforeTry);
            int[] afterTry = makeBestGuess(range, beforeTry,
                    possibleGuess, numLeft - 1).result;
            int yield = calculateYield(possibleGuess, afterTry, range);

            if ((yield > maxYield) ||
                    ((yield == maxYield) &&
                            (possibleGuess < maxYieldingGuess))) {
                maxYield = yield;
                maxYieldingArray = Arrays.copyOf(afterTry, afterTry.length);
                maxYieldingGuess = possibleGuess;
            }
        }
        return new GuessAndResult(maxYieldingArray, maxYieldingGuess);
    }

    public int calculateYield(int guess, int[] guesses, int range) {

        int yield;

        int i = 0;
        while (guesses[i] != guess) {
            i++;
        }

        int hi;
        int lo;

        // This guess is the lowest.
        if (i == 0) {
            yield = guess + ((guesses[i + 1] - guess - 1) / 2);

            // This guess is the highest.
        } else if (i == (guesses.length - 1)) {
            yield = (range - guess + 1) + ((guess - guesses[i - 1] - 1) / 2);

            // Somewhere in between.
        } else {
            yield = (((guesses[i + 1] - guess - 1) / 2)
                    + 1 +
                    ((guess - guesses[i - 1] - 1) / 2));
        }

        return yield;
    }

    public int bestGuess(int range, int[] guesses, int numLeft) {
        Arrays.sort(guesses);

        int maxYield = 0;
        int maxYieldingGuess = -1;

        for (int i=1; i<range; i++) {

            for (int j=0; j<guesses.length; j++)  {
                if (guesses[j] == i) continue;
            }

            int[] beforeTry = Arrays.copyOf(guesses, guesses.length + 1);
            beforeTry[beforeTry.length - 1] = i;
            Arrays.sort(beforeTry);
            int[] afterTry = makeBestGuess(range, beforeTry,
                    i, numLeft-1).result;
            int yield = calculateYield(i, afterTry, range);

            if ((yield > maxYield) ||
                    ((yield == maxYield) &&
                            (i < maxYieldingGuess))) {
                maxYield = yield;
                maxYieldingGuess = i;
            }
        }
        return maxYieldingGuess;
    }

    private class GuessAndResult {

        int[] result;

        int guess;

        GuessAndResult(int[] result, int guess) {
            this.result = result;
            this.guess = guess;
        }
    }
}



