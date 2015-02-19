/*
TopCoder
Single Round Match: 638
Division: 2
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=13243
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketExpressions {

	/*
     * A map that holds closing characters and their corresponding opening
     * characters.
     */
	Map<Character, Character> openCloseMap = new HashMap<>();

	public String ifPossible(String expression) {

		openCloseMap.put(')', '(');
		openCloseMap.put(']', '[');
		openCloseMap.put('}', '{');

		Stack<Character> st = new Stack<>();

		return (isValid(expression, st) ? "possible" : "impossible");
	}

	private boolean isValid(String expression, Stack<Character> st) {

        /*
         * If we've reached the end of the input string,
         * return True only if the stack is empty.
         */
		if (expression.length() == 0) { return st.isEmpty(); }

		char c = expression.charAt(0);
		String s = expression.substring(1);  // Takes the first letter off.

        /*
         * If we encounter an opening character, push it on the stack,
         * and recursively call isValid() with the remaingins string
         */
		if (openCloseMap.containsValue(c)) {

			st.push(c);
			return isValid(s, st);

        /*
         * If we encounter a closing character, then the top item on the
         * stack had better be it's matching opening character.
         */
		} else if (openCloseMap.containsKey(c)) {

			Character expectedClosingChar = openCloseMap.get(c);

			if (st.isEmpty() || (st.pop() != expectedClosingChar)) {
				return false;
			} else {
				return isValid(s, st);
			}

			// We've encountered an 'X'
		} else {

			// Try replacing X with all characters.
			boolean canPush =
					isValid(")" + s, copyStack(st)) ||
							isValid("}" + s, copyStack(st)) ||
							isValid("]" + s, copyStack(st)) ||
							isValid("(" + s, copyStack(st)) ||
							isValid("{" + s, copyStack(st)) ||
							isValid("[" + s, copyStack(st));

			if (canPush) {
				return true;

            /*
             * If using X to add a character to the stack doesn't seem to
             * work, see if it can be used to take the top character off
             */
			} else {
				if (st.isEmpty()) { return false; }

				if (openCloseMap.containsKey(st.pop())) {
					return isValid(s, st);
				}
			}

			return false;
		}
	}

	/*
     * To preseve the state of the stack we're working with,
     * create a copy of it before trying possible substitutions for X
     */
	private Stack<Character> copyStack(Stack<Character> st) {

		Stack<Character> newStack = new Stack<>();
		Stack<Character> tempStack = new Stack<>();

		while (!st.isEmpty()) {
			tempStack.push(st.pop());
		}

		while (!tempStack.isEmpty()) {
			char c = tempStack.pop();
			st.push(c);
			newStack.push(c);
		}

		return newStack;
	}
}

