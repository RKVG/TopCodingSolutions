public class FormatAmt {

    private static String formatDollars(int d) {
        String s = String.valueOf(d);

        StringBuilder sb = new StringBuilder(2 * s.length());

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.insert(0, s.charAt(i));
            count++;
            if ((count == 3) && (i != 0)) {
                sb.insert(0, ",");
                count = 0;
            }
        }
        return sb.toString();
    }

    private static String formatCents(int c) {

        String s = String.valueOf(c);
        if (s.length() < 2) {
            s = "0" + s;
        }

        return s;
    }

    public String amount(int dollars, int cents) {

        return "$" + formatDollars(dollars) + "." + formatCents(cents);
    }
}
