public class ProgressBar {

	public static final int NUM_MARKERS = 20;
	private static final char FILL_CHAR = '#';
	private static final char EMPTY_CHAR = '.';


	public String showProgress(int[] taskTimes, int tasksCompleted) {

		int totalTime = 0;
		int completedTime = 0;

		/*
		* Count the time for all completed tasks and the
		* overall total time.
		*/
		for (int i = 0; i < taskTimes.length; i++)  {
			totalTime += taskTimes[i];

			if (tasksCompleted > i)  {
				completedTime = totalTime;
			}
		}

		int numberToFill = NUM_MARKERS * completedTime / totalTime;

		/*
		* Create our return array.  Fill in the characters that should
		* be filled in, then mark the rest as empty.
		*/
		char[] chars = new char[NUM_MARKERS];

		for (int i = 0; i < numberToFill; i++)  {
			chars[i] = FILL_CHAR;
		}

		for (int i = numberToFill; i < NUM_MARKERS; i++)  {
			chars[i] = EMPTY_CHAR;
		}

		return new String(chars);
	}
}
