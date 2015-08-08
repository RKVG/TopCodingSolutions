public class CrossWord {

    public int countWords(String[] board, int size) {

        int total = 0;

        /*
        * Sum up the number of horizontal slots in each
        * of the rows in the board.
        */
        for (String s : board) {
            total += countHorizontalSlots(s, size);
        }

        return total;
    }

    /*
    * Count the number of horizontal slots in a
    * single row of the board.
    */
    private static int countHorizontalSlots(String s, int size) {

        // Number of horizontal slots found.
        int num = 0;

        // Number of continuous spaces found.
        int spaces = 0;

        // Loop through each character in the given string.
        for (int i = 0; i < s.length(); i++) {

            /*
            * An 'X' marks the end of a slot.  So when an
            * 'X' is encountered, if the number of spaces
            * matches the size we're looking for, then
            * increase the count.
            * Set spaces to 0 whenever an 'X' is found.
            */
            if (s.charAt(i) == 'X') {
                if (spaces == size) {
                    num++;
                }
                spaces = 0;

            } else {

                /*
                * If it's not an 'X', then increment the number
                * of open spaces found.
                */
                spaces++;
            }

        }

        /*
        * This condition is met when the slot leads up to the
        * right edge of the board.
        */
        if (spaces == size) {
            num++;
        }

        return num;
    }
}
