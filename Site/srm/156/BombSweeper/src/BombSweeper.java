/*
TopCoder
Single Round Match: 156
Division: 2 / 1
Level: 2 / 1
Points: 600 / 300
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1778
 */

public class BombSweeper {

    /*
     * Converts the array of Strings into a 2-Dimensional array of
     * characters.  This will simplify working with the board.
     */
    private static char[][] generateBoard(String[] strs) {

        char[][] charArray = new char[strs.length][strs[0].length()];

        for (int row = 0; row < strs.length; row++) {
            for (int col = 0; col < strs[0].length(); col++) {
                charArray[row][col] = strs[row].charAt(col);
            }
        }

        return charArray;
    }

    /*
     * Checks each of the 8 surrounding squares looking for bombs.  If a bomb
     * is found, returns true - otherwise returns false
     */
    private static boolean hasBombNeighbor(char[][] field, int row, int col) {

        // Check row above
        if (row > 0) {

            // Above and to the left
            if (col > 0) {
                if (field[row - 1][col - 1] == 'B') { return true; }
            }

            // Directly above
            if (field[row - 1][col] == 'B') { return true; }

            // Above and to the right
            if (col < field[0].length - 1) {
                if (field[row - 1][col + 1] == 'B') { return true; }
            }
        }

        // Same row - To the left
        if (col > 0) {
            if (field[row][col - 1] == 'B') { return true; }
        }

        // Same row - To the right
        if (col < field[0].length - 1) {
            if (field[row][col + 1] == 'B') { return true; }
        }

        // Check row below
        if (row < field.length - 1) {

            // Below and to the left
            if (col > 0) {
                if (field[row + 1][col - 1] == 'B') { return true; }
            }

            // Directly below
            if (field[row + 1][col] == 'B') { return true; }

            // Below and to the right
            if (col < field[0].length - 1) {
                if (field[row + 1][col + 1] == 'B') { return true; }
            }
        }

        return false;
    }

    public double winPercentage(String[] board) {

        int numBombs = 0;
        int numWins = 0;

        char[][] mineField = generateBoard(board);

        /*
         * Loop through each position of the board.  For each position,
         * determine if it is a bomb, or has any neighbors that are bombs.
         */
        for (int row = 0; row < mineField.length; row++) {
            for (int col = 0; col < mineField[0].length; col++) {
                if (mineField[row][col] == 'B') {
                    numBombs++;
                } else if (hasBombNeighbor(mineField, row, col)) {
                    // doNothing
                } else {
                    numWins++;
                }
            }
        }

        // This equation is given in the problem statement.
        return ((double) numWins / (double) (numWins + numBombs)) * 100.0;
    }
}
