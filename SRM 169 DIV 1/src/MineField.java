import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class MineField {

	private static final int SIZE = 9;
	private static final char MINE_CHAR = 'M';

	char[][] mineField = new char[SIZE][SIZE];

	public String[] getMineField(String mineLocations) {

		// Initialize the mine Field
		for (int row = 0; row < SIZE; row++)  {
			for (int col = 0; col < SIZE; col++)  {
				mineField[row][col] = '0';
			}
		}

		// Converts all parenthesis and commas to spaces.
		String input = mineLocations
						.replaceAll("\\(", " ")
						.replaceAll("\\)", " ")
						.replaceAll(",", " ");

		// A scanner that uses spaces as the delimiter
		Scanner sc = new Scanner(input);
		sc.useDelimiter("\\s+");

		// Read all the coordinates and add the mines.
		while (sc.hasNextInt())  {
			int row = sc.nextInt();
			int col = sc.nextInt();
			addMine(row,col);
		}

		// Create the return value.
		String[] result = new String[SIZE];

		for (int i = 0; i < SIZE; i++)  {
			result[i] = new String(mineField[i]);
		}

		return result;
	}

	private void addMine(int row, int col)  {

		mineField[row][col] = MINE_CHAR;

		/*
		* Increment the value in all surrounding squares
		* checking to ensure that we stay within the bounds
		* of the board, and that the other square is not
		* already marked as a mine.
		*/
		for (int r = row - 1; r <= row + 1; r++)  {
			for (int c = col - 1; c <= col + 1; c++)  {

				if ((r >= 0) && (r < SIZE) &&
						(c >= 0) && (c < SIZE) &&
						(mineField[r][c] != MINE_CHAR))  {

					// Increase the value of the neighbor.
					mineField[r][c]++;
				}
			}
		}

	}
}
