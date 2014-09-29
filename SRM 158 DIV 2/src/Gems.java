public class Gems {

    private static final int MIN_GROUP_SIZE = 3;

    private int board_height;
    private int board_width;

    public int numMoves(String[] b) {

        board_height = b.length;
        board_width = b[0].length();

        /*
        * Copy the String[] into a char[][].  This makes it much easier to
        * work with, for example, when swapping positions.
        */
        char[][] board = new char[board_height][board_width];

        for (int y = 0; y < board_height; y++) {
            for (int x = 0; x < board_width; x++) {
                board[y][x] = b[y].charAt(x);
            }
        }

        int numMoves = 0;

        for (int y = 0; y < board_height; y++) {
            for (int x = 0; x < board_width; x++) {

                // If not at right edge, swap right.
                if (x < board_width - 1) {
                    swapGems(board, x, y, x + 1, y);

                    if ((getGroupSize(board, x + 1, y) >= MIN_GROUP_SIZE) ||
                            (getGroupSize(board, x,y) >= MIN_GROUP_SIZE))  {
                        numMoves++;
//                        System.out.println("Y: " + y + " X:" + x +
//                              " --> Y1:" + y + " X1:" + (x+1));

                    }

                    swapGems(board, x + 1, y, x, y);
                }

                // If not at bottom edge, swap down.
                if (y < board_height - 1) {
                    swapGems(board, x, y, x, y + 1);

                    if ((getGroupSize(board, x, y + 1) >= MIN_GROUP_SIZE) ||
                            (getGroupSize(board,x,y) >= MIN_GROUP_SIZE))  {
                        numMoves++;
//                        System.out.println("Y: " + y + " X:" + x +
//                          " --> Y1:" + (y+1) + " X1:" + x);

                    }

                    swapGems(board, x, y + 1, x, y);
                }
            }
        }

        return numMoves;
    }

    /*
    * Swaps the values at the two positions given.
    */
    private static void swapGems(char[][] board, int x, int y,
                                 int x1, int y1) {

        char t = board[y][x];
        board[y][x] = board[y1][x1];
        board[y1][x1] = t;

    }

    /*
    * Returns the larger of the horizontal or vertical group size
    * that the given position belongs to.
    */
    private int getGroupSize(char[][] board, int x, int y) {

        int groupSizeVer = 1;  // Size of Vertical group
        int groupSizeHor = 1;  // Size of Horizontal group

        int x1;
        int y1;

        char target = board[y][x];

        // Check Up
        x1 = x;
        y1 = y - 1;
        while ((y1 >= 0) && (board[y1][x1] == target)) {
            y1--;
            groupSizeVer++;
        }

        // Check Down
        x1 = x;
        y1 = y + 1;

        while ((y1 < board_height) && (board[y1][x1] == target)) {
            y1++;
            groupSizeVer++;
        }

        // Check Left
        x1 = x - 1;
        y1 = y;
        while ((x1 >= 0) && (board[y1][x1] == target)) {
            x1--;
            groupSizeHor++;
        }

        // Check Right
        x1 = x + 1;
        y1 = y;
        while ((x1 < board_width) && board[y1][x1] == target) {
            x1++;
            groupSizeHor++;
        }

        return Math.max(groupSizeVer, groupSizeHor);

    }
}
