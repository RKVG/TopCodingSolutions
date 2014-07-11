/*
TopCoder
Single Round Match: 145
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1728
 */

import java.util.HashSet;
import java.util.Set;

public class ImageDithering {

    public int count(String dithered, String[] screen) {

        int count = 0;

        char[] dColors = dithered.toCharArray();
        Set<Character> dSet = new HashSet<>();

        for (char dColor : dColors) {
            dSet.add(dColor);
        }

        for (String row : screen) {
            for (int i = 0; i < row.length(); i++) {
                if (dSet.contains(row.charAt(i))) {
                    count++;
                }
            }
        }

        return count;
    }
}
