import java.lang.Integer;

public class GuessTheNumber {

	public int noGuesses(int upper, int answer) {

		int lower = 1;
		int numGuesses = 0;
		int guess = 0;

		while (guess != answer) {

			numGuesses++;

//            guess = (upper + lower) / 2;  // Don't do This!!!
			guess = ((upper - lower) / 2) + lower;
			System.out.println(guess);

			if (guess < answer) {
				lower = guess + 1;

			} else if (guess > answer) {
				upper = guess - 1;
			}

		}

		return numGuesses;
	}

	public static void main(String[] args) {
		int upper = Integer.MAX_VALUE - 1;
		int answer = Integer.MAX_VALUE - 2;

		System.out.println(new GuessTheNumber().noGuesses(upper, answer));
	}
}