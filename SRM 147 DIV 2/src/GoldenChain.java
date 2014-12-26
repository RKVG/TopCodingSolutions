/*
TopCoder
Single Round Match: 147
Division: 2
Level: 3
Points: 950
Description: http://community.topcoder.com/stat?c=problem_statement&amp;pm=1355
 */

public class GoldenChain {

	/*
    Loops through the sections and returns the index of the smallest
    non-zero entry.
     */
	private static int getSmallestSection(int[] sections) {

		int minVal = Integer.MAX_VALUE;
		int minIdx = -1;

		for (int i = 0; i < sections.length; i++) {
			if ((sections[i] > 0) && (sections[i] < minVal)) {
				minVal = sections[i];
				minIdx = i;
			}
		}

		return minIdx;
	}

	/*
    Counts up all of the sections of non-zero length
     */
	private static int getNumSections(int[] sections) {

		int c = 0;

		for (int section : sections) {
			if (section > 0) {
				c++;
			}
		}

		return c;
	}

	/*
    Combines the two largest sections. Loops through all of the sections
    and notes the two largest. Then, increments the length of the largest by
     the length of the second larges. Finally, sets the length of the second
     largest to 0.
     */
	private static void combineLargestSections(int[] sections) {

		// Sizes of the two largest sections seen thus far.
		int large1 = 0;
		int large2 = 0;

		// Indexes of the two largest sections seen thus far.
		int large1Idx = 0;
		int large2Idx = 0;

     /*
     When we find a section larger that the current largest, we push the
     current largest size and index down into the second largest.
      */
		for (int i = 0; i < sections.length; i++) {
			if (sections[i] >= large1) {
				large2 = large1;
				large2Idx = large1Idx;
				large1 = sections[i];
				large1Idx = i;
			} else if (sections[i] > large2) {
				large2 = sections[i];
				large2Idx = i;
			}
		}

		// Combine the two largest into one, and set the other to zero.
		sections[large1Idx] += sections[large2Idx];
		sections[large2Idx] = 0;
	}

	public int minCuts(int[] sections) {

		int numCuts = 0;

		// Continue looping so long as there are more than 1 sections.
		while (getNumSections(sections) >= 1) {

      /*
      If there is just one section, then cut the end,
      and attach it to the beginning.
       */
			if (getNumSections(sections) == 1) {
				return numCuts + 1;
			}

      /*
      Take the smallest section and use it's links to combine the
      larger sections.
       */
			int s = getSmallestSection(sections);

			while (sections[s] > 0) {

        /*
        Check to see if the links from the smallest chain can be used
         to join all remaining sections.
         */
				if (sections[s] == getNumSections(sections) - 1) {
					numCuts += sections[s];
					return numCuts;
				} else if (sections[s] >= getNumSections(sections)) {
					numCuts += getNumSections(sections);
					return numCuts;
				}

        /*
        If not, remove one link from the smallest section,
        and use it to join the two largest sections.
         */
				combineLargestSections(sections);
				numCuts++;
				sections[s] = sections[s] - 1;
			}
		}

		return -1;
	}
}
