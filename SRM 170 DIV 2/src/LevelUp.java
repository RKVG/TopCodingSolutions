public class LevelUp {
	
	public int toNextLevel(int[] expNeeded, int received) {

		int i = 0;

        /*
        * Find the first expNeeded element that is greater
        * than received.
        */
        while (expNeeded[i] <= received) i++;

        /*
        * Return the difference between the next level, and
        * the amount received.
        */
        return (expNeeded[i] - received);

	}
}
