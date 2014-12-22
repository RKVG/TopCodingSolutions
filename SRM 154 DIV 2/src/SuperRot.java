public class SuperRot {

	public String decoder(String message) {

		char[] retMessage = new char[message.length()];

		int x = 0;

		for (int c : message.toCharArray())  {

			if (Character.isUpperCase(c))  {
				c = ((c - 'A' + 13) % 26) + 'A';

			} else if (Character.isLowerCase(c))  {
				c = ((c - 'a' + 13) % 26) + 'a';

			} else if (Character.isDigit(c))  {
				c = ((c - '0' + 5) % 10) + '0';

			}

			retMessage[x++] = (char) c;
		}

		return new String(retMessage);
	}
}