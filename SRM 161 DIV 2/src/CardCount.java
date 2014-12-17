public class CardCount {

    public String[] dealHands(int numPlayers, String deck) {

        int numCardsPerPlayer = deck.length() / numPlayers;

        String[] hands = new String[numPlayers];

        // Loop through the players one at a time.
        for (int i = 0; i < numPlayers; i++) {

            StringBuilder hand = new StringBuilder(numCardsPerPlayer);

            /*
            * Start with the card at position i, then skip numPlayers cards
            * until the hand is full.
            */
            for (int j = i; hand.length() < numCardsPerPlayer; j += numPlayers) {
                hand.append(deck.charAt(j));
            }

            hands[i] = hand.toString();
        }

        return hands;
    }
}
