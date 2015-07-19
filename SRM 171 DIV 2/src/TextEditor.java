import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    public String[] twoColumn(String[] text, int width) {

        List<String> allWords = new ArrayList<>();

        /*
        * Put all words together into one long list.
        */
        for (String line : text) {
            String[] wordsOnLine = line.trim().split("\\s+");
            for (String word : wordsOnLine) {
                allWords.add(word);
            }
        }

        /*
        * Break the words up into lines so that no
        * line is longer than the given width.
        */
        List<String> oneColumn = new ArrayList<>();

        StringBuilder sb = new StringBuilder(width);

        for (String word : allWords) {

            /*
            * Nothing we can do if a word by itself cannot
            * fit onto a line with the given width.
            */
            if (word.length() > width) {
                throw new IllegalArgumentException(
                        "Word is too long to fit into column: " + word);
            }

            /*
            * If it's the first word, then always add it to
            * the current line.
            */
            if (sb.length() == 0) {
                sb.append(word);

            /*
            * If a space plus the word would fit on the current
            * line, then add it.
            */
            } else if (sb.length() + word.length() < width) {
                sb.append(" ");
                sb.append(word);

            /*
            * Otherwise, start a new line.
            */
            } else {
                oneColumn.add(sb.toString());
                sb = new StringBuilder(width);
                sb.append(word);
            }
        }

        /*
        * If there's anything left over, add it to
        * the final line.
        */
        if (sb.length() != 0) {
            oneColumn.add(sb.toString());
        }

        int i = 0;

        String[] result = new String[oneColumn.size()];

        /*
        * Fill in the even numbered positions first, when
        * the end is reached, come back and fill in the odds.
        */
        for (String s : oneColumn) {
            result[i] = s;
            i += 2;
            if (i >= oneColumn.size()) i = 1;
        }

        return result;
    }
}
