public class SimpleCalculator {
	
	public int calculate(String input) {

        String[] ints = input.split("[+\\-\\*\\/]");

		char op = input.charAt(ints[0].length());

		int i1 = Integer.parseInt(ints[0]);
		int i2 = Integer.parseInt(ints[1]);

		if ('+' == op) return i1 + i2;
		if ('-' == op) return i1 - i2;
		if ('*' == op) return i1 * i2;
		return i1 / i2;

	}

}
