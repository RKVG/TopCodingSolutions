public class Swimmers {
	
	public int[] getSwimTimes(int[] distances, int[] speeds, int current) {

        int[] times = new int[distances.length];

        for (int i = 0; i < distances.length; i++)  {
            times[i] = getTime(distances[i], speeds[i], current);
        }

        return times;
	}

    private int getTime(int distance, int speed, int current)  {

        if (distance == 0) return 0;

        if (speed <= current) return -1;

        float time = (float) distance / (float)(speed + current);

        time += (float) distance / (float)(speed - current);

        return (int) time;

    }
}
