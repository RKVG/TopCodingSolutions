public class FairWorkload {
	
	public int getMostWork(int[] folders, int workers) {

        /*
        * Stores the best time that we can complete a given
        * number of folders with a given number workers.
        */
		int[][] times = new int[workers][folders.length];

        /*
        * With just 1 worker, the completion time
        * of folder f will be the sum of the times
        * it takes to process each folder up to and
        * including f.
        */
        for (int f = 0; f < folders.length; f++)  {
            times[0][f] = sumSections(0, f + 1, folders);
        }

        for (int w = 1; w < workers; w++)  {
            for (int f = 0; f < folders.length; f++)  {

                // Cannot have less folders than workers
                if (f < w)  {
                    times[w][f] = -1;

                } else  {

                    int minCompletionTime = Integer.MAX_VALUE;

                    /*
                    * Try all combinations of splitting the
                    * folders between previous workers and
                    * the current worker.  d - marks
                    * the division point, where the current
                    * worker begins.
                    */
                    for (int d = w; d <= f; d++)  {

                        int completionTime = Math.max(
                                times[w-1][d-1],
                                sumSections(d, f + 1, folders));

                        minCompletionTime = Math.min(
                                minCompletionTime,
                                completionTime);
                    }

                    times[w][f] = minCompletionTime;
                }
            }
        }

        return times[workers - 1][folders.length - 1];
	}

    /*
    * Return the sum of the elements in the nums array
    * starting at s and stopping just before e.
    */
    private int sumSections(int s, int e, int[] nums)  {
        int sum = 0;

        for (int x = s; x < e; x++)  {
            sum += nums[x];
        }

        return sum;
    }

}
