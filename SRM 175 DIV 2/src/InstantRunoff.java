import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InstantRunoff {

    public String outcome(String candidates, String[] ballots) {

        Set<Character> activeCandidates = new HashSet<>();

        for (Character c : candidates.toCharArray()) {
            activeCandidates.add(c);
        }

        while (true) {

            // Count the number of first place votes for each candidate.
            Map<Character, Integer> firstPlaceVotes = new HashMap<>();

            for (Character c : activeCandidates) {
                firstPlaceVotes.put(c, 0);
            }

            for (String b : ballots) {
                Character c;

                c = b.charAt(0);
                firstPlaceVotes.put(c, firstPlaceVotes.get(c) + 1);
            }

            // Do we have a clear winner?
            for (Character c : activeCandidates) {
                if (firstPlaceVotes.get(c) >=
                        ((ballots.length / 2) + 1)) {
                    return "" + c;
                }
            }

            // Get the least first place votes
            int minFirstPlaceVotes = Integer.MAX_VALUE;

            for (Character c : activeCandidates) {
                minFirstPlaceVotes = Math.min(minFirstPlaceVotes,
                        firstPlaceVotes.get(c));
            }

            // Remove all candidates with the most last place votes
            Set<Character> toRemove = new HashSet<>();
            for (Character c : activeCandidates) {
                if (firstPlaceVotes.get(c) == minFirstPlaceVotes)
                    toRemove.add(c);
            }

            for (Character c : toRemove) {
                activeCandidates.remove(c);
                for (int i = 0; i < ballots.length; i++) {
                    ballots[i] = ballots[i].replaceFirst("" + c, "");
                }
            }

            if (activeCandidates.size() == 0) return "";
        }

    }

}

