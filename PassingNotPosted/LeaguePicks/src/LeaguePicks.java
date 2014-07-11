public class LeaguePicks {

    private static int getNextPick(int numPicks, int currentPick, int position,
                                   int friends) {

        if (currentPick == 0) { return position; }

        if ((numPicks % 2) == 0) {
            return currentPick + (2 * (position - 1)) + 1;
        } else {
            return currentPick + (2 * (friends - position)) + 1;
        }
    }

    public int[] returnPicks(int position, int friends, int picks) {

        // First figure out the size of the return array.
        int i = 0;
        int currentPick = getNextPick(i, 0, position, friends);

        while (currentPick <= picks) {
            i++;
            currentPick = getNextPick(i, currentPick, position, friends);
        }

        int[] myPicks = new int[i];
        i = 0;
        currentPick = getNextPick(i, 0, position, friends);

        while (currentPick <= picks) {
            myPicks[i++] = currentPick;
            currentPick = getNextPick(i, currentPick, position, friends);
        }

        return myPicks;
    }
}
