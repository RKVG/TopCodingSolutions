public class NumberGuesser {

	public int guess(String leftOver) {

		/*
		* Loop through all positions in leftOver, inserting the digits
		* 1..9 at each position.
		*/
		for (int position = 0; position <= leftOver.length(); position++) {
			for (int digitToInsert = 1; digitToInsert < 10; digitToInsert++) {

				// Add digit back into leftOver
				String beforeRemovingDigit =
						leftOver.substring(0, position) +
								digitToInsert +
								leftOver.substring(position, leftOver.length());

				// Larger number - Smaller number = z
				int z = Integer.parseInt(beforeRemovingDigit);

				/*
				* Call larger number y
				* Call smaller number x
				* y - x = z or y = x + z
				*/
				for (int x = 1; x < 5000; x++) {
					int y = x + z;

					// See if x and y have the same set of digits
					Integer i = missingDigit(x, y);

					if (missingDigit(x,y) == null) {
						return missingDigit(z, Integer.parseInt(leftOver));
					}
				}
			}
		}

		return -1;
	}

	/*
	* Return the first digit found that is in x, but not in y;
	* or in y but not in x.
	* Returns null if all the digits in x are in y and vice-versa.
	* Does not consider the digit 0.
	*/
	private Integer missingDigit(int x, int y)  {


		int[] digits = new int[10];

		// Add the digits found in x
		while (x > 0)  {
			int i = x % 10;	// Get the last digit
			digits[i]++;
			x /= 10;
		}

		// Subtract the digits found in y
		while (y > 0)  {
			int i = y % 10;
			digits[i]--;
			y /= 10;
		}

		// Skip over the digit 0
		for (int i = 1; i < 10; i++)  {
			if (digits[i] != 0) return i;
		}

		// Number have the same combination of digits.
		return null;

	}

}
