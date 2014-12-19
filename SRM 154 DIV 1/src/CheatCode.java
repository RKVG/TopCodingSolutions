import java.util.ArrayList;
import java.util.List;

public class CheatCode {

    private class CharAndCount {
        final char c;
        final int count;

        CharAndCount(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public String toString()  {
            return "{" + c + "," + count + "}";
        }
    }

    public int[] matches(String keyPresses, String[] codes) {

        List<CharAndCount> keyPressCode = createCode(keyPresses);

        List<Integer> matches = new ArrayList<>();

        for (int i = 0; i < codes.length; i++) {
            if (matchesCheat(keyPressCode, createCode(codes[i]))) {
                matches.add(i);
            }
        }

        int[] result = new int[matches.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = matches.get(i);
        }
        return result;

    }

    private boolean matchesCheat(List<CharAndCount> presses, List<CharAndCount> code) {

        int pStartIdx = 0;
        int codeIdx = 0;

        while (pStartIdx <= (presses.size() - code.size()))  {
            int pCurrentIdx = pStartIdx;

            while ((pCurrentIdx < presses.size()) &&
                    (codeIdx < code.size()) &&
                    (presses.get(pCurrentIdx).c == code.get(codeIdx).c) &&
                    (presses.get(pCurrentIdx).count >= code.get(codeIdx).count))  {
                pCurrentIdx++;
                codeIdx++;
            }

            if (codeIdx == code.size()) return true;

            codeIdx = 0;
            pStartIdx++;
        }

        return false;
    }

    private List<CharAndCount> createCode(String s) {

        List<CharAndCount> result = new ArrayList<>();

        if ((s == null) || (s.length() == 0)) return result;

        int count = 0;
        char c = s.charAt(0);

        for (int i = 0; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                result.add(new CharAndCount(c, count));
                count = 1;
                c = s.charAt(i);
            }
        }
        result.add(new CharAndCount(c, count));

        return result;
    }

}
