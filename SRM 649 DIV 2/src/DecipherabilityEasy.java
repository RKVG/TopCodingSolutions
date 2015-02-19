public class DecipherabilityEasy {

    public String check(String s, String t) {

        // Make sure s has one character more than t
        if (s.length() != t.length() + 1) return "Impossible";

        int sIdx = 0;
        int tIdx = 0;

        // Walk through each letter in t.
        while (tIdx < t.length()) {
            if (s.charAt(sIdx) != t.charAt(tIdx)) {

                /*
                * If the characters don't match up, it's ok the first time.
                * Skip a letter in s and move on.  If it happens again,
                * return Impossible.
                */
                if (sIdx == tIdx) {
                    sIdx++;
                } else {
                    return "Impossible";
                }

            } else {
                sIdx++;
                tIdx++;
            }
        }

        return "Possible";

    }
}
