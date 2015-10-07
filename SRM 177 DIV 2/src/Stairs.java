public class Stairs {

    public int designs(int maxHeight, int minWidth, int totalHeight, int totalWidth) {

        int count = 0;

        for (int riserHeight = 1; (riserHeight <= maxHeight); riserHeight++) {
            if ((totalHeight % riserHeight) != 0) continue;

            int numTreads = (totalHeight / riserHeight) - 1;

            if ((numTreads == 0) ||
                    ((totalWidth % numTreads) != 0) ||
                    ((totalWidth / numTreads) < minWidth)) continue;
            count++;
        }

        return count;
    }
}
