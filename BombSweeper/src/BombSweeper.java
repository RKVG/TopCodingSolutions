public class BombSweeper {

    private static char[][] generateBoard(String[] strs) {

        char[][] charArray = new char[strs.length][strs[0].length()];

        for (int row = 0; row < strs.length; row++) {
            for (int col = 0; col < strs[0].length(); col++) {
                charArray[row][col] = strs[row].charAt(col);
            }
        }

        return charArray;
    }

    private static boolean hasBombNeighbor(char[][] field, int row, int col) {

        // Check row above
        if (row > 0) {
            if (col != 0) {
                if (field[row - 1][col - 1] == 'B') { return true; }
            }

            if (field[row - 1][col] == 'B') { return true; }

            if (col < field[0].length - 1) {
                if (field[row - 1][col + 1] == 'B') { return true; }
            }
        }

        // Check current row
        if (col > 0) {
            if (field[row][col - 1] == 'B') { return true; }
        }

        if (field[row][col] == 'B') { return true; }

        if (col < field[0].length - 1) {
            if (field[row][col + 1] == 'B') { return true; }
        }

        // Check row below
        if (row < field.length - 1) {
            if (col > 0) {
                if (field[row + 1][col - 1] == 'B') { return true; }
            }

            if (field[row + 1][col] == 'B') { return true; }

            if (col < field[0].length - 1) {
                if (field[row + 1][col + 1] == 'B') { return true; }
            }
        }

        return false;

    }

    public double winPercentage(String[] board) {

        int numBombs = 0;
        int numWins = 0;

        char[][] field = generateBoard(board);

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[0].length; col++) {
                if (field[row][col] == 'B') {
                    numBombs++;
                } else if (hasBombNeighbor(field, row, col)) {
                    // doNothing
                } else {
                    numWins++;
                }
            }
        }

        return ((double) numWins / (double) (numWins + numBombs)) * 100.0;

    }
}
