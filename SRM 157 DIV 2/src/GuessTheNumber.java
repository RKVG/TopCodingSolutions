public class GuessTheNumber {
	
	public int noGuesses(int upper, int answer) {

        int lower = 1;
        int numGuesses = 0;
        int guess = -1;

        do {
            numGuesses++;
            guess = ((upper - lower) / 2) + lower;

            if (guess < answer) {
                lower = guess + 1;
            } else if (guess > answer) {
                upper = guess - 1;
            }

        } while (guess != answer);

        return numGuesses;
	}

}
