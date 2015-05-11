import java.util.*;

public class ShortPalindromes {

    public String shortest(String base) {

        Set<String> palindromes = getPalindromes(base);

        int shortest = Integer.MAX_VALUE;

        for (String s : palindromes) {
            shortest = Math.min(shortest, s.length());
        }

        List<String> shortestPalindromes = new ArrayList<>();

        for (String s : palindromes) {
            if (s.length() == shortest) {
                shortestPalindromes.add(s);
            }
        }

        Collections.sort(shortestPalindromes);

        return shortestPalindromes.get(0);


    }

    private Set<String> getPalindromes(String base) {

        Set<String> palindromes = new HashSet<>();

        if ((base == null) || (base.length() == 0)) return palindromes;

        if (base.length() == 1) {
            palindromes.add(base);
            return palindromes;
        }

        char newChar = base.charAt(0);

        for (String s : getPalindromes(base.substring(1))) {

            // If length is odd, split the middle character.
            if ((s.length() % 2) != 0)  {
                int midPoint = s.length() / 2;
                char midChar = s.charAt(midPoint);

                StringBuilder sb = new StringBuilder(s);
                sb.replace(midPoint, midPoint, midChar + "" + newChar);
                palindromes.add(sb.toString());

                sb = new StringBuilder(s);
                sb.replace(midPoint, midPoint, midChar + "" + newChar + "" + newChar);
                palindromes.add(sb.toString());

            }

            palindromes.add(newChar + s + newChar);

            String firstHalf = s.substring(0, (s.length() + 1) / 2);

            for (int i = 0; i < firstHalf.length(); i++) {
                StringBuilder sb = new StringBuilder(firstHalf);
                sb.insert(i, newChar);
                palindromes.add(sb.toString() + reverseString(sb.toString()));
            }
        }

        Set<String> returnSet = removeNonMatching(base, palindromes);
        return returnSet;

    }

    private String reverseString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    private Set<String> removeNonMatching(String base, Set<String> p1) {

        Set<String> p2 = new HashSet<String>();

        for (String s : p1) {

            if (matchesPattern(base, s)) {
                p2.add(s);
            }
        }

        return p2;

    }

    private boolean matchesPattern(String base, String pal) {

        int basePtr = 0;

        for (int i = 0; i < pal.length(); i++) {
            if (base.charAt(basePtr) == pal.charAt(i)) {
                basePtr++;
                if (basePtr == base.length()) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ShortPalindromes sp = new ShortPalindromes();
        String result = sp.shortest("RACE");
        System.out.println(result);
    }
}
