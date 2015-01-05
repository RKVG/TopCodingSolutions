/*
TopCoder
Single Round Match: 149
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1313
 */

public class FormatAmt {

	/*
     * Formats the dollars portion of the string
     */
	private static String formatDollars(int d) {

		String s = String.valueOf(d);

		StringBuilder sb = new StringBuilder();

        /*
         * Starts from the digit nearest the decimal point and works left
         * toward the most significant digit.  Inserts a comma after three
         * characters, unless it's the final character.
         */
		int count = 0;
		for (int i = s.length() - 1; i >= 0; i--) {

			// Copies the current character to the front of the StringBuilder
			sb.insert(0, s.charAt(i));
			count++;

            /*
             * After 3 characters, insert a comma.  But only if we're not now
             * at the left-most position.
             */
			if ((count == 3) && (i != 0)) {
				sb.insert(0, ",");
				count = 0;
			}
		}
		return sb.toString();
	}

	/*
     * Inserts leading 0's until the length is at least 2.
     */
	private static String formatCents(int c) {

		String s = String.valueOf(c);
		while (s.length() < 2) {
			s = "0" + s;
		}

		return s;
	}

	/*
     * Formats the dollars (to the left of the decimal point) and the cents
     * separately, then combines them to make the return value.
     */
	public String amount(int dollars, int cents) {

		return "$" + formatDollars(dollars) + "." + formatCents(cents);
	}
}
