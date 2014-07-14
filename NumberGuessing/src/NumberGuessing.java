import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberGuessing {

    public static List<Integer> getPossibleGuesses(int range, int[] guesses,
                                                   int numLeft) {

        List<Integer> possible = new ArrayList<>();

        if (numLeft > 0) {
            possible.add(1);

            if (guesses.length > 0) {
                possible.add(guesses[0] - 1);
            }

            for (int i : guesses) {
                if ((i + 1) <= range) {
                    possible.add(i + 1);
                }
            }
        } else {

            if (guesses.length > 0) {
                possible.add(guesses[0] - 1);
                possible.add(guesses[guesses.length - 1] + 1);
            }

            for (int i = 1; i < guesses.length; i++) {
                possible.add((guesses[i - 1] + guesses[i]) / 2);
            }
        }

        Collections.sort(possible);
        return possible;
    }

    public int bestGuess(int range, int[] guesses, int numLeft) {

        int[] afterGuesses = makeBestGuess(range, guesses, numLeft);

        for (int i = 0; i < guesses.length; i++) {
            if (afterGuesses[i] != guesses[i]) { return afterGuesses[i]; }
        }

        return afterGuesses[afterGuesses.length - 1];
    }

    private int calcYield(int[] guesses, int guess, int range) {

        int lowerNeighbor = 0;
        int higherNeighbor;

        int g = 0;
        while (guesses[g] < guess)  {
            lowerNeighbor = guesses[g];
            g++;
        }
        if (g == guesses.length)  {
            higherNeighbor = range;
        } else {
            higherNeighbor = guesses[g];
        }

        return ((higherNeighbor - lowerNeighbor) + 1) / 2;


    }

    public int[] makeBestGuess(int range, int[] guesses, int numLeft) {

        int maxYield = 0;
        int maxYieldGuess = 0;

        if (numLeft < 0) { return guesses; }

        for (Integer guess : getPossibleGuesses(range, guesses, numLeft)) {
            int[] tryGuess = Arrays.copyOf(guesses, guesses.length + 1);
            tryGuess[tryGuess.length - 1] = guess;
            Arrays.sort(tryGuess);
            tryGuess = makeBestGuess(range, tryGuess, numLeft - 1);
            int yield = calcYield(tryGuess, guess, range);

            if (yield > maxYield) {
                maxYield = yield;
                maxYieldGuess = guess;
            }
        }

        int[] tryGuess = Arrays.copyOf(guesses, guesses.length + 1);
        tryGuess[tryGuess.length - 1] = maxYieldGuess;
        Arrays.sort(tryGuess);
        tryGuess = makeBestGuess(range, tryGuess, numLeft - 1);
        return tryGuess;
    }
}
