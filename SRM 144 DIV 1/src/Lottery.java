/*
TopCoder
Single Round Match: 144
Division: 1
Level: 2
Points: 550
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1659
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

	/*
    Reads each String from rules, creates a new LotteryGame out of it,
    sorts the games, and returns the sorted list of names.
     */
	public String[] sortByOdds(String[] rules) {

		List<LotteryGame> games = new ArrayList<>();

        /*
        Read each of the input Strings, create a LotteryGame object out of
        them, and add them to the games array.
         */
		for (String s : rules) {
			games.add(CreateGame(s));
		}

		Collections.sort(games);

        /*
        Create the return array, copy the now sorted games into it, and return.
         */
		String[] names = new String[games.size()];

		int i = 0;
		for (LotteryGame g : games) {
			names[i++] = g.getName();
		}

		return names;
	}

	/*
    Parses the input String and returns a new LotteryGame object.
     */
	private LotteryGame CreateGame(String s) {

		// Split the string on the space char.
		String[] nameAndOptions = s.split(":");

		String name = nameAndOptions[0];

		String[] options = nameAndOptions[1].split(" ");

		int choices = Integer.valueOf(options[1]);
		int blanks = Integer.valueOf(options[2]);

		boolean sorted = "T".equals(options[3]);
		boolean unique = "T".equals(options[4]);

		return new LotteryGame(name, choices, blanks, sorted, unique);
	}

	/*
    An inner class that represents each type of game.
    It encapsulates the details of calculating the number of possible
    combinations, and implements Comparable to make the sorting easy.
     */
	class LotteryGame implements Comparable<LotteryGame> {

		final String name;

		final long combinations;

		/*
        Calculates the number of combinations (permutations?) upon object
        creation.
         */
		LotteryGame(String name, int choices, int blanks, boolean sorted,
					boolean unique) {

			this.name = name;

            /*
           There are four different ways to compute the number of
           combinations base on the values of unique and sorted.  The first
           three you should recognize from discrete math classes.  The last
           case (!unique && sorted) I don't fully understand.
            */
			if (unique && sorted) {
				combinations = choose(choices, blanks);
			} else if (unique) {
				combinations = choose(choices, blanks) * factorial(blanks);
			} else if (!sorted) {
				combinations = power(choices, blanks);
			} else {
				combinations = choose(choices + blanks - 1, blanks);
			}
		}

		/*
        Implements (m choose n) = m! / ((m-n)! * n!)
         */
		long choose(int choices, int blanks) {
			return factorial(choices, blanks) / factorial(blanks);
		}

		public long factorial(int n) {
			return factorial(n, n);
		}

		/*
        Doing large factorials runs the risk of overflows.  This allows us to
         calculate, for example, 100! / 98! without having to multiply it all
          out.
         */
		long factorial(int n, int stopAfter) {

			long result = (long) n;

			for (long i = (n - 1); i > (n - stopAfter); i--) {
				result *= i;
			}

			return result;
		}

		/*
        Does the same thing as Math.pow() but this uses longs instead of
        doubles.
         */
		long power(int base, int exp) {

			if (exp == 0) { return 1L; }

			// I don't ever expect this, but just in case.
			if (exp < 0) {
				throw new IllegalArgumentException("" + exp);
			}

			long result = base;

			for (int i = 1; i < exp; i++) {
				result *= (long) base;
			}

			return result;
		}

		long getCombinations() {
			return this.combinations;
		}

		String getName() {
			return this.name;
		}

		/*
        Sort based on the number of possible combinations.  The more possible
         combinations, the harder the game is to win.
         If two games have the same number of combinations,
         then sort based on their name.
         */
		public int compareTo(LotteryGame other) {

			if (this.combinations < other.getCombinations()) {
				return -1;
			} else if (this.combinations > other.getCombinations()) {
				return 1;
			} else {
				return this.name.compareTo(other.getName());
			}
		}
	}
}
