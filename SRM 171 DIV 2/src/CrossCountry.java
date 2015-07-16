import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrossCountry {

    private static final int MIN_FINISHERS = 5;
    private static final int TIE_BREAKER_PLACE = MIN_FINISHERS + 1;

    /*
    * The Team class represents a team and contains methods for calculating
    * it's score and comparing it to other teams.
    */
    class Team implements Comparable<Team> {

        char name;
        int score;
        int numFinishers;
        int tieBreaker;

        public Team(char name) {
            this.name = name;
        }

        public void addFinisher(int score) {

            // Only the top 5 runner contribute to the score.
            if (numFinishers < MIN_FINISHERS) {
                this.score += score;

                // Store the 6th finisher's position in tieBreaker.
            } else if (numFinishers == MIN_FINISHERS) {
                tieBreaker = score;
            }

            numFinishers++;
        }

        // Assumes that both Teams have at least five finishers.
        @Override
        public int compareTo(Team o) {

            if (this.score != o.score) return new Integer(score).compareTo(o.score);

            // This team does not have a 6th place finisher, but the other does.
            if ((numFinishers < TIE_BREAKER_PLACE) && (o.numFinishers >= TIE_BREAKER_PLACE)) return 1;

            // This team has a 6th place finisher, but the other team does not.
            if ((numFinishers >= TIE_BREAKER_PLACE) && (o.numFinishers < TIE_BREAKER_PLACE)) return -1;

            // Both teams have a 6th place finisher.
            if ((numFinishers >= TIE_BREAKER_PLACE) && (o.numFinishers >= TIE_BREAKER_PLACE))
                return new Integer(tieBreaker).compareTo(o.tieBreaker);

            // Neither team has a 6th place finisher.
            return new Character(name).compareTo(o.name);

        }
    }


    public String scoreMeet(int numTeams, String finishOrder) {

        Team[] teams = new Team[numTeams];

        // Initialize an ArrayList with a Team object for each team.
        char name = 'A';
        for (int i = 0; i < numTeams; i++) {
            teams[i] = (new Team(name++));
        }

        int score = 1;

        /*
        * Work left to right through the finishOrder string.  For each
        * character, determine corresponding team by subtracting the value
        * of 'A' from the character to get it's index in the teams list.
        */
        for (int i = 0; i < finishOrder.length(); i++) {
            char c = finishOrder.charAt(i);
            teams[c - 'A'].addFinisher(score++);
        }

        // Holds only those teams with 5 or more finishers.
        List<Team> qualifyingTeams = new ArrayList<>();

        for (int i = 0; i < teams.length; i++)  {
            if (teams[i].numFinishers >= MIN_FINISHERS) {
                qualifyingTeams.add(teams[i]);
            }
        }

        // Use the Team.compareTo() method to sort the teams out.
        Collections.sort(qualifyingTeams);

        /*
        * Build our return string by going through the sorted list
        * and adding the team names.
        */
        StringBuilder sb = new StringBuilder(qualifyingTeams.size());

        for (Team t : qualifyingTeams) {
            sb.append(t.name);
        }

        return sb.toString();
    }
}
