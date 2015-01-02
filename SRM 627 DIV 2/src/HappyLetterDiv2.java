public class HappyLetterDiv2 {

    public char getHappyLetter(String letters) {

        // Loop through all letters in the input string.
        for (int i = 0; i < letters.length(); i++) {

            char currentChar = letters.charAt(i);

            // Count the characters that match the current char.
            int matchingChars = 0;

            for (int j = 0; j < letters.length(); j++) {
                if (letters.charAt(j) == currentChar) {
                    matchingChars++;
                }
            }

            /*
            * If the number of matching characters is greater than half the
            * length of the input string, then we have a happy letter.
            */
            if (matchingChars > (letters.length() / 2)) {
                return currentChar;
            }

        }

        return '.';

    }
}
