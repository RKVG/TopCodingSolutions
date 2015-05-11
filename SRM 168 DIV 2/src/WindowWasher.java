public class WindowWasher {
	
	public int fastest(int width, int height, int[] washTimes) {


        /*
        * Holds which washer a column is assigned to.  The column
        * will be assigned to the washer that can complete it first
        * taking into consideration any previous columns that
        * the washer may have been assigned to.
        */
		int[] assignedColumns = new int[width];

        // Begin with all columns unassigned.
        for (int i = 0; i < assignedColumns.length; i++)  {
            assignedColumns[i] = -1;
        }


        for (int w = 0; w < width; w++)  {

            /*
            * Determine the time at which each washer could complete
            * the current column.
            */
            int[] completionTimes = CalcCompletionTimes(assignedColumns, w, washTimes);

            /*
            * Assign the current column to whomever could complete
            * it the earliest.
            */
            int minCompletionTime = Integer.MAX_VALUE;
            int minCompletionTimeWasher = -1;

            for (int i = 0; i < completionTimes.length; i++)  {
                if (completionTimes[i] < minCompletionTime)  {
                    minCompletionTime = completionTimes[i];
                    minCompletionTimeWasher = i;
                }
            }

            assignedColumns[w] = minCompletionTimeWasher;

        }

        /*
        * Holds the time at which each washer will be done with their
        * last assigned column.
        */
        int[] completionTimes = new int[washTimes.length];

        // Holds the maximum of the finishing times.
        int maxCompletionTime = -1;

        for (int c = 0; c < assignedColumns.length; c++)  {
            int columnAssignedTo = assignedColumns[c];

            // Here's the first (and only) time that the height comes into play.
            completionTimes[columnAssignedTo] += (washTimes[columnAssignedTo] * height);

            // See if this pushes the maxCompletionTime out.
            if (completionTimes[columnAssignedTo] > maxCompletionTime)  {
                maxCompletionTime = completionTimes[columnAssignedTo];
            }
        }

        return maxCompletionTime;

	}

    /*
    * Calculates the times at which each washer could complete the current column
    * taking into account all previous columns that have been assigned to the
    * washer.
    * Note that at this point, the height of the building does not matter.  If a
    * washer could complete a 1 story column before another washer could, then
    * they could complete an N story column before the other.  Therefore,
    * completion times assume a height of 1.
    */
    private int[] CalcCompletionTimes(int[] assignedColumns, int currentColumn, int[] washTimes)  {

        int[] completionTimes = new int[washTimes.length];


        /*
        * Completion time is at least the time it would take the washer
        * to do one window.
        */
        for (int i = 0; i < completionTimes.length; i++)  {
            completionTimes[i] = washTimes[i];
        }

        /*
        * Now, add in time for previously assigned columns.
        */
        for (int i = 0; i < currentColumn; i++)  {
            completionTimes[assignedColumns[i]] += washTimes[assignedColumns[i]];
        }

        return completionTimes;

    }
}
