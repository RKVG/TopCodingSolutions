import java.util.HashMap;
import java.util.Map;

public class Poetry {
	
	public String rhymeScheme(String[] poem) {

        // The label we'll assign to the next rhyme.
        char nextRhymeLabel = 'a';

        /*
        * We'll fill in this array as we go, and ultimately
        * return it.
        */
        char[] result = new char[poem.length];

        // Maps and ending sound to a label.
        Map<String, Character> endings = new HashMap<>();


        for (int line = 0; line < poem.length; line++)  {

            // Split the line on whitespace characters
            String[] words = poem[line].trim().split("\\s+");

            /*
            * If the line was empty (or just spaces), words will
            * have a length of 1, and the only entry will have
            * a length of 0.
            */
            if ((words.length == 1) && (words[0].length() == 0))  {
                result[line] = ' ';

            } else  {

                String lastWord = words[words.length - 1];
                String ending = getWordEnding(lastWord.toLowerCase());

                if (endings.containsKey(ending))  {

                    /*
                    * We've already seen this ending, so just
                    * look up the label.
                    */
                    result[line] = endings.get(ending);

                } else  {

                    /*
                    * This is a new ending, so store
                    * it, and increment to the next label.
                    */
                    endings.put(ending, nextRhymeLabel);
                    result[line] = nextRhymeLabel;

                    if (nextRhymeLabel == 'z') {
                        nextRhymeLabel = 'A';
                    } else  {
                        nextRhymeLabel += 1;
                    }
                }
            }
        }

        return new String(result);

	}

    private String getWordEnding(String word)  {

        int i = word.length() - 1;

        // Work backward until we reach the first vowel.
        while ((i >= 0) && (!isVowel(word.charAt(i), i, word.length())))  {
            i--;
        }

        /*
        * Continue so long as it remains a vowel.  Don't
        * go past the beginning of the word.
        */
        while ((i >= 0) && (isVowel(word.charAt(i), i, word.length())))  {
            i--;
        }

        // Return the ending of word starting at position i+1
        return word.substring(i+1);


    }

    /*
    * Returns true if c is one of: a, e, i, o, or u.
    * Also returns true if c is y and not the first or last
    * letter of the word.  Otherwise, returns false.
    */
    private boolean isVowel(char c, int position, int wordLength)  {

        if ((c == 'a') ||
                (c == 'e') ||
                (c == 'i') ||
                (c == 'o') ||
                (c == 'u')) return true;

        if ((c == 'y') &&
                ((position != 0) && (position != (wordLength - 1)))) return true;

        return false;

    }
}
