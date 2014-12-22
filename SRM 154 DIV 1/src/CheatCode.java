import java.util.ArrayList;
import java.util.List;

public class CheatCode {

    /*
    * This class simply binds a char and an int together.
    */
    private class CharAndCount {

        final char c;
        final int count;

        CharAndCount(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public int[] matches(String keyPresses, String[] codes) {

        // Encode the String to make it easier to analyse.
        List<CharAndCount> keyPressCode = createCode(keyPresses);

        // Holds all of the codes that match keyPresses
        List<Integer> matches = new ArrayList<>();

        /*
        * Loop through each code.  If keyPresses matches the code, then
        * add code to the list of matches.
        */
        for (int i = 0; i < codes.length; i++) {
            if (matchesCheat(keyPressCode, createCode(codes[i]))) {
                matches.add(i);
            }
        }

        // Convert the List into an array and return it.
        int[] result = new int[matches.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = matches.get(i);
        }
        return result;

    }

    /*
    * Takes an encoded string that represents the keyPresses, and one
    * that represents the code.  See the createCode method.
    * code matches if it's character sequence is contained in presses,
    * and each character's count is less than or equal to the count in
    * presses.
    */
    private boolean matchesCheat(List<CharAndCount> presses,
                                 List<CharAndCount> code) {

        int pStartIdx = 0;
        int codeIdx = 0;

        /*
        * Start at position 0 in presses and check until the current position
        * plus the length of the code would put us beyond the length of
        * presses.
        */
        while (pStartIdx <= (presses.size() - code.size())) {

            int pCurrentIdx = pStartIdx;

            /*
            * While presses and code agree, increment indexes for each
            */
            while ((pCurrentIdx < presses.size()) &&
                    (codeIdx < code.size()) &&
                    (presses.get(pCurrentIdx).c == code.get(codeIdx).c) &&
                    (presses.get(pCurrentIdx).count >=
                            code.get(codeIdx).count)) {
                pCurrentIdx++;
                codeIdx++;
            }

            // If we matched the entire code, return true.
            if (codeIdx == code.size()) return true;

            /*
            * Otherwise, return to the beginning of the code, and start with
            * the next position in presses.
            */
            codeIdx = 0;
            pStartIdx++;
        }

        return false;
    }

    /*
    * Encodes a String by replacing each repeating character with a
    * CharAndCount object that holds the character and the number of
    * times it repeats.  For example:
    * AAABBC becomes {{3,A}, {2,B}, {1,C}}
    */
    private List<CharAndCount> createCode(String s) {

        List<CharAndCount> result = new ArrayList<>();

        if ((s == null) || (s.length() == 0)) return result;

        int count = 0;
        char c = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {

            // If character is the same, just increase the count.
            if (c == s.charAt(i)) {
                count++;
            } else {

                // Set up the next repeating sequence.
                result.add(new CharAndCount(c, count));
                count = 1;
                c = s.charAt(i);
            }
        }
        result.add(new CharAndCount(c, count));

        return result;
    }
}
