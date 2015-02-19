import java.util.PriorityQueue;
import java.util.Queue;

public class PartySeats {

    public String[] seating(String[] attendees) {

        /*
        * Separate the boys from the girls.  By using a PriorityQueue, we
        * can easily pull out members in ascending order.
        */
        Queue<String> boys = new PriorityQueue<>();
        Queue<String> girls = new PriorityQueue<>();

        for (String s : attendees) {
            String[] attendee = s.split("\\s+");
            if ("boy".equals(attendee[1])) {
                boys.add(attendee[0]);
            } else {
                girls.add(attendee[0]);
            }
        }

        /*
        * Ensure the arrangement is possible.
        * The number of boys and girls must be equal, and both must be an
        * even number.
        */
        if ((boys.size() != girls.size()) || ((boys.size() % 2) != 0)) {
            return new String[0];
        }

        String[] result = new String[attendees.length + 2];
        result[0] = "HOST";
        boolean isBoyNext = false;

        for (int i = 1; i < result.length; i++) {

            // Seat the Hostess at the 1/2 way point.
            if (i == (result.length / 2)) {
                result[i] = "HOSTESS";

            } else {
                if (isBoyNext) {
                    result[i] = boys.poll();
                } else {
                    result[i] = girls.poll();
                }
            }

            isBoyNext = !isBoyNext;
        }

        return result;
    }
}
