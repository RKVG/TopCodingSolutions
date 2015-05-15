

public class LevelUp {
	
	public int toNextLevel(int[] expNeeded, int received) {

		int i = 0;

        while (expNeeded[i] <= received) i++;

        return (expNeeded[i] - received);

	}
}
