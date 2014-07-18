/*
TopCoder
Single Round Match:
Division:
Level:
Points:
Description: http://community.topcoder.com/...
 */

public class SuperRot {

	public String decoder(String message) {

        char[] retMessage = new char[message.length()];

        int x = 0;

        for (int c : message.toCharArray())  {

            if ((c >= 'A') && (c <= 'Z'))  {
                c = ((c - 'A' + 13) % 26) + 'A';

            } else if ((c >= 'a') && (c <= 'z'))  {
                c = ((c - 'a' + 13) % 26) + 'a';

            } else if ((c >= '0') && (c <= '9'))  {
                c = ((c - '0' + 5) % 10) + '0';

            }

            retMessage[x++] = (char) c;
        }

        return new String(retMessage);
	}
}
