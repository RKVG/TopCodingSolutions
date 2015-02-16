public class SpecialStrings {

    public String findNext(String current) {

        // Work from right to left looking for the next '0'
        for (int i = current.length() - 1; i >= 0; i--) {
            if (current.charAt(i) == '0') {

                /*
                * Create a copy of the currentArray.  Each position
                * less than i will match the corresponding position in
                * currentArray, each position greater than i will equal '1'
                */
                char[] copyOfCurrent = new char[current.length()];
                for (int j = 0; j < current.length(); j++) {
                    copyOfCurrent[j] = (j < i) ? current.charAt(j) : '1';
                }

                /*
                * We've found a special string.  Let's see if we can do
                * better by changing some characters to the right from
                * 1's to 0's.
                */
                if (isSpecial(new String(copyOfCurrent))) {

                    for (int j = i + 1; j < copyOfCurrent.length; j++) {
                        copyOfCurrent[j] = '0';

                        // If not special, change it back.
                        if (!isSpecial(new String(copyOfCurrent))) {
                            copyOfCurrent[j] = '1';
                        }
                    }

                    return new String(copyOfCurrent);
                }
            }
        }

        return "";
    }

    private static final boolean isSpecial(String s) {

        for (int i = 1; i < s.length(); i++) {
            if (s.substring(0, i).compareTo(s.substring(i)) >= 0) return false;
        }
        return true;
    }
}
