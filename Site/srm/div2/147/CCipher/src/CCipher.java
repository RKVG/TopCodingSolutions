/*
TopCoder
Single Round Match: 147
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&amp;pm=1667
 */

public class CCipher {

    public String decode(String cipherText, int shift) {

        char[] chArray = cipherText.toCharArray();

        for (int i = 0; i < chArray.length; i++) {

            int c = chArray[i] - shift;

            // If before 'A' - wrap around to the end.
            if (c < 'A') {
                c += 26;
            }

            chArray[i] = (char) c;
        }

        return new String(chArray);
    }
}
