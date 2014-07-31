import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class DiskSpace {

	public int minDrives(int[] used, int[] total) {

        int capacityNeeded = 0;

        // Calculate the total amount of space needed.
        for (int u : used)  {
            capacityNeeded += u;
        }

        /*
         * Add all the hard drive capacities to a List so that we can sort it.
         * Then we'll start filling from the largest disc working back to the
         * smallest.
         */
        List<Integer> driveCapacity = new ArrayList<>();
        for (int t : total)  {
            driveCapacity.add(t);
        }

        Collections.sort(driveCapacity);

        // Start with the largest drive.
        int i = driveCapacity.size() - 1;

        // The number of drives needed.
        int count = 0;

        while (capacityNeeded > 0)  {
            count++;

            // Subtract the current drive's capacity from the amount needed.
            capacityNeeded -= driveCapacity.get(i--);
        }

        return count;

	}
}
