public class LongWordsDiv2 {

    public String find(String word) {
        return (checkWord(word)) ? "Likes" : "Dislikes";
    }

    private boolean checkWord(String word) {

        for (int i = 0; i < word.length(); i++) {
            // Check for all upper case
            if ((word.charAt(i) < 'A') || (word.charAt(i) > 'Z')) {
                return false;
            }
        }

        // Check for next character matches
        for (int i = 0; i < (word.length() - 1); i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                return false;
            }
        }

        /*
        * Check for pattern xyxy
        * */
        for (int i = 0; i < word.length() - 1; i++) {
            for (int j = i + 1; j < word.length(); j++) {
                String regex = ".*" + word.charAt(i) + ".*" + word.charAt(j)
                        + ".*" + word.charAt(i) + ".*" + word.charAt(j) + ".*";
                if (word.matches(regex)) {
                    return false;
                }
            }
        }

        return true;
    }
}
