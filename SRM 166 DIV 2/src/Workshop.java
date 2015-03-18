public class Workshop {

    public int pictureFrames(int[] pieces) {

        int count = 0;

        /*
        * Loop through all possible combinations of side1, side2, and side3
        */
        for (int side1 = 0; side1 < pieces.length - 2; side1++) {
            int s1 = pieces[side1];

            for (int side2 = side1 + 1; side2 < pieces.length - 1; side2++) {
                int s2 = pieces[side2];

                for (int side3 = side2 + 1; side3 < pieces.length; side3++) {
                    int s3 = pieces[side3];

                    // Ensure the sum of any 2 sides is greater than the 3rd.
                    if (
                            ((s1 + s2) > s3) &&
                            ((s1 + s3) > s2) &&
                            ((s2 + s3) > s1)
                        ) count++;

                }
            }
        }

        return count;
    }
}
