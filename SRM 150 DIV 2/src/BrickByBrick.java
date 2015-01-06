/*
TopCoder
Single Round Match: 150
Division: 2
Level: 3
Points: 1100
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1751
 */

import java.util.HashSet;
import java.util.Set;

public class BrickByBrick {

	/*
     * Prints out the current state of the board and ball.  The ball is
     * represented as an 'o'.
     */
	private static void printState(int[][] board, Ball ball) {

		System.out.println(ball.toString());

		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[0].length; x++) {
				if ((y == ball.y) && (x == ball.x)) {
					System.out.print('o');
				} else if (board[y][x] < 0) {
					System.out.print('#');
				} else {
					System.out.print(board[y][x]);
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public int timeToClear(String[] map) {

		int numBricks = 0;

		int sizeX = (map[0].length() * 2) + 1;
		int sizeY = (map.length * 2) + 1;

		int[][] board = new int[sizeY][sizeX];

        /*
         * Create an indestructible boarder around the board.  Indestructible
         * bricks are represented by a -1.
         */

		// Top and bottom borders
		for (int x = 0; x < sizeX; x++) {
			board[0][x] = -1;
			board[sizeY - 1][x] = -1;
		}

		// Right and left borders
		for (int y = 0; y < sizeY; y++) {
			board[y][0] = -1;
			board[y][sizeX - 1] = -1;
		}

		// Load the board.
		int y = 1;
		for (String s : map) {
			int x = 1;
			for (char c : s.toCharArray()) {
				switch (c) {
					case '.':
						break;

					case 'B':
						numBricks++;

                        /*
                         * Increase the count on all it's edges.  If the edge
                         * is shared with an indestructible neighbor,
                         * leave it alone
                         */
						if (board[y - 1][x] >= 0) {
							board[y - 1][x] += 1;
						}
						if (board[y + 1][x] >= 0) {
							board[y + 1][x] += 1;
						}
						if (board[y][x - 1] >= 0) {
							board[y][x - 1] += 1;
						}
						if (board[y][x + 1] >= 0) {
							board[y][x + 1] += 1;
						}
						break;

					// Set the edges for an indestructible brick.
					case '#':
						board[y - 1][x] = -1;
						board[y + 1][x] = -1;
						board[y][x - 1] = -1;
						board[y][x + 1] = -1;
				}
				x += 2;
			}
			y += 2;
		}

		Ball ball = new Ball();

        /*
         * Holds a set of integers representing the state of the ball.  If we
         * see the same state again, then declare an infinite loop.
         * The set is cleared whenever a brick is broken.
         */
		final Set<Integer> loopDetector = new HashSet<>();

		int moves = 0;

		// Quit if we've seen this state before.
		while (!loopDetector.contains(ball.getState())) {

			moves++;

			loopDetector.add(ball.getState());

			// May not pass timing tests if this is enabled.
//            printState(board, ball);

			ball.move();

			// Space is empty
			if (board[ball.y][ball.x] == 0) {
				continue;

				// An indestructible brick, just change directions.
			} else if (board[ball.y][ball.x] < 0) {
				ball.changeDir();

				// Found a brick to break
			} else {

				numBricks--;
				if (numBricks == 0) { return moves; }

				loopDetector.clear();  // Reset the infinite loop detector.

				int brokenBrick_x;
				int brokenBrick_y;

                /*
                 * Determine if we hit a side of the brick, or the top/bottom.
                 * Use this to get the position of the middle of the brick.
                 */
				if (ball.isSide) {
					brokenBrick_x = ball.x + ball.deltaX;
					brokenBrick_y = ball.y;
				} else {
					brokenBrick_x = ball.x;
					brokenBrick_y = ball.y + ball.deltaY;
				}

                /*
                 * Decrement the count for all the edges of this brick,
                 * unless the edge is shared with an indestructible brick.
                 */
				if (board[brokenBrick_y][brokenBrick_x + 1] > 0) {
					board[brokenBrick_y][brokenBrick_x + 1] -= 1;
				}
				if (board[brokenBrick_y][brokenBrick_x - 1] > 0) {
					board[brokenBrick_y][brokenBrick_x - 1] -= 1;
				}
				if (board[brokenBrick_y - 1][brokenBrick_x] > 0) {
					board[brokenBrick_y - 1][brokenBrick_x] -= 1;
				}
				if (board[brokenBrick_y + 1][brokenBrick_x] > 0) {
					board[brokenBrick_y + 1][brokenBrick_x] -= 1;
				}

				ball.changeDir();
			}
		}

		return -1;  // Infinit loop detected.
	}

	private class Ball {

		int x;
		int y;
		short deltaX;
		short deltaY;

		/*
         * On every move, the ball alternates between passing through
         * aTop/Bottom, or a Side
         */
		boolean isSide = false;

		// Ball always starts in Top Left square going down and to the right.
		Ball() {
			this.x = 1;
			this.y = 0;
			this.deltaX = 1;
			this.deltaY = 1;
		}

		void move() {
			x += deltaX;
			y += deltaY;
			isSide = !isSide;
		}

		void changeDir() {
			if (isSide) {
				deltaX *= -1;
			} else {
				deltaY *= -1;
			}
		}

		/*
         * Returns a unique int based on the position and movement of the
         * ball.  This will be used to determine if we've entered an infinite
         * loop.  If no bricks have been broken since the last time this
         * state was seen, then it's time to quit.
         */
		int getState() {
			int state = 1;
			state = (state * 100) + x;
			state = (state * 100) + y;
			state = (state * 10) + deltaX + 1;
			state = (state * 10) + deltaY + 1;
			return state;
		}

		public String toString() {
			return "X=" + x + " Y=" + y + " deltaX=" + deltaX + " deltaY=" +
					deltaY +
					" isSide=" + isSide + " state=" + getState();
		}
	}
}
