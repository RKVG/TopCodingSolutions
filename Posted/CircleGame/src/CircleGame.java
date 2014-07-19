/*
TopCoder
Single Round Match: 148
Division: 1
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1735
 */
public class CircleGame {

    // Use this value to represent cards that have been removed.
    private static final int REMOVED = -1;

    /*
      Given an index into deck, returns the next card that hasn't been removed.
      Handles looping around the end of the array by using the mod operator.
      If we return to the given index without finding a valid card,
      then return -1.
     */
    private static int getNextCardIndex(int start, int[] deck) {

        int next = (start + 1) % deck.length;

        while (next != start) {
            if (deck[next] != REMOVED) { return next; }
            next = (next + 1) % deck.length;
        }

        return -1; // No valid cards found.
    }

    public int cardsLeft(String deck) {

        // We'll use an array to represent the deck of cards.
        int[] deckArray = new int[deck.length()];

        // Convert the characters in deck to an integer array
        for (int i = 0; i < deck.length(); i++) {
            char c = deck.charAt(i);

            switch (c) {
                case 'A':
                    deckArray[i] = 1;
                    break;
                case 'T':
                    deckArray[i] = 10;
                    break;
                case 'J':
                    deckArray[i] = 11;
                    break;
                case 'Q':
                    deckArray[i] = 12;
                    break;
                case 'K':
                    deckArray[i] = REMOVED;  // Don't bother even adding them.
                    break;
                default:
                    deckArray[i] = c - '0';
            }
        }

        boolean madeMove = true;

        /*
        Each time we remove a card, we'll start back from the beginning of
        the deck.  The loop exits when the end of the deck is reached,
        and no moves have been made.
         */
        while (madeMove) {
            madeMove = false;

            for (int i = 0; i < deckArray.length; i++) {

                // Skip past any cards that have been removed.
                if (deckArray[i] == REMOVED) { continue; }

                // -1 if there is no next card.
                int nextCardIndex = getNextCardIndex(i, deckArray);

                if ((nextCardIndex >= 0) &&
                        ((deckArray[i] + deckArray[nextCardIndex]) == 13)) {
                    deckArray[i] = REMOVED;
                    deckArray[nextCardIndex] = REMOVED;
                    madeMove = true;
                    break;  // Start back from the beginning of the deck.
                }
            }
        }

        // Count the number of cards remaining.
        int count = 0;
        for (int aDeckArray : deckArray) {
            if (aDeckArray != REMOVED) {
                count++;
            }
        }
        return count;
    }
}
