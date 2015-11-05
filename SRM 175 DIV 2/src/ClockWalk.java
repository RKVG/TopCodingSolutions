public class ClockWalk {

	public int finalPosition(String flips) {
		int result = 0;

		for (int i = 0; i < flips.length(); i++)  {
			if (flips.charAt(i) == 'h')  result += i + 1;
			else result -= i + 1;
		}

		result %= 12;

		return (result <= 0) ? (result + 12) : result;
	}

}