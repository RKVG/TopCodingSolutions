public class TaroGrid {
	
	public int getNumber(String[] grid) {

        // Get the dimensions of the grid
        int numRows = grid.length;
        int numCols = grid[0].length();

        // Set to a small number to start.
        int maxVal = Integer.MIN_VALUE;

        // Step through each column.
        for (int col=0; col<numCols; col++)  {

            int count = 0;

            // Take a peek at the first color in the column
            char currentColor = grid[0].charAt(col);

            for (int row = 0; row < numRows; row++)  {

                if (grid[row].charAt(col) == currentColor)  {
                    count++;

                } else  {

                    // Start a new color
                    currentColor = grid[row].charAt(col);
                    maxVal = Math.max(maxVal, count);
                    count = 1;
                }
            }

            // Don't forget.  The longest streak could be the bottom one.
            maxVal = Math.max(maxVal, count);
        }

        return maxVal;
	}
}
