public class Target {

    private static final char OFF = ' ';
    private static final char ON = '#';

    public String[] draw(int n) {

        // Create a char[][] and initialize it.
        char[][] target = new char[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                target[y][x] = OFF;
            }
        }

        // Start the recursive calls.
        drawSquare(target, 0);

        // Convert the char[][] into a String[] and return it.
        String[] result = new String[n];

        for (int y = 0; y < n; y++) {
            result[y] = new String(target[y]);
        }

        return result;
    }

    private void drawSquare(char[][] target, int topOrLeft) {

        int bottomOrRight = target.length - topOrLeft - 1;

        if (topOrLeft < bottomOrRight) {
            drawSquare(target, topOrLeft + 2);
        }

        for (int i = topOrLeft; i <= bottomOrRight; i++) {
            target[topOrLeft][i] = ON;      // Top Row
            target[bottomOrRight][i] = ON;  // Bottom Row
            target[i][topOrLeft] = ON;      // Left Edge
            target[i][bottomOrRight] = ON;  // Right Edge
        }

    }
}
