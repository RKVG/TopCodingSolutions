import java.util.Arrays;
import java.util.List;

public class UserId {

    private static final String BAD_DATA = "BAD DATA";
    private static final int ID_MAX_LENGTH = 8;

    public String id(String[] inUse, String first, String middle, String last) {

        // Check for invalid characters.
        String fullName = first + middle + last;
        for (int i = 0; i < fullName.length(); i++) {
            if (!isValidChar(fullName.charAt(i))) return BAD_DATA;
        }

        // Check for short first and last name;
        if (numLetters(first) < 2) return BAD_DATA;
        if (numLetters(last) < 2) return BAD_DATA;

        // Remove spaces, apostrophes, and convert to lowercase.
        first = normalizeName(first);
        middle = normalizeName(middle);
        last = normalizeName(last);

        // This will make it easier to see if the id is already in use.
        List<String> inUseList = Arrays.asList(inUse);

        String userId;

        // Contains truncated last name, so the entire ID is <= than 8 chars.
        String shortLast;

        // Try [first initial][last name]
        if (last.length() > (ID_MAX_LENGTH - 1)) {
            shortLast = last.substring(0, ID_MAX_LENGTH - 1);
        } else {
            shortLast = last;
        }

        userId = first.substring(0, 1) + shortLast;
        if (!inUseList.contains(userId)) return userId;

        // Try [first initial][middle initial][last name];
        if ((middle != null) && (middle.length() >= 1)) {

            if (last.length() > (ID_MAX_LENGTH - 2)) {
                shortLast = last.substring(0, ID_MAX_LENGTH - 2);
            } else {
                shortLast = last;
            }

            userId = first.charAt(0) + (middle.charAt(0) + shortLast);

//            userId = first.substring(0, 1) + middle.substring(0, 1) + shortLast;
            if (!inUseList.contains(userId)) return userId;
        }

        // Try [first initial][last name][digit][digit]
        if (last.length() > (ID_MAX_LENGTH - 3)) {
            shortLast = last.substring(0, ID_MAX_LENGTH - 3);
        } else {
            shortLast = last;
        }

        int x = 1;
        while (x < 100) {
            String digits = String.format("%02d", x);
            userId = first.substring(0, 1) + shortLast + digits;
            if (!inUseList.contains(userId)) return userId;
            x++;
        }

        return null;
    }

    /*
    * Removes apostrophes and spaces, and converts upper-case
    * letters to lower case.
    */
    private static String normalizeName(String s) {

        if (s == null) return null;

        StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ' ') continue;
            if (c == '\'') continue;
            if ((c >= 'A') && (c <= 'Z')) {
                c = (char)(c + 'a' - 'A');
            }
            sb.append(c);
        }

        return sb.toString();
    }

    // Counts the number of characters in the String.
    private static int numLetters(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a') && (c <= 'z')) count++;
            else if ((c >= 'A') && (c <= 'Z')) count++;
        }

        return count;

    }

    /*
    * Valid characters are a-z, A-Z, apostrophe, and space.
    */
    private static boolean isValidChar(char c) {

        if ((c >= 'a') && (c <= 'z')) return true;
        if ((c >= 'A') && (c <= 'Z')) return true;
        if (c == ' ') return true;
        if (c == '\'') return true;
        return false;

    }
}
