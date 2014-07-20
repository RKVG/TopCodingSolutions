/*
TopCoder
Single Round Match: 145
Division: 2
Level: 3
Points: 1100
Description: http://community.topcoder.com/stat?c=problem_statement&amp;pm=1130
 */

public class VendingMachine {

    // Number of minutes before the machine rotates to the most expensive
    // column.
    private static final int TIME_TO_RESET = 5;

    // The number of moves that the machine has made
    private int moves = 0;

    // The column currently facing forward.
    private int currentCol = 0;

    private int numColumns;

    private int numShelves;

    // The vending machine is modeled as 2 dimensional array [shelves][columns]
    private int[][] machine;

    private int timeOfLastPurchase = 0;

    /*
    Simulate to use of the vending machines motor.
    Prices is an array of Strings, each String is a space separate list of
    integers.  Each array item represents a shelf, while each item in the
    String represents the price of an item at that column.purchases are in
    the format of shelf,column:time
     */
    public int motorUse(String[] prices, String[] purchases) {

        // Determine the number of shelves and columns.
        numShelves = prices.length;
        numColumns = prices[0].split(" ").length;

        machine = new int[numShelves][numColumns];

        // Initialize the machine
        for (int shelf = 0; shelf < numShelves; shelf++) {

            // split the String by spaces into an array of prices.
            String[] itemArray = prices[shelf].split(" ");
            for (int column = 0; column < numColumns; column++) {
                machine[shelf][column] = Integer.parseInt(itemArray[column]);
            }
        }

        // Start with the most expensive column facing forward.
        rotateToMostExpensive();

        /*
        We'll throw an exception if the user attempts to buy an item that has
         already been bought.
        Catch the exception, and return -1.
         */
        try {

            // Process each of the purchases.
            for (String p : purchases) {
                processPurchase(p);
            }

            // Return to the most expensive column before finishing.
            rotateToMostExpensive();
        } catch (IllegalStateException e) {
            return -1;
        }

        return moves;
    }

    /*
    Calculates the most expensive column in the vending machine, and then
    rotates to that column.
     */
    private void rotateToMostExpensive() {
        int col = getMostExpensiveCol();
        rotateTo(col);
    }

    /*
    Calculates the most expensive column in the vending machine.
     */
    private int getMostExpensiveCol() {

        // The value of the most expensive column we've seen so far.
        int mostExpensiveColVal = 0;

        // The index of the most expensive column seen so far.
        int mostExpensiveColNum = 0;

        for (int column = 0; column < numColumns; column++) {

            int valOfColumn = 0;
            for (int shelf = 0; shelf < numShelves; shelf++) {
                valOfColumn += machine[shelf][column];
            }
            if (valOfColumn > mostExpensiveColVal) {
                mostExpensiveColNum = column;
                mostExpensiveColVal = valOfColumn;
            }
        }

        return mostExpensiveColNum;
    }

    /*
    Rotates the vending machine to the given column.
    Increments the number of motor moves required to get there.
    The move may be either clock-wise or counter-clockwise.
     */
    private void rotateTo(int dest) {

        /*
        Determine how many moves it will take if we rotate left,
        then how many moves it will take to rotate right.
         */
        int rotL = Math.abs(dest - currentCol);
        int rotR = numColumns - rotL;

        // Increase the number of moves the motor makes by the smaller of the
        // two.
        moves += (rotL < rotR) ? rotL : rotR;

        // Set the current column to the destination.
        currentCol = dest;
    }

    private void processPurchase(String purchase) {

        /*
        Parse the purchase string by breaking it into its shelf, column,
        and time components.
         */
        String[] purchaseArr = purchase.split("(,)|(:)");  // A handy regex.
        int shelf = Integer.parseInt(purchaseArr[0]);
        int column = Integer.parseInt(purchaseArr[1]);
        int time = Integer.parseInt(purchaseArr[2]);

        // If more than 5 minutes have elapses, rotate to the most expensive
        // column first.
        if ((time - timeOfLastPurchase) >= TIME_TO_RESET) {
            rotateToMostExpensive();
        }

        // Rotate to the purchase column.
        rotateTo(column);

        // Probably not the right type of exception to throw, but it'll work.
        if (machine[shelf][column] == 0) {
            throw new IllegalStateException("Item Already Purchased! Shelf="
                    + shelf + " Column=" + column);
        }

        // Mark the slot as gone.
        machine[shelf][column] = 0;

        // Update the time of last purchase.
        timeOfLastPurchase = time;
    }
}
