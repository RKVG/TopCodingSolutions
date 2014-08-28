import java.util.Collections;
import java.util.PriorityQueue;

/*
* An immutable class to represent an hour class.
*/
class GlassTimer {

    private final int topBulb;
    private final int bottomBulb;

    GlassTimer(int top, int bottom) {
        this.topBulb = top;
        this.bottomBulb = bottom;
    }

    // Returns a new copy of this oject
    GlassTimer copy() {
        return new GlassTimer(this.topBulb, this.bottomBulb);
    }

    // Returns a new inverted copy of the timer.
    public GlassTimer flip() {
        return new GlassTimer(this.bottomBulb, this.topBulb);
    }

    // Returns how much sand is in the topBulb.
    public int getTimeRemaining() {
        return this.topBulb;
    }

    /*
    * Runs i amount of time out of the top bulb, and adds it to the bottom.
    * If i > topBulb, we'll stop when the top runs out.
    */
    public GlassTimer runFor(int i) {

        if (i > topBulb) {
            i = topBulb;
        }

        return new GlassTimer(topBulb - i, bottomBulb + i);
    }
}

public class HourGlass {

    // The number of items we'll return in the result.
    public static final int NUM_TIMES_TO_RETURN = 10;

    /*
    * A PriorityQueue to store the times we've calculated so far.  By passing
    * Collections.reverseOrder, the PriorityQueue will always have the largest
    * element in the first position.
    */
    PriorityQueue<Integer> maxPQ =
            new PriorityQueue<Integer>(NUM_TIMES_TO_RETURN,
                    Collections.reverseOrder());

    // The method called by the TopCoder tests.
    public int[] measurable(int glass1, int glass2) {

        flipHourGlasses(new GlassTimer(glass1, 0), new GlassTimer(glass2, 0), 0);

        /*
        * Upon returning from flipHourGlasses, maxPQ will contain the
        * NUM_TIMES_TO_RETURN smallest times. Create a new array to hold the
        * return array, and fill it in starting from the back, by pulling the
        * next largest item off the PriorityQueue
        */
        int[] returnArray = new int[NUM_TIMES_TO_RETURN];

        int i = NUM_TIMES_TO_RETURN - 1;
        while (i >= 0) {
            returnArray[i--] = maxPQ.poll();
        }

        return returnArray;

    }

    /*
    * Each time this method is called, one or both hour glasses will have just
    * emptied.  At that point, there are four things we can do:
    * 1. Nothing - let the seocnd glass run out.
    * 2. Flip Glass 1
    * 3. Flip Glass 2
    * 4. Flip Both glasses.
    * This method makes recursive calls trying each of these possiblities.
    * With each call, the amount of time until the next hour glass runs out
    * is calculated and added to elapsedTime
    */
    private void flipHourGlasses(GlassTimer g1, GlassTimer g2, int elapsedTime) {

        /*
        * If we've already stored our 10 numbers, and now the elapsedTime is
        * more than the largest time we've seen, just return.
        * maxPQ.peek() will give us the largest time stored in maxPQ.
        */
        if ((maxPQ.size() == NUM_TIMES_TO_RETURN) &&
                (elapsedTime >= maxPQ.peek())) {
            return;
        }

        /*
        * If maxPQ doesn't already contain the current elapsed time, And
        * Either maxPQ hasn've filled up yet or our current time is smaller
        * than the largest in maxPQ, store our current time.
        */
        if ((elapsedTime > 0) &&
                (!maxPQ.contains(elapsedTime)) &&
                ((maxPQ.size() < NUM_TIMES_TO_RETURN) ||
                        (elapsedTime < maxPQ.peek()))) {

            // If maxPQ is full, remove that largest to avoid holding > 10.
            if (maxPQ.size() == NUM_TIMES_TO_RETURN) {
                maxPQ.remove();
            }

            /*
            * Store the current time.  PriorityQueues use Poll() and Offer() in
            * place of Pop() and Push()
            */
            maxPQ.offer(elapsedTime);
        }

        GlassTimer g1a;
        GlassTimer g2a;
        int runTime;

        // Flip neither
        g1a = g1.copy();
        g2a = g2.copy();
        runTime = getNextPause(g1a, g2a);

        /*
        * Do not make calls where the runTime is not advanced.  This will
        * result in infinite loops.
        */
        if (runTime != 0) {
            flipHourGlasses(g1a.runFor(runTime), g2a.runFor(runTime),
                    elapsedTime + runTime);
        }

        // Flip glass 1
        g1a = g1.flip();
        g2a = g2.copy();
        runTime = getNextPause(g1a, g2a);

        if (runTime != 0) {
            flipHourGlasses(g1a.runFor(runTime), g2a.runFor(runTime),
                    elapsedTime + runTime);
        }

        // Flip glass 2
        g1a = g1.copy();
        g2a = g2.flip();
        runTime = getNextPause(g1a, g2a);

        if (runTime != 0) {
            flipHourGlasses(g1a.runFor(runTime), g2a.runFor(runTime),
                    elapsedTime + runTime);
        }

        // Flip both
        g1a = g1.flip();
        g2a = g2.flip();
        runTime = getNextPause(g1a, g2a);

        if (runTime != 0) {
            flipHourGlasses(g1a.runFor(runTime), g2a.runFor(runTime),
                    elapsedTime + runTime);
        }

    }

    /*
    * Determines when the next timer will run out.  In general, this will be
    * the smaller time remaining, but we want to avoid returning 0 if possible.
    */
    private static int getNextPause(GlassTimer a, GlassTimer b) {

        int a1 = a.getTimeRemaining();
        int b1 = b.getTimeRemaining();

        if ((a1 == 0) && (b1 == 0)) {
            return 0;
        }

        if (a1 == 0) {
            return b1;
        }

        if (b1 == 0) {
            return a1;
        }

        return Math.min(a1, b1);

    }
}
