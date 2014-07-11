import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Birthday {

    public String getNext(String date, String[] birthdays) {

        List<Reminder> reminders = new ArrayList<>();
        for (String s : birthdays) {
            reminders.add(new Reminder(s));
        }
        Collections.sort(reminders);

        Reminder now = new Reminder(date);

        for (Reminder next : reminders) {
            if (next.compareTo(now) >= 0) {
                return next.toString();
            }
        }

        return reminders.get(0).toString();
    }

    public class Reminder implements Comparable {

        final int month;

        final int day;

        public Reminder(String s) {
            String s1[] = s.split("( )|(/)");
            month = Integer.parseInt(s1[0]);
            day = Integer.parseInt(s1[1]);
        }

        public int compareTo(Object o) {
            Reminder other = (Reminder) o;
            if (month < other.month) { return -1; }
            if (month > other.month) { return 1; }
            if (day < other.day) { return -1; }
            if (day > other.day) { return 1; }
            return 0;
        }

        public String toString() {

            StringBuilder sb = new StringBuilder(5);
            if ((month) < 10) {
                sb.append("0");
            }
            sb.append(month);
            sb.append("/");
            if ((day < 10)) {
                sb.append("0");
            }
            sb.append(day);

            return sb.toString();
        }
    }
}
