public class TennisRallies {


    private int numPossible;

    public int howMany(int numLength, String[] forbidden, int allowed) {

        /*
        * Used to see if we're better off calling isValid() more often to keep
        * the size of the recursion tree smaller, or hold off using it until
        * after all possible combinations have been generated.
        */
        boolean usedDelayedValidate = true;

        numPossible = 0;

        long start = System.currentTimeMillis();

        if (usedDelayedValidate) {
            addShotsDelayedValidate("", numLength, forbidden, allowed);
        } else {
            addShotsEarlyValidate("", numLength, forbidden, allowed);
        }
        long end = System.currentTimeMillis();

        System.out.println("Time: " + (end - start) + "ms");

        return numPossible;
    }

    // Use recursion to create and validate all possible shot patterns.
    private void addShotsEarlyValidate(String base, int size,
                                       String[] forbidden, int allowed) {

        if (base.length() == size) {
            numPossible++;

        } else {
            if (isValid(base + "c", forbidden, allowed)) {
                addShotsEarlyValidate(base + "c", size, forbidden, allowed);
            }

            if (isValid(base + "d", forbidden, allowed))
                addShotsEarlyValidate(base + "d", size, forbidden, allowed);
        }
    }

    private void addShotsDelayedValidate(String base, int size,
                                         String[] forbidden, int allowed) {

        if (base.length() == size) {
            if (isValid(base, forbidden, allowed)) {
                numPossible++;
            }
        } else {
            addShotsDelayedValidate(base + "c", size, forbidden, allowed);
            addShotsDelayedValidate(base + "d", size, forbidden, allowed);
        }
    }

    /*
    * Counts the number of times a pattern given in forbidden appears in
    * s.  Stops when that count reaches allowed.
    */
    private boolean isValid(String s, String[] forbidden, int allowed) {

        int numFails = 0;

        for (String f : forbidden) {
            numFails += countMatches(s, f, (allowed - numFails));
            if (numFails >= allowed) return false;
        }

        return true;

    }

    /*
    * Counts the number of times pat appears in str.  Stops when/if
    * maxMatches is reached.
    */
    private int countMatches(String str, String pat, int maxMatches) {

        int strIdx = 0;
        int patIdx = 0;
        int startOfMatch = 0;
        int numMatches = 0;

        if (str.length() < pat.length()) {
            return 0;
        }

        // Walk through str one char at a time until we reach the end.
        while (strIdx < str.length()) {

            // Advance until a char in str matches the first char in pat.
            while ((strIdx < str.length() &&
                    (str.charAt(strIdx) != pat.charAt(patIdx)))) {
                strIdx++;
            }

            if (strIdx == str.length()) return numMatches;

            // Note the beginning of a potential match.
            startOfMatch = strIdx;

            // Advance through both strings so long as the chars match
            while ((strIdx < str.length()) &&
                    (patIdx < pat.length()) &&
                    str.charAt(strIdx) == pat.charAt(patIdx)) {
                strIdx++;
                patIdx++;
            }

            // If we've reached the end of pat, then a match has been found.
            if (patIdx == pat.length()) {
                numMatches++;
                if (numMatches == maxMatches) {
                    return numMatches;
                }

                // Begin again at the next character.
                strIdx = startOfMatch + 1;
                patIdx = 0;

			/*
            * If we didn't reach the end of the string, then the characters
			* must have differed.  Start again at the character following
			* startOfMatch.
			*/
            } else if (strIdx < str.length()) {
                strIdx = startOfMatch + 1;
                patIdx = 0;
            }

        }

        return numMatches;
    }

}
