public class LongWordsDiv2 {

    public String find(String word) {

        if (checkWord(word)) {
            return "Likes";
        } else {
            return "Dislikes";
        }
    }

    private boolean checkWord(String word) {

        for (int i = 0; i < word.length(); i++) {
            // Check for all upper case
            if ((word.charAt(i) < 'A') || (word.charAt(i) > 'Z')) {
                return false;
            }
        }

        for (int i = 0; i < (word.length() - 1); i++) {
            // Check for next character matches
            if (word.charAt(i) == word.charAt(i + 1)) { return false; }
        }

        for (int i = 0; i < word.length() - 1; i++) {
            for (int x = i + 1; x < word.length(); x++) {
                String regex = ".*" + word.charAt(i) + ".*" + word.charAt(x)
                        + ".*" + word.charAt(i) + ".*" + word.charAt(x) + ".*";
                if (word.matches(regex)) { return false; }
            }
        }

        return true;
    }
}
