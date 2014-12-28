public class LCMRange {
	
	public int lcm(int first, int last) {

		/*
		* The Least Common Multiple must be a multiple of first, so we'll
		* start there and increment by first to get the next value.
		*/
		int lcm = last;

		boolean found = false;

		// Continue until we find the LCM
		while (!found)  {

			int i = first;

			/*
			* Check each number between first and last (inclusive) to ensure
			* that lcm is a multiple.
			*/
			while (i <= last)  {

				// If it doesn't divide evenly, skip this number.
				if ((lcm % i) != 0)  {
					break;
				}

				i ++;
			}

			/*
			* If we've tested all the numbers, then we've successfully found
			* a Least Common Multiple
			*/
			if (i > last)  {
				found = true;

			} else  {

				/*
				* Otherwise try the next number.  We know it must be a
				* multiple of first, so we can increment by that amount.
				*/
				lcm += last;
			}
		}

		return lcm;
	}
}
