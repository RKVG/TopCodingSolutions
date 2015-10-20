public class Matching {

	private static final String[][] TRAITS = {
			{"CIRCLE", "SQUIGGLE", "DIAMOND"},
			{"BLUE", "RED", "GREEN"},
			{"SOLID", "STRIPED", "EMPTY"},
			{"ONE", "TWO", "THREE"}
	};

	public String[] findMatch(String[] first, String[] second) {

		String[] result = new String[4];

		for (int i = 0; i < TRAITS.length; i++)  {
			result[i] = getMatch(first[i], second[i], TRAITS[i]);
		}

		return result;

	}

	private static String getMatch(String s1, String s2, String[] traits)  {

		/*
		* If the two strings are equal, then return that string.
		*/
		if (s1.equals(s2)) return s1;

		/*
		* Otherwise, return the string that is not s1 or s2
		*/
		for (int i = 0; i < traits.length; i++)  {
			if (!traits[i].equals(s1) && !traits[i].equals(s2))
				return traits[i];
		}

		return null;

	}
}
