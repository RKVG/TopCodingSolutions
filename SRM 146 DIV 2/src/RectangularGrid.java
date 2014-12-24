/*
TopCoder
Single Round Match: 146
Division: 2
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&amp;pm=1589
 */

public class RectangularGrid {

	/*
    Determines the number of s-sized Squares that can be found in a rectangle
     of dimensions width x height.
     */
	private static long findSquaresInRectangle(int s, int width, int height) {

		long count = 0;

		for (int x = 0; (x + s) <= width; x++) {
			for (int y = 0; (y + s) <= height; y++) {
				count++;
			}
		}

		return count;
	}

	public long countRectangles(int width, int height) {

		long widthL = (long) width;
		long heightL = (long) height;

        /*
        The total number of rectangles, including squares,
        that can be found in a rectangular grid is given by the formula:
        (width^2 + width) * (length^2 + length) / 4
        See: http://www.gottfriedville.net/mathprob/comb-subrct.html
         */

		// Now, We subtract off the number of squares.
		long totalWithoutSquares = (((widthL * widthL) + widthL) *
				((heightL * heightL) + heightL)) / 4;

        /*
        Loop from size 1x1 up to the smaller of the two dimensions:
        height x height OR width x width.
        So, we'll subtract off squares of size 1x1, 2x2, 3x3, ...
         */
		for (int i = 1; i <= Math.min(width, height); i++) {
			totalWithoutSquares -=
					findSquaresInRectangle(i, width, height);
		}

		return totalWithoutSquares;
	}
}
