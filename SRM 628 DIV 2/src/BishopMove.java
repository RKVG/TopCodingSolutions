/*
TopCoder
Single Round Match: 628
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=13280
 */

public class BishopMove {

	public int howManyMoves(int r1, int c1, int r2, int c2) {

		// Get the number of rows and columns that the bishop must move.
		int rowDiff = Math.abs(r2 - r1);
		int colDiff = Math.abs(c2 - c1);

		//  Check for no moves necessary
		if ((rowDiff == 0) && (colDiff == 0)) return 0;

        /*
         * If the number of rows that change is the same as the number of
         * columns that change, we can reach it in one move.
         */
		if (rowDiff == colDiff) return 1;

        /*
         * If the difference is not a multiple of 2 (i.e. up 1 row,
         * and over 2) then the square cannot be reached.
         */
		if (((rowDiff - colDiff) % 2) != 0) return -1;

		// In any other case, the square can be reached in 2.
		return 2;

	}
}
