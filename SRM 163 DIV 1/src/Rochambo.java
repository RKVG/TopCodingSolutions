public class Rochambo {

    public int wins(String opponent) {

        int numWins = 0;
        char previous2;
        char previous1;
        char current;

        for (int round = 0; round < opponent.length(); round++) {

            current = opponent.charAt(round);

            /*
            * First two moves are always Rock.  So if the opponent plays
            * Scissors, we win.
            */
            if (round < 2) {
                if (current == 'S') numWins++;

            } else {

                // Get opponents last 2 moves.
                previous2 = opponent.charAt(round - 2);
                previous1 = opponent.charAt(round - 1);

                /*
                * If the current move matches the last 2, we win by playing
                * whatever would have beaten the last 2.
                */
                if ((previous2 == current) && (previous1 == current)) {
                    numWins++;

                    /*
                    * If the current and last 2 moves are all different, we
                    * win by playing what beats that which was not played in
                    * the previous 2 rounds.
                    */
                } else if ((previous2 != previous1) &&
                        (current != previous1) &&
                        (current != previous2)) {
                    numWins++;
                }
            }
        }

        return numWins;
    }
}
