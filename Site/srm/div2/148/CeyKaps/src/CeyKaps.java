/*
TopCoder
Single Round Match: 148
Division: 2
Level: 2
Points: 600
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1740
 */

public class CeyKaps {

    // Will hold the key mappings.
    private final Character[] keys = new Character[26];

    public String decipher(String typed, String[] switches) {

        Character x = 'A';
        int pos = 0;

        // Initializes all key mappings to the starting values.
        while (x <= 'Z') {
            keys[pos++] = x++;
        }

        /*
        Loop through all the switches.  For each switch find the positions
        that hold the source and
         */
        for (String switche : switches) {

            // Get the values to be switched
            Character c1 = switche.charAt(0);
            Character c2 = switche.charAt(2);

            int pos1 = -1;
            int pos2 = -1;

            /*
            Find the keys that have the values equal to what is being
            switched.  Loop until both characters have been found.
             */
            int j = 0;
            while ((pos1 < 0) || (pos2 < 0)) {
                if (c1.equals(keys[j])) { pos1 = j; }
                if (c2.equals(keys[j])) { pos2 = j; }
                j++;
            }

            // Swap the values.
            Character t = keys[pos1];
            keys[pos1] = keys[pos2];
            keys[pos2] = t;
        }

        // An array to hold our return value.
        char[] result = new char[typed.length()];

        // Read each typed character and replace it with it's mapping.
        for (int i = 0; i < typed.length(); i++) {
            Character c = typed.charAt(i);
            int pos3 = c - 'A';
            result[i] = keys[pos3];
        }

        return new String(result);
    }
}
