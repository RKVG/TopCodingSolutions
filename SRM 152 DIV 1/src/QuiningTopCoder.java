import java.util.Stack;

public class QuiningTopCoder {

    private static final int MAX_CYCLES = 80000;
    private static final int MIN_STACK_VAL = -1000000000;
    private static final int MAX_STACK_VAL = 1000000000;

    /*
    * A custom version of the standard Stack.  This will return 0 if the user
    * attempts to pop a an empty stack (default behavior is to throw an
    * EmptyStackException).  Also checks the value being pushed to ensure
    * it is between MIN_STACK_VAL and MAX_STACK_VAL.  If not, it throws
    * an illegalArgumentException.
    */
    private class MyStack extends Stack<Integer> {

        public Integer pop() {
            return (isEmpty()) ? 0 : super.pop();
        }

        public Integer push(Integer i) throws IllegalArgumentException {

            if ((i < MIN_STACK_VAL) || (i > MAX_STACK_VAL)) {
                throw new IllegalArgumentException();
            }
            return super.push(i);
        }
    }


    // The function for updating the instruction pointer.
    private static int incIp(int n, int ip, int d) {
        return ((3 * n) + ip + d) % n;
    }

    // Method called by TopCoder.
    public String testCode(String source) {

        int ip = 0;
        int d = 1;
        int cycles = 0;
        int n = source.length();

        Stack<Integer> stack = new MyStack();

        StringBuilder output = new StringBuilder();

        try {

            while (cycles <= MAX_CYCLES) {

                char instruction = source.charAt(ip);

                /*
                 * '0'-'9': pushes the number represented by that digit onto
                 * the stack.
                 */
                if ((instruction >= '0') && (instruction <= '9')) {
                    stack.push(instruction - '0');
                    ip = incIp(n, ip, d);

                } else {

                    int x, y;

                    switch (instruction) {

                        // '$' : pops a value off the stack, and discards it.
                        case '$':
                            stack.pop();
                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * ':' : pops a value off the stack, then pushes that
                        * same value onto the stack twice.
                        */
                        case ':':
                            x = stack.pop();
                            stack.push(x);
                            stack.push(x);
                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * 'W' : Pops a value A, then pops a value B, then
                        * pushes A, then pushes B.
                        */
                        case 'W':
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x);
                            stack.push(y);
                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * ',' : pops a value X off of the stack, and prints the
                        * (absolute value of X)%Nth character in the source
                        * code.
                        */
                        case ',':
                            x = stack.pop();
                            x = Math.abs(x) % n;
                            output.append(source.charAt(x));

                            /*
                            * Whenever the output changes, check to see
                            * if we're done, or at least still on track.
                            * */
                            if (output.toString().equals(source)) {
                                return "QUINES " + cycles;
                            }
                            if (!source.startsWith(output.toString())) {
                                return "MISMATCH " + cycles;
                            }

                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * '+' : pops two values, adds them, and pushes the
                        * result back onto the stack.
                        */
                        case '+':
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x + y);
                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * '-' : pops two values, subtracts the second popped
                        * value from the first, and pushes the result back onto
                        * the stack.
                        */
                        case '-':
                            x = stack.pop();
                            y = stack.pop();
                            stack.push(x - y);
                            ip = incIp(n, ip, d);
                            break;

                        // '#' : multiplies D by 2 for this cycle only.
                        case '#':
                            ip = incIp(n, ip, (2 * d));
                            break;

                        // 'R' : multiplies D by -1.
                        case 'R':
                            d *= -1;
                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * 'S' : pops a value, and if positive pushes a 1, else
                        * pushes a -1.
                        */
                        case 'S':
                            x = stack.pop();

                            // 0 is treated at not positive.
                            if (x > 0) {
                                stack.push(1);
                            } else {
                                stack.push(-1);
                            }

                            ip = incIp(n, ip, d);
                            break;

                        // '_' : pops a value X, and sets D to that value X%N.
                        case '_':
                            x = stack.pop();
                            d = x % n;
                            ip = incIp(n, ip, d);
                            break;

                        /*
                        * 'J' : pops a value X, and sets IP to the (absolute
                        * value of X)%N. (IP is not incremented after this step)
                        */
                        case 'J':
                            x = stack.pop();
                            ip = Math.abs(x) % n;
                            break;

                        /*
                        * '@' : stops the program
                        * It must be a BADEND here, because if the output
                        * had matched the source, then we would have caught it
                        * in the ',' command.
                        */
                        case '@':
                            return "BADEND " + cycles;

                        // Should not reach this so long as the input is valid.
                        default:
                            return "ERROR bad command: " + instruction;

                    }
                }
                cycles++;
            }

            // Exceeded MAX_CYCLES
            return "TIMEOUT";

        } catch (IllegalArgumentException e) {

            // A value outside of MIN_STACK_VAL | MAX_STACK_VAL was pushed.
            return "OVERFLOW " + cycles;
        }
    }
}
