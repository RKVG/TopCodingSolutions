public class BinaryCode {

    /*
    Decodes the string.
    The string is encoded by adding it's two neighbors to it's values.
    So:
    1001001 becomes 1111111
    In some cases the message may decode to two different values depending on
    if pos1 = 0 or 1.
    In other cases a value of 0 or 1 may lead to a message that cannot be decoded.
    i.e. would require a a digit other than 0 or 1 to make the sums add up.
     */
    private static String decode(char[] message, char pos1) {

        /*
        Create a return array that is 1 element larger than the message.  This extra
        space will make it easier to compute the last element, and will ultimately
        get chopped off before returning anyway.
         */
        char[] ret = new char[message.length + 1];

        // Set the first position to either a 0 or 1 depending on the parameter.
        ret[0] = pos1;

        // Loop through the return array starting at position 1.
        for (int i = 1; i < ret.length; i++) {
            Integer a = Integer.parseInt("" + message[i - 1]);
            Integer b = Integer.parseInt("" + ret[i - 1]);

            // This protects from going in front of the beginning of the array.
            Integer c = (i == 1) ? 0 : Integer.parseInt("" + ret[i - 2]);

            /*
            The current value in the return array will equal:
            (one position back in the message) - (one position back in the return array) -
            (2 positions back in the return array)
            Write this out on papers until you're convinced that it works.
             */
            int val = a - b - c;

            // If we arrive at a non-binary digit, then the encoding was impossible given the value of pos1.
            if ((val > 1) || (val < 0)) {
                return "NONE";
            }

            // Convert the number to a character.
            ret[i] = (char) (val + '0');
        }

        // Convert the array to a String, and chop off the last place.
        return new String(ret).substring(0, ret.length - 1);
    }

    public String[] decode(String message) {

        // Create an array of Strings to return.
        String[] ret = new String[2];

        // Populate the return array with the results of decoding.
        // First when we assume that the first digit was a 0.
        // Then when we assume the first digit was a 1.
        ret[0] = decode(message.toCharArray(), '0');
        ret[1] = decode(message.toCharArray(), '1');

        return ret;
    }
}
