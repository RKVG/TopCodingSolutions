

public class Cubism {

	public int lines(String[] lattice, String color) {

		int size = lattice.length;
        char c = "black".equals(color) ? 'B' : 'W';

        /*
        * The problem becomes much easier if we transform the
        * given String[] into a 3-Dimensional array
        * of chars.
        */
		char[][][] cube = new char[size][size][size];

        for (int x = 0; x < size; x++)  {
            for (int y = 0; y < size; y++)  {
                for (int z = 0; z < size; z++)  {
                    cube[x][y][z] = lattice[x].charAt((y * size) + z);
                }
            }
        }

        int numLines = 0;

        /*
        * Count the number of lines that begin at each location.
        */
        for (int x = 0; x < size; x++)  {
            for (int y = 0; y < size; y++)  {
                for (int z = 0; z < size; z++)  {
                    numLines += countLinesStartingAt(cube, x, y, z, c);
                }
            }
        }

        /*
        * Each line will be counted twice, once starting from
        * each end point, so divide the result in half.
        */
        return numLines / 2;
	}

    /*
    * Count the number of lines starting from the given coordinate.  The line
    * must be of the given color c.
    */
    private static int countLinesStartingAt(char[][][] cube,
                                            int x, int y, int z,
                                            char c)  {

        int numLines = 0;

        /*
        * We'll generate the 27 directions that the row could stretch out in
        * by using deltaX, deltaY, and deltaZ.
        */
        for (int deltaX = -1; deltaX < 2; deltaX++)  {
            for (int deltaY = -1; deltaY < 2; deltaY++)  {
                for (int deltaZ = -1; deltaZ < 2; deltaZ++)  {
                    if (isLine(cube, x, y, z, deltaX, deltaY, deltaZ, c))  {
                        numLines++;
                    }
                }
            }
        }
        return numLines;
    }

    /*
    * Returns true if a line originating at (x,y,z) of size cube.length and moving
    * in the direction given by deltaX, deltaY, and deltaZ can be formed.
    * All position along the line must match color c.
    */
    private static boolean isLine(char[][][] cube,
                                  int x, int y, int z,
                                  int deltaX, int deltaY, int deltaZ,
                                  char c)  {

        // It's not a line if we never move from the origin.
        if ((deltaX == 0) && (deltaY == 0) && (deltaZ == 0)) return false;

        for (int i = 0; i < cube.length; i++)  {

            // Check that we stay within bounds.
            if ((x < 0) || (x >= cube.length)) return false;
            if ((y < 0) || (y >= cube.length)) return false;
            if ((z < 0) || (z >= cube.length)) return false;

            // Check the color matches.
            if (cube[x][y][z] != c) return false;

            // Move to the next location.
            x += deltaX;
            y += deltaY;
            z += deltaZ;
        }

        return true;
    }
}
