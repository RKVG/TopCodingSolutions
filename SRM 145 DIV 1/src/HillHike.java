/*
TopCoder
Single Round Match: 145
Division: 1
Level: 3
Points: 1000
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1158
 */

public class HillHike {

	private int maxDistance;

	private int maxHeight;

	private int[] landmarks;

	private PathCache pathCache;

	public long numPaths(int distance, int maxHeight, int[] landmarks) {

		this.maxDistance = distance;
		this.maxHeight = maxHeight;
		this.landmarks = landmarks;

		// Initialize a new PathCache to store values once they've been seen.
		pathCache = new PathCache(distance, maxHeight, landmarks.length);

        /*
        The first move must be to distance=1, height=1 so we might as well
        start from there.
         */
		return getPaths(0, 0, 0, false);
	}

	/*
    Calculates the number of paths starting from a point at distance,height.
    The number of paths also depends on how many landMarks haave been seen
    and whether or not the maximum height has been reached yet.
     */
	private long getPaths(int distance, int height, int landMarksSeen,
						  boolean maxHeightReached) {

		// Check for going beyond height or distance
		if (distance > maxDistance) { return 0; }
		if ((height > maxHeight) || (height < 0)) { return 0; }

		// Can't climb faster or descend faster than 1:1
		if (height > distance) { return 0; }

		// Won't be able to get down in time
		if (height > (maxDistance - distance)) { return 0; }

		// Can only have a height of 0 at the start and finish
		if ((height == 0) && (distance != 0) && (distance != maxDistance)) {
			return 0;
		}

        /*
        If we've seen these values before, we'll use that instead of
        recalculating.
         */
		long numPaths = pathCache.getPath(distance, height, landMarksSeen,
				maxHeightReached);

		if (numPaths >= 0) { return numPaths; }

        /*
        If we've reached maxDistance, and we've:
            Seen the maximum height
            Seen all of the landmarks
            and are now back down to height == 0
        Then we have a valid path, return 1
        Otherwise return 0
         */
		if (distance == maxDistance) {
			return (maxHeightReached && (height == 0) &&
					(landMarksSeen == landmarks.length)) ? 1 : 0;
		}

		// True if we've seen maxHeight in the past, or are at it now.
		boolean seenMaxHeight = maxHeightReached || (height == maxHeight);

		int newLandMarksSeen = landMarksSeen;

        /*
        If we haven't seen all the landmarks yet, and the current height
        equals the height of the next landMark, then increment the number
        of landMarks seen.
         */
		if (landMarksSeen < landmarks.length) {
			if (landmarks[landMarksSeen] == height) {
				newLandMarksSeen++;
			}
		}

		// Check how many paths if we go up from here.
		numPaths = getPaths(distance + 1, height + 1, newLandMarksSeen,
				seenMaxHeight);

		// Add how many paths if we stay level from here.
		numPaths += getPaths(distance + 1, height, newLandMarksSeen,
				seenMaxHeight);

		// Add how many paths if we descend from here.
		numPaths += getPaths(distance + 1, height - 1, newLandMarksSeen,
				seenMaxHeight);

		// Store this value so we don't have to recalculate it.
		pathCache.storePath(distance, height, landMarksSeen,
				seenMaxHeight, numPaths);

		return numPaths;
	}

	/*
      Stores the paths that have already been calculated,
      so that we don't have to calculate them again.
    */
	class PathCache {

		/*
        The number of paths from a given point to the finish is determined by
         the distance to the point, it's height, how many landMarks have been
          seen up to that point, and if the highest elevations has been
          reached yet.  This multi-dimensions array stores the number of
          paths given each of these combinations.
         */
		private final long[][][][] pathsFound;

		PathCache(int maxDistance, int maxHeight, int numLandMarks) {

			pathsFound = new long[maxDistance + 1][maxHeight + 1]
					[numLandMarks + 1][2];

			// Initialize all values in pathsFound to -1
			for (int i = 0; i <= maxDistance; i++) {
				for (int j = 0; j <= maxHeight; j++) {
					for (int k = 0; k <= numLandMarks; k++) {
						for (int m = 0; m < 2; m++) {
							pathsFound[i][j][k][m] = -1;
						}
					}
				}
			}
		}

		/*
        Stores the number of paths for the given parameters.
         */
		void storePath(int distance, int height, int landMarksSeen,
					   boolean maxHeightReached, long numPaths) {

			pathsFound[distance][height][landMarksSeen]
					[maxHeightReached ? 1 : 0] = numPaths;
		}

		/*
       Returns the number of paths given the input conditions, or
       -1 if they haven't been calculated yet.
        */
		long getPath(int distance, int height, int landMarksSeen,
					 boolean maxHeightReached) {

			return pathsFound[distance][height][landMarksSeen]
					[maxHeightReached ? 1 : 0];
		}
	}
}
