public class InfiniteString {
	
	public String equal(String s, String t) {

		int ptrS = 0;
		int ptrT = 0;

		/*
		* Continue looping one character at a time until
		* we reach both the end of String s and the end
		* of String t at the same time.
		*/
		while ((ptrS < s.length()) || (ptrT < t.length()))  {

			/*
			* If at the end of a String, start over at
			* the beginning.
			*/
			ptrS %= s.length();
			ptrT %= t.length();

			// Return "Not Equal" if characters do not match
			if (s.charAt(ptrS) != t.charAt(ptrT)) return "Not equal";

			ptrS++;
			ptrT++;
		}

		return "Equal";
	}
}
