public class Substitute {

    public int getValue(String key, String code) {

        int result = 0;

        for (int i = 0; i < code.length(); i++) {

            int p = key.indexOf(code.charAt(i));

            if (p >= 0) {
                result *= 10;
                result += (p + 1) % 10;
            }

        }

        return result;

    }
}