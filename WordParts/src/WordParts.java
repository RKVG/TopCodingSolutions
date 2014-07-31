import java.util.HashMap;
import java.util.Map;

public class WordParts {

    Map<String, Integer> fixes;

    /*
     * Returns a map containing all possible substrings that either start at
     * the beginning of the String s, or end at the end of s.  For example,
     * if the input string is "java", the map would contain:
     * j, ja, jav, java, a, va, ava
     * The value for each of these keys represents the number of parts
     * required to make the string.  Inititally these are all 1.  A string
     * like "ajava" would have a value of 2: a=1 + java=1
     */
    private static Map<String, Integer> getFixes(String s) {

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
        fixes = getFixes(original);

        Integer i = fewestParts(compound);

        // i will be null if the compound string was invalid.
        return (i == null) ? -1 : i;
    }

    /*
     * fewestParts recursively calls itslef to determine the minimum number
     * of parts to create each substring of s.
     * If no valid substring can be formed, it returns null
     */
    private Integer fewestParts(String s) {

        // Break the recursion when string length becomes 0.
        if ((s == null) || (s.length() == 0)) {
            return null;
        }

        // If our map contains this key, just return the value.
        if (fixes.containsKey(s)) {
            return fixes.get(s);
        }

        // If this stays null, no valid combinations were found.
        Integer fewest = null;


        for (int i = 1; i <= s.length(); i++) {

            String prefix = s.substring(0,i);  // Gets the first i characters.
            String suffix = s.substring(i);  // Characters after the first i.

            if (!fixes.containsKey(prefix)) {
                continue;
            }

            /*
             * Recursively call fewestParts the determine the fewest number
             * of parts that are needed to create the suffix.  If the suffix
             * can be created (does not return null), the add the number of
             * parts to create the prefix.  If this sum is less than any that
             * we've seen to this point, store it in fewest.
             */
            Integer f = fewestParts(suffix);

            if (f != null) {

                f += fixes.get(prefix);

                if ((fewest == null) || (f.compareTo(fewest) < 0)) {
                    fewest = f;
                }
            }
        }

        /*
         * We now know the fewest number of parts needed to create the
         * current string, so store it in the map.
         */
        if (fewest != null)  {
            fixes.put(s, fewest);
        }

        return fewest;
    }

}
