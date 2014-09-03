public class DoubleLetter {

    public String ableToSolve(String S) {

        boolean changed = true;

        while (changed) {

            changed = false;

            for (int i = 0; i < S.length() - 1; i++) {

                String s = "" + S.charAt(i) + S.charAt(i);

                int j = S.indexOf(s);

                if (j >= 0) {
                    S = S.replaceFirst(s, "");
                    changed = true;
                }

            }

        }

        return ((S == null) || (S.length() == 0)) ? "Possible" : "Impossible";
    }
}
