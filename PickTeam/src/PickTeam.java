import java.util.*;

public class PickTeam {

    private static List<Person> getAllPeople(String[] people) {

        List<Person> l = new ArrayList<>();

        for (int i = 0; i < people.length; i++) {
            Person p = new Person(i, people[i].split(" "));
            l.add(p);
        }

        return l;

    }

    private static Set<Team> getAllTeams(List<Person> allPeople,
                                         int size) {

        Set<Team> teams = new HashSet<>();

        if ((allPeople == null) || (allPeople.size() == 0) ||
                (size > allPeople.size())) {
            return teams;
        }

        if (size == 1) {
            for (Person p : allPeople) {
                Team t = new Team();
                t.addTeamMember(p);
                teams.add(t);
            }
            return teams;
        }

        List<Person> currentPeople = new ArrayList<>();
        currentPeople.addAll(allPeople);

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

        List<Person> allPeople = getAllPeople(people);

        Set<Team> allTeams = getAllTeams(allPeople, teamSize);

        System.out.println("Evaluating " + allTeams.size() + " teams");

        int maxScore = Integer.MIN_VALUE;
        Team bestTeam = null;

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

class Team {

    Set<Person> teamMembers = new HashSet<>();

    public int getScore() {

        int score = 0;

        for (Person p : teamMembers) {
            for (Person p1 : teamMembers) {
                score += p.getCompatibility(p1);
            }
        }

        return score;
    }

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

    public int getCompatibility(Person p) {
        return compatibilityMap.get(p.id);
    }

}


