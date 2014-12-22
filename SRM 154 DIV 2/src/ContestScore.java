import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContestScore {

    /*
    * A class to hold the data related to a single contestant.
    */
    private class Contestant {

        final String name;
        final int[] scores;
        final int[] ranks;

        Contestant(String data) {

            // Get the contestant's name
            String[] elements = data.split(" ");
            this.name = elements[0];

            // Copy the remainder of data into scores.
            scores = new int[elements.length - 1];

            for (int i = 1; i < elements.length; i++) {

				/*
                * For now, we'll remove the decimal place from the score.
				* This won't change the rankings at all.  We'll put the
				* decimal back in when displaying the results.
				*/
                int score = Integer.parseInt(elements[i].replace(".", ""));
                scores[i - 1] = score;
            }

            // Ranks is empty for now.
            this.ranks = new int[scores.length];

        }

        // Returns the sum of all elements in rank
        int getTotalRank() {
            int totalRank = 0;
            for (int i = 0; i < ranks.length; i++) {
                totalRank += ranks[i];
            }
            return totalRank;
        }

        // Returns the sum of all elements in score
        int getTotalScore() {
            int totalScore = 0;
            for (int i = 0; i < scores.length; i++) {
                totalScore += scores[i];
            }
            return totalScore;
        }

        public String toString() {

            int totalRank = getTotalRank();
            int totalScore = getTotalScore();

			/*
			* score1 is the integer portion of the score.
			* score2 will be the decimal portion.
			*/
            int score1 = totalScore / 10;
            int score2 = totalScore % 10;

            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(" ");
            sb.append(totalRank);
            sb.append(" ");
            sb.append(score1);
            sb.append(".");
            sb.append(score2);
            return sb.toString();
        }
    }

    /*
    * Compares contestants based on the given judge.
    */
    private class ContestantComparatorByJudge implements
            Comparator<Contestant> {

        private final int judge;

        ContestantComparatorByJudge(int judge) {
            this.judge = judge;
        }

        @Override
        public int compare(Contestant o1, Contestant o2) {

            // Sort scores highest to lowest.
            return -1 * Integer.compare(o1.scores[judge], o2.scores[judge]);
        }
    }

    /*
    * Compares contestants based on their ranks.  All the ranks should be
    * computed prior to calling.
    */
    private class ContestantComparatorOverall implements
            Comparator<Contestant> {

        @Override
        public int compare(Contestant o1, Contestant o2) {

            // Compare rank first
            if (o1.getTotalRank() != o2.getTotalRank()) {
                return Integer.compare(o1.getTotalRank(), o2.getTotalRank());
            }

            // If there's a tie, compare by score, highest to lowest.
            if (o1.getTotalScore() != o2.getTotalScore()) {

                // Multiply by -1, since we want the higher score first.
                return -1 * Integer.compare(o1.getTotalScore(),
                        o2.getTotalScore());
            }

            // If still tied, compare by name.
            return o1.name.compareTo(o2.name);

        }
    }


    public String[] sortResults(String[] data) {

        if (data == null) {
            return null;
        }

        if (data.length == 0) {
            return new String[0];
        }

        List<Contestant> contestants = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            contestants.add(new Contestant(data[i]));
        }

        int numJudges = data[0].split(" ").length - 1;

        for (int i = 0; i < numJudges; i++) {

            // Create a new comparator to examine current judge's scores.
            ContestantComparatorByJudge judgeComparator =
                    new ContestantComparatorByJudge(i);

            // Sort the contestants using the new comparator.
            Collections.sort(contestants, judgeComparator);

			/*
			* Assign ranks to each contestant.  Need to keep track of previous
			* rank and score in the event that there are ties.
			*/
            int rank = 0;
            int lastScore = -1;
            int lastRank = 1;

            for (Contestant c : contestants) {
                rank++;
                if (c.scores[i] == lastScore) {
                    c.ranks[i] = lastRank;
                } else {
                    c.ranks[i] = rank;
                    lastScore = c.scores[i];
                    lastRank = rank;
                }
            }
        }

		/*
		* Once all the ranks are assigned.  Sort the contestants using
		* the ContestantComparatorOverall comparator.
		*/
        ContestantComparatorOverall overallComparator =
                new ContestantComparatorOverall();

        Collections.sort(contestants, overallComparator);

        // Build the result String[]
        String[] results = new String[data.length];

        int i = 0;
        for (Contestant c : contestants) {
            results[i++] = c.toString();
        }

        return results;

    }
}
