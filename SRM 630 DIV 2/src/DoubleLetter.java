public class DoubleLetter {

    public String ableToSolve(String S) {

        // A StringBuilder will be much more efficient for deleting characters.
        StringBuilder sb = new StringBuilder(S);

        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    changed = true;

                    // Start over from the left of the string.
                    break;
                }
            }
        }

        return (sb.length() == 0) ? "Possible" : "Impossible";
    }
}
