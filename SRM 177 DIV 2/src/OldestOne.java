public class OldestOne {
	
	public String oldest(String[] data) {

		int oldestAge = 0;
		String oldestName = "";

		for (String s : data)  {
			int i = 0;

			// Skip all chars until we find a digit
			while (!Character.isDigit(s.charAt(i)))  i++;

			int age = 0;

			/*
			* We'll need the value of i later (it's the end
			* of the name string) so start a new index.
			*/
			int j = i;

			// Read in the age.
			while(Character.isDigit(s.charAt(j)))  {
				age *= 10;
				age += '0' + s.charAt(j);
				j++;
			}

			if (age > oldestAge)  {
				oldestAge = age;
				oldestName = s.substring(0, i);
			}
		}

		// Don't forget to remove trailing spaces.
		return oldestName.trim();
	}
}
