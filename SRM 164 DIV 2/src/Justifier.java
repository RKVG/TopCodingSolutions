public class Justifier {

    public String[] justify(String[] textIn) {

        int longest = 0;

        // Find the longest string.
        for (int i = 0; i < textIn.length; i++)  {
            longest = Math.max(longest, textIn[i].length());
        }

        String[] result = new String[textIn.length];

        // Loop through each of the strings.
        for (int i = 0; i < textIn.length; i++)  {
            StringBuilder s = new StringBuilder(textIn[i]);

            // Insert spaces at the beginning until length == longest.
            while (s.length() < longest)  {
                s.insert(0, " ");
            }

            result[i] = s.toString();
        }


        return result;
    }

}
