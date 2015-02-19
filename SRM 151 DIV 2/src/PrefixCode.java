/*
TopCoder
Single Round Match: 151
Division: 2
Level: 1
Points: 250
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1700
 */

public class PrefixCode {

	public String isOne(String[] words) {

		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {

				if (words[i].startsWith(words[j])) {
					return ("No, " + j);
				} else if (words[j].startsWith(words[i])) {
					return ("No, " + i);
				}
			}
		}
		return "Yes";
	}
}
