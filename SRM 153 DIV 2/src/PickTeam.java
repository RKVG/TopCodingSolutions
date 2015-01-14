import java.util.*;

public class PickTeam {

	/*
     * This method converts the String[] people in a List of Perosn objects
     */
	private static List<Person> getAllPeople(String[] people) {

		List<Person> l = new ArrayList<>();

		for (int i = 0; i < people.length; i++) {
			Person p = new Person(i, people[i].split(" "));
			l.add(p);
		}

		return l;

	}

	/*
     * Returns a set of all possible teams given the list of people and the
     * desired team size.
     */
	private static Set<Team> getAllTeams(List<Person> allPeople,
										 int size) {

		// This is the set we'll return.
		Set<Team> teams = new HashSet<>();

        /*
         * Check that we have people to work with, and that the desired team
         * size is not more than the number of people available.
         */
		if ((allPeople == null) || (allPeople.size() == 0) ||
				(size > allPeople.size())) {
			return teams;
		}

        /*
         * If the desired team size is 1.  Then everyone get their own team.
         */
		if (size == 1) {
			for (Person p : allPeople) {
				Team t = new Team();
				t.addTeamMember(p);
				teams.add(t);
			}
			return teams;
		}

		// Copies the list of allPeople
		List<Person> currentPeople = new ArrayList<>();
		currentPeople.addAll(allPeople);

        /*
         * For each person, we'll call getAllTeams() will all of the remaining
         * people
         */
		for (int i=0; i<allPeople.size(); i++)  {
			Person currentPerson = currentPeople.get(i);

			for(Team team : getAllTeams(currentPeople.subList(i+1,
					currentPeople.size()), size-1))  {

				team.addTeamMember(currentPerson);
				teams.add(team);

			}
		}

		return teams;

	}

	public String[] pickPeople(int teamSize, String[] people) {

        /*
         * Gets the list of allPeople - which is just the people array
         * converted into Person objects.
         */
		List<Person> allPeople = getAllPeople(people);

		// Get a set of all possible teams
		Set<Team> allTeams = getAllTeams(allPeople, teamSize);

		int maxScore = Integer.MIN_VALUE;
		Team bestTeam = null;

		// Find the team with the greatest score.
		for (Team team : allTeams) {
			int score = team.getScore();
			if (score > maxScore) {
				maxScore = score;
				bestTeam = team;
			}
		}

		return bestTeam.getNames();
	}
}

/*
 * The Team class holds a set of Person which represents the people on the
 * team.  Also provide methods for calculating the score, and displaying
 * the team members in the format expected by the tests.
 */
class Team {

	Set<Person> teamMembers = new HashSet<>();

	// Calculates the score for the team.
	public int getScore() {

		int score = 0;

		for (Person p : teamMembers) {
			for (Person p1 : teamMembers) {
				score += p.getCompatibility(p1);
			}
		}

		return score;
	}

	// Returns the team member's names as a sorted array.
	public String[] getNames() {

		String[] names = new String[teamMembers.size()];

		int i = 0;
		for (Person p : teamMembers) {
			names[i++] = p.name;
		}

		Arrays.sort(names);
		return names;
	}

	public void addTeamMember(Person p) {
		teamMembers.add(p);
	}

}

class Person {

	final int id;
	final String name;
	final Map<Integer, Integer> compatibilityMap = new HashMap();

	Person(int id, String[] data) {

		this.id = id;
		name = data[0];

		for (int i = 1; i < data.length; i++) {
			compatibilityMap.put((i - 1), Integer.parseInt(data[i]));
		}
	}

	// Returns an int representing how compatible this person is with the other.
	public int getCompatibility(Person p) {
		return compatibilityMap.get(p.id);
	}

}


