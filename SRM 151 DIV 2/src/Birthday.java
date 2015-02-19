/*
TopCoder
Single Round Match: 151
Division: 2
Level: 2
Points: 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1739
 */

import java.util.ArrayList;
import java.util.Arrays;
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
		final String monthStr;
		final String dayStr;

		public Reminder(String s) {

			String s1[] = s.split("( )|(/)");
			month = Integer.parseInt(s1[0]);
			day = Integer.parseInt(s1[1]);
			monthStr = s1[0];
			dayStr = s1[1];
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

			return monthStr + "/" + dayStr;

		}
	}

	public String getNextImproved(String date, String[] birthdays) {

		Arrays.sort(birthdays);

		for (String next : birthdays) {
			if (next.compareTo(date) >= 0) {
				return next.split(" ")[0];
			}
		}

		return birthdays[0].split(" ")[0];
	}

}
