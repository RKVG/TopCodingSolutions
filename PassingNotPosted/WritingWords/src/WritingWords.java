public class WritingWords {

    public int write(String word) {

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            count += c - 'A' + 1;
        }

        return count;
    }
}
