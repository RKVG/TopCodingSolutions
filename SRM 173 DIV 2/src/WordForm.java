public class WordForm {
	
	public String getSequence(String word) {

        char[] cvArray = new char[word.length()];

        boolean prevIsVowel = true;

        for (int i = 0; i < word.length(); i++)  {
            cvArray[i] = (prevIsVowel = isVowel(word.charAt(i), prevIsVowel)) ? 'V' : 'C';
        }

        // Remove duplicate characters
        return new String(cvArray).replaceAll("([CV])\\1+", "$1");
	}

    private static boolean isVowel(Character c, boolean prevIsVowel)  {

        c = Character.toUpperCase(c);

        if ((c.equals('A')) || (c.equals('E')) ||
                (c.equals('I')) || (c.equals('O')) ||
                (c.equals('U'))) return true;

        if (!c.equals('Y')) return false;

        return !prevIsVowel;
    }
}
