import java.util.PriorityQueue;

public class Pool {

    private enum BallType {SOLID, STRIPE, EIGHT}

    private static BallType[][] legalRacks = {{
            BallType.STRIPE,
            BallType.SOLID, BallType.SOLID,
            BallType.STRIPE, BallType.EIGHT, BallType.STRIPE,
            BallType.SOLID, BallType.STRIPE, BallType.SOLID, BallType.STRIPE,
            BallType.STRIPE, BallType.SOLID, BallType.STRIPE, BallType.SOLID,
            BallType.SOLID
    }, {
            BallType.SOLID,
            BallType.STRIPE, BallType.STRIPE,
            BallType.SOLID, BallType.EIGHT, BallType.SOLID,
            BallType.STRIPE, BallType.SOLID, BallType.STRIPE, BallType.SOLID,
            BallType.SOLID, BallType.STRIPE, BallType.SOLID, BallType.STRIPE,
            BallType.STRIPE
    }};

    /*
    * Represents a configuration of balls, and how many moves it took to
    * get there.  Includes some methods for swapping balls, and determining
    * how far away it is from a legal rack.
    */
    private class SearchNode implements Comparable<SearchNode> {

        private BallType[] rack;
        private final int moves;
        private int numOutOfPlace = -1;

        SearchNode(BallType[] rack, int moves) {

            // Make a defensive copy of the rack that was passed in.
            this.rack = new BallType[rack.length];
            System.arraycopy(rack, 0, this.rack, 0, rack.length);

            this.moves = moves;
        }

        /*
        * Returns the number of balls that are out of place.  Since there
        * are more than one legal racks, it checks them all, and returns
        * the minimum.  Note, this calculation is only done once.
        */
        int getNumOutOfPlace() {

            if (numOutOfPlace >= 0)  {
                return numOutOfPlace;
            }

            numOutOfPlace = Integer.MAX_VALUE;

            // Check each legal configuration.
            for (int i = 0; i < legalRacks.length; i++) {

                int n = 0;

                for (int b = 0; b < rack.length; b++) {
                    if (rack[b] != legalRacks[i][b]) {
                        n++;
                    }
                }

                numOutOfPlace = Math.min(numOutOfPlace, n);
            }

            return numOutOfPlace;
        }

        /*
        * A heuristic representing how ideal this state is.  It is better
        * to have less balls out of place in a lower number of moves.
        */
        int getPriority() {
            return getNumOutOfPlace() + moves;
        }

        /*
        * Returns a new SearchNode with one pair of balls swapped.  Number
        * of moves is incremented by one.  If the 8 ball is out of position,
        * it will be swapped into the correct place first.
        */
        SearchNode swapBalls(BallType[] legalRack) {

            int ball1;
            int ball2;

            SearchNode newNode = new SearchNode(rack, moves + 1);

            // If the 8 ball is out of place, fix that first.
            if (rack[4] != BallType.EIGHT) {
                ball1 = 4;
                ball2 = 0;
                while (rack[ball2] != BallType.EIGHT) ball2++;  // Find the 8.
            } else {

                /*
                * ball1 is the first ball that is out of place - regardless
                * of it's type (solid / stripe).
                * ball2 is the first ball out of place of the type that
                * should be at the location of ball1.
                */
                ball1 = getFirstOutOfPlace(legalRack, null);
                ball2 = getFirstOutOfPlace(legalRack, legalRack[ball1]);
            }

            newNode.rack[ball1] = rack[ball2];
            newNode.rack[ball2] = rack[ball1];

            return newNode;
        }

        /*
        * Find the first ball that does not match the corresponding legal
        * rack.  If type is null, it can be either stripe or solid.  If
        * type is given, then the out of place ball must be of that type.
        */
        private int getFirstOutOfPlace(BallType[] legalRack, BallType type) {

            for (int i = 0; i < rack.length; i++) {
                if ((type == null) || (rack[i] == type)) {
                    if (rack[i] != legalRack[i]) {
                        return i;
                    }
                }
            }

            return -1;
        }

        // Sort SearchNodes based on their priority.
        public int compareTo(SearchNode o) {
            return Integer.compare(this.getPriority(), o.getPriority());
        }

    }

    public int rackMoves(int[] triangle) {

        /*
        * Using a PriorityQueue to process the possible solutions will allow
        * us to focus on the most promising paths first.  That is those closest
        * to a legal rack in the fewest number of moves.
        */
        PriorityQueue<SearchNode> possibleSolutions = new PriorityQueue<>();

        /*
        * Convert the given input array into an array of BallType objects.
        * These will be easier to work with then constantly having to check
        * ranges to determine if the ball is a stripe or solid.
        */
        BallType[] rack = new BallType[triangle.length];
        for (int i = 0; i < triangle.length; i++) {
            if (triangle[i] < 8) rack[i] = BallType.SOLID;
            else if (triangle[i] > 8) rack[i] = BallType.STRIPE;
            else rack[i] = BallType.EIGHT;
        }

        // Put our starting position into the PriorityQueue
        SearchNode n = new SearchNode(rack, 0);
        possibleSolutions.add(n);

        // The fewest moves seen so far that leads to a legal rack.
        int minNumberOfMoves = Integer.MAX_VALUE;

        while (true) {

            if (possibleSolutions.isEmpty()) {
                return minNumberOfMoves;
            }

            // Get the most promising node.
            SearchNode s = possibleSolutions.poll();

            /*
            * If there are no balls out of place, check to see if this
            * is the best solution found so far.
            */
            if (s.getNumOutOfPlace() == 0) {
                minNumberOfMoves = Math.min(minNumberOfMoves, s.moves);

            } else {

                /*
                * Make sure the move that we're about to make keeps us below
                * the number of moves in the best solution.  Otherwise, there's
                * no point in trying it.
                */
                if ((s.moves + 1) < minNumberOfMoves) {
                    for (int i = 0; i < legalRacks.length; i++) {

                        /*
                        * Add to possible solutions swappings that will
                        * get us closer to each of the legal racks.
                        */
                        possibleSolutions.add(s.swapBalls(legalRacks[i]));
                    }
                }
            }

        }

    }
}
