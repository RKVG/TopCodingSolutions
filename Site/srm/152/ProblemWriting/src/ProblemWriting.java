/*
TopCoder
Single Round Match: 152
Division: 2
Level: 3
Points: 1000
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1763
 */

public class ProblemWriting {

    private static final String ERROR_LENGTH = "dotForm must contain between " +
            "1 and 25 characters, inclusive.";

    // Replace the 'X' with the position where it failed.
    private static final String ERROR_FORM = "dotForm is not in dot notation," +
            " check character X.";

    public String myCheckData(String dotForm) {

        // First check that we meet the length requirements.
        if ((dotForm == null) || (dotForm.length() < 1) ||
                (dotForm.length() > 25)) {
            return ERROR_LENGTH;
        }

        StateMachine m = new StateMachine();

        /*
         * Use the state machine to process each character of the input.
         * After each transition, check that we are in a valid state.
         */
        for (int i = 0; i < dotForm.length(); i++) {
            m.transition(dotForm.charAt(i));

            if (!m.isValidState()) {
                return ERROR_FORM.replace("X", "" + i);
            }
        }

        // When done, make sure we're in a valid end state.
        if (m.isEndState()) {
            return "";
        }

        // Otherwise, return an error - we're expecting more characters.
        return ERROR_FORM.replace("X", "" + dotForm.length());

    }

    /*
     * StateMachine will help us keep track of the valid next characters
     * given our current state.
     */
    private class StateMachine {

        private final int STATE_START = 0;
        private final int STATE_NUMBER = 1;
        private final int STATE_DOT1 = 2;
        private final int STATE_OPERATOR = 3;
        private final int STATE_DOT2 = 4;
        private final int STATE_ERROR = -1;

        private int state = STATE_START;

        public boolean isValidState() {

            return (state != STATE_ERROR);
        }

        public boolean isEndState() {

            return (state == STATE_NUMBER);
        }

        /*
         * Using the char c, and our current state, determine the next state.
         * There is no return from STATE_ERROR.
         */
        public void transition(char c) {

            if (state == STATE_START) {
                if (isNumber(c)) {
                    state = STATE_NUMBER;
                } else {
                    state = STATE_ERROR;
                }

            } else if (state == STATE_NUMBER) {
                if (isDot(c)) {
                    state = STATE_DOT1;
                } else if (isOperator(c)) {
                    state = STATE_OPERATOR;
                } else {
                    state = STATE_ERROR;
                }

            } else if (state == STATE_DOT1) {
                if (isDot(c)) {
                    state = STATE_DOT1;
                } else if (isOperator(c)) {
                    state = STATE_OPERATOR;
                } else {
                    state = STATE_ERROR;
                }

            } else if (state == STATE_OPERATOR) {
                if (isDot(c)) {
                    state = STATE_DOT2;
                } else if (isNumber(c)) {
                    state = STATE_NUMBER;
                } else {
                    state = STATE_ERROR;
                }

            } else if (state == STATE_DOT2) {
                if (isDot(c)) {
                    state = STATE_DOT2;
                } else if (isNumber(c)) {
                    state = STATE_NUMBER;
                } else {
                    state = STATE_ERROR;
                }
            }
        }

        private boolean isNumber(char c) {

            return ((c >= '0') && (c <= '9'));
        }

        private boolean isOperator(char c) {

            return ((c == '+') || (c == '-') || (c == '*') || (c == '/'));
        }

        // Didn't need a method for this, but it's better to be consistent.
        private boolean isDot(char c) {

            return (c == '.');
        }

    }

}
