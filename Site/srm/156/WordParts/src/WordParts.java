/*
TopCoder
Single Round Match: 156
Division: 2
Level: 3
Points: 1000
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1361
 */

import java.util.HashMap;
import java.util.Map;

public class WordParts {

    /*
     * Holds all the word parts that we've processed so far,
     * along with the minimum number of word parts needed to create them.
     */
    Map<String, Integer> wordParts;

    /*
     * Returns a map containing all possible substrings that either start at
     * the beginning of the String s, or end at the end of s.  For example,
     * if the input string is "java", the map would contain:
     * j, ja, jav, java, a, va, ava
     * The value for each of these keys represents the number of parts
     * required to make the string.  Inititally these are all 1.  A string
     * like "ajava" would have a value of 2: a=1 + java=1
     */
    private static Map<String, Integer> getWordParts(String s) {

        Map<String, Integer> m = new HashMap<>();

        for (int i = 1; i <= s.length() - 1; i++) {
            m.put(s.substring(0, i), 1);  // Starts from beginning
            m.put(s.substring(i), 1);     // Starts from the end
        }

        // Don't forget to include the entire string.
        m.put(s, 1);

        return m;
    }

    /*
     * The main method
     */
    public int partCount(String original, String compound) {

        // Check for the empty string case.
        if ((compound == null) || (compound.length() < 1)) {
            return 0;
        }

        // Create a map of all possible prefixes and suffixes.
        wordParts = getWordParts(original);

        return fewestParts(compound);

    }

    /*
     * fewestParts recursively calls itslef to determine the minimum number
     * of parts to create each substring of s.
     * If no valid substring can be formed, it returns null
     */
    private int fewestParts(String s) {

        // Break the recursion when string length becomes 0.
        if ((s == null) || (s.length() == 0)) {
            return -1;
        }

        // If our map contains this key, just return the value.
        if (wordParts.containsKey(s)) {
            return wordParts.get(s);
        }

        int fewest = -1;

        for (int i = 1; i <= s.length(); i++) {

            String prefix = s.substring(0,i);  // Gets the first i characters.
            String suffix = s.substring(i);  // Characters after the first i.

            if (!wordParts.containsKey(prefix)) {
                continue;
            }

            /*
             * Recursively call fewestParts the determine the fewest number
             * of parts that are needed to create the suffix.  If the suffix
             * can be created (does not return -1), then add the number of
             * parts to create the prefix.  If this sum is less than any that
             * we've seen to this point, store it in fewest.
             */
           int f = fewestParts(suffix);

            if (f > 0) {

                f += wordParts.get(prefix);

                if ((fewest == -1) || (f < fewest)) {
                    fewest = f;
                }
            }
        }

        /*
         * We now know the fewest number of parts needed to create the
         * current string, so store it in the map.
         */
        if (fewest != -1)  {
            wordParts.put(s, fewest);
        }

        return fewest;
    }
}
