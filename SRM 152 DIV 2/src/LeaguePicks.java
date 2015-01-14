/*
TopCoder
Single Round Match: 152
Division: 2 / 1
Level: 2 / 1
Points: 500 / 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1716
 */

import java.util.ArrayList;
import java.util.List;

public class LeaguePicks {

	public int[] returnPicks(int position, int friends, int picks) {

		// Uses a re-sizeable list instead of calculating the size if the int[]
		List<Integer> pickList = new ArrayList<>();

		// Your first pick is just the position you're in.
		int nextPick = position;

        /*
         Keeps track of whether were working from the beginning of the list
         toward the end.  Or if we've reached the end,
         and are working back toward the front.
         */
		boolean startToEnd = true;

		// Continue until we've run out of picks.
		while (nextPick <= picks) {

			pickList.add(nextPick);

			if (startToEnd) {
				nextPick += (2 * (friends - position) + 1);
			} else {
				nextPick += (2 * position) - 1;
			}

			startToEnd = !startToEnd; // Switch direction.
		}

		// Convert the ArrayList into an int[] and return it.
		int[] returnList = new int[pickList.size()];

		for (int i = 0; i < pickList.size(); i++) {
			returnList[i] = pickList.get(i);
		}

		return returnList;
	}
}
