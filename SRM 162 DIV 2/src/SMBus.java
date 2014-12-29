import java.util.HashSet;
import java.util.Set;

public class SMBus {

    /*
    * Represents a device that wishes to transmit a message.  Contains
    * the message it wants to send, and how long it takes to send each
    * byte.
    */
    class Master {

        final String message;
        final int time;

        Master(String message, int time) {
            this.message = message;
            this.time = time;
        }
    }

    /*
    * Represents the SMBus.  Master objects may call setChar() and setTime()
    * to put the next character in their message, and the time required to
    * transmit onto the bus.  SMBus will keep track of the lowest value
    * character, and the greatest time.
    */
    class Bus {

        /*
        * Bigger than any legal character.  Expected to be over written when
        * the first character is set.
        */
        private final char MAX_CHAR = '9' + 1;

        StringBuilder message = new StringBuilder();
        int charIdx = 0;
        int time = 0;

        Bus() {
            reset();
        }

        void reset() {
            message = new StringBuilder();
            message.append(MAX_CHAR);
            time = 0;
            charIdx = 0;
        }

        // Creates a place holder for the next character.
        void nextChar() {
            message.append(MAX_CHAR);
            charIdx++;
        }


        // Keeps the lesser of the current character, and the parameter c.
        void setChar(char c) {
            if (c < message.charAt(charIdx)) {
                message.setCharAt(charIdx, c);
            }
        }

        // Keeps the greater of the current time, and the parameter t.
        void setTime(int t) {
            time = Math.max(time, t);
        }

        int getTime() {
            return time;
        }

        void clearTime() {
            time = 0;
        }

        /*
        * Returns the current value in the message.  Removes the last
        * character, since that will be a place holder.
        */
        String getMessage() {
            return message.substring(0, message.length() - 1);
        }

    }

    // The method called by TopCoder.
    public int transmitTime(String[] messages, int[] times) {

        int time = 0;

        Bus bus = new Bus();

        // Holds all the masters that have not finished sending their message.
        Set<Master> incomplete = new HashSet<>();

        // Populate incomplete using the given parameters.
        for (int i = 0; i < messages.length; i++) {
            incomplete.add(new Master(messages[i], times[i]));
        }

        while (!incomplete.isEmpty()) {

            bus.reset();

            boolean messageComplete = false;

            // Loop until some master is able to complete their message.
            while (!messageComplete) {

                String currentMessage = bus.getMessage();

                /*
                * If a message has been completed, we'll store a reference
                * to it here.
                */
                Master completed = null;

                // Look for a completed message.
                for (Master m : incomplete) {
                    if (m.message.equals(currentMessage)) {
                        completed = m;
                        break;
                    }
                }

                /*
                * If we've found a completed message, remove its master
                * from the incomplete list.  Set messageComplete to true
                * so we can prepare for a new message to start.
                */
                if (completed != null) {
                    incomplete.remove(completed);
                    messageComplete = true;

                } else {

                    /*
                    * Otherwise.  Put the least character, and the greatest
                    * time onto the bus.
                    */
                    for (Master m : incomplete) {

                        /*
                        * Only consider masters whose message still matches
                        * the current pattern.
                        */
                        if (m.message.startsWith(currentMessage)) {
                            bus.setChar(m.message.charAt(bus.charIdx));
                            bus.setTime(m.time);
                        }
                    }

                    time += bus.getTime();

                    // Prepare for the next character.
                    bus.clearTime();
                    bus.nextChar();
                }
            }
        }
        return time;
    }
}
