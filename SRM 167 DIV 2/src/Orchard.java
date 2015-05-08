public class Orchard {

    int size;
    int[][] distances;

    public int[] nextTree(String[] orchard) {

        size = orchard.length;

        distances = new int[size][size];

        /*
        * Mark distances from the edges.
        * This create concentric squares with the distance
        * at the edges = 1, and the value increasing by
        * 1 as the squares move inward.
        */
        for (int i = 0; i < (size + 1) / 2; i++) {
            for (int j = i; j < (size - i); j++) {
                distances[i][j] = i + 1;                // Top Row
                distances[size - 1 - i][j] = i + 1;     // Bottom Row
                distances[j][i] = i + 1;                // Left Column
                distances[j][size - 1 - i] = i + 1;     // Right Column
            }
        }

        /*
        * Add trees into the mix
        * Updates the values in the distance matrix.
        */
        for (int row = 0; row < size; row++)  {
            for (int col = 0; col < size; col++)  {
                if ('T' == orchard[row].charAt(col))  {
                    placeTree(row,col);
                }
            }
        }

        /*
        * Find and return the greatest distance
        */
        int maxDistance = 0;
        int[] retValues = new int[] {1, 1};

        for (int y = 0; y < size; y++)  {
            for (int x = 0; x < size; x++)  {
                if (distances[y][x] > maxDistance)  {
                    maxDistance = distances[y][x];
                    retValues[0] = y + 1;
                    retValues[1] = x + 1;
                }
            }
        }

        return retValues;
    }


    /*
    * Places a tree at the given coordinate.  Then works outward from the
    * tree's location reducing the distances of it's neighboring squares.
    * Here's where all the work of updating the distances matrix is done.
    */
    private void placeTree(int row, int col)  {

        // Work the area above the tree.
        for (int dy = 0; row - dy >= 0; dy++)  {

            // Reduce neighbors above and to the left.
            for (int dx = 0; col - dx >= 0; dx++)  {
                distances[row - dy][col - dx] = Math.min(distances[row - dy][col - dx], dx + dy);
            }

            // Reduce neighbors above and to the right.
            for (int dx = 0; col + dx < size; dx++)  {
                distances[row - dy][col + dx] = Math.min(distances[row - dy][col +dx], dx + dy);
            }
        }

        // Works the area below the tree
        for (int dy = 0; row + dy < size; dy++)  {

            // Reduce neighbors below and to the left.
            for (int dx = 0; col - dx >= 0; dx++)  {
                distances[row + dy][col - dx] = Math.min(distances[row + dy][col - dx], dx + dy);
            }

            // Reduce neighbors below and to the right.
            for (int dx = 0; col + dx < size; dx++)  {
                distances[row + dy][col + dx] = Math.min(distances[row + dy][col +dx], dx + dy);
            }
        }
    }

}
