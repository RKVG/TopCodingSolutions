/*
TopCoder
Single Round Match: 146
Division: 1
Level: 3
Points: 800
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1605
 */

import java.util.ArrayList;
import java.util.List;

public class Roundabout {

	private static final short NORTH = 0;

	private static final short EAST = 1;

	private static final short SOUTH = 2;

	private static final short WEST = 3;

	private static final char SPACE = '-';

	/*
    Return a new list composed of characters from s
     */
	private static List<Character> initializeQueue(String s) {

		List<Character> l = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			l.add(s.charAt(i));
		}

		return l;
	}

	/*
    Checks the roundabout and all queues to see if they are empty
     */
	private static boolean isCleared(Character[] c, List<Character>[] q) {

		// Check the roundabout
		for (Character aC : c) {
			if (aC != SPACE) { return false; }
		}

		// Check each queue
		for (List<Character> l : q) {
			for (Character aL : l) {
				if (aL != SPACE) { return false; }
			}
		}

		return true;
	}

	/*
    If a car is at its destination, the remove it by replacing it with a SPACE.
     */
	private static void processExit(Character[] circle) {

		if (circle[NORTH] == 'N') { circle[NORTH] = SPACE; }
		if (circle[EAST] == 'E') { circle[EAST] = SPACE; }
		if (circle[SOUTH] == 'S') { circle[SOUTH] = SPACE; }
		if (circle[WEST] == 'W') { circle[WEST] = SPACE; }
	}

	/*
    Process each of the queues to determine if their lead car may enter the
    roundabout.  The car is allowed to enter if, and only if,
    the space to their left (both in the roundabout, and the queue) are empty.
    Use the "oldCircle" since exists have already been removed.

    An entry is performed by inserting the car one space in the clock-wise
    direction from where it entered.  The next step in the algorithm is to
    advance all cars which puts it in the correct starting position.
     */
	private static void processEntry(Character[] circle,
									 Character[] oldCircle,
									 List<Character>[] q) {


        /*
        The North queue is a special case.  This car may enter if the space
        to the east is available in both the roundabout and the east queue;
        or if the east space in the roundabout is open and all queues are
        ready to enter.
         */
		if (readyToEnter(q[NORTH]) && (oldCircle[EAST] == SPACE)) {

			if (!readyToEnter(q[EAST]) ||
					(
							readyToEnter(q[EAST]) &&
									readyToEnter(q[SOUTH]) &&
									readyToEnter(q[WEST])
					)) {
				circle[EAST] = q[NORTH].remove(0);
			}
		}

		// East checks to the South.
		if (readyToEnter(q[EAST]) && (!readyToEnter(q[SOUTH])) &&
				(oldCircle[SOUTH] == SPACE)) {
			circle[SOUTH] = q[EAST].remove(0);
		}

		// South checks to the West.
		if (readyToEnter(q[SOUTH]) && (!readyToEnter(q[WEST])) &&
				(oldCircle[WEST] == SPACE)) {
			circle[WEST] = q[SOUTH].remove(0);
		}

		// West checks to the North.
		if (readyToEnter(q[WEST]) && (!readyToEnter(q[NORTH])) &&
				(oldCircle[NORTH] == SPACE)) {
			circle[NORTH] = q[WEST].remove(0);
		}
	}

	// Queue is ready to enter if there is a car at the front.
	private static boolean readyToEnter(List<Character> q) {
		return !(q.isEmpty() || (q.get(0) == SPACE));
	}

	/*
    Moves each element forward one position in the circle.  The first element
     loops around to the back.
     */
	private static void advanceCircle(Character[] c) {

		char t = c[0];
		for (int i = 0; i < c.length - 1; i++) {
			c[i] = c[i + 1];
		}
		c[c.length - 1] = t;
	}

	/*
    Removes the first SPACE found in each queue.  Effectively moves each car
    up by one if possible.
     */
	private static void advanceQueues(List<Character>[] q) {

		for (List<Character> aQ : q) {
			if (aQ.isEmpty()) { continue; }

			for (int j = 0; j < aQ.size(); j++) {
				if (aQ.get(j) == SPACE) {
					aQ.remove(j);
					break;
				}
			}
		}
	}

	// Left in for debugging.
	private static String printState(Character[] c, List<Character>[] q) {

		return "Circle:" + " North: " + c[NORTH] + " East: " + c[EAST] +
				" South: " + c[SOUTH] + " West: " + c[WEST] + "\nQueues:" +
				"\nNorth: " + printQueue(q[NORTH]) + "\nEast: " +
				printQueue(q[EAST]) + "\nSouth: " + printQueue(q[SOUTH]) +
				"\nWest: " + printQueue(q[WEST]);
	}

	// Left in for debugging.
	private static String printQueue(List<Character> l) {
		StringBuilder sb = new StringBuilder(l.size());

		for (Character aL : l) {
			sb.append(aL);
		}

		return sb.toString();
	}

	public int clearUpTime(String north, String east, String south,
						   String west) {

		// Our traffic circle
		Character[] circle = new Character[4];
		for (int i = 0; i < 4; i++) {
			circle[i] = SPACE;
		}

		// Queues waiting to get into the circle
		List[] queues = new List[4];
		queues[NORTH] = initializeQueue(north);
		queues[EAST] = initializeQueue(east);
		queues[SOUTH] = initializeQueue(south);
		queues[WEST] = initializeQueue(west);

		int time = 0;
		System.out.println(printState(circle, queues));
		System.out.println("Time: " + time);
		System.out.println("- - - - - - - - - -");

		// Continue looping until the roundabout and all queues are cleared.
		while (!isCleared(circle, queues)) {

			// Make a copy of the circle's current state
			Character[] oldCircle = new Character[circle.length];
			System.arraycopy(circle, 0, oldCircle, 0, circle.length);

			processExit(circle);
			processEntry(circle, oldCircle, queues);
			advanceCircle(circle);
			advanceQueues(queues);
			time++;

			System.out.println(printState(circle, queues));
			System.out.println("Time: " + time);
			System.out.println("- - - - - - - - - -");
		}

		return time;
	}
}
