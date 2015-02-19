import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarRecycle {

	public int useAgain(int year) {

		boolean firstYearIsLeap = isLeapYear(year);

		int dayOfWeek = 0;

		while(true)  {

			// Determine which day the next year starts on.
			dayOfWeek += 365;
			if (isLeapYear(year)) dayOfWeek++;
			dayOfWeek %= 7;

			year++;

			/*
			* If the next year starts on the same day of the week, and they
			* have the same leap year status, then return.
			*/
			if ((dayOfWeek == 0) && (firstYearIsLeap == isLeapYear(year)))  {
				return year;
			}
		}

	}

	private static boolean isLeapYear(int year)  {

		// If the year is divisible by 4
		if ((year % 4) == 0)  {

			// And not divisible by 100, unless also divisible by 400
			if ((year % 100 != 0) || ((year % 400) == 0))  {
				return true;
			}
		}

		return false;
	}



	/*
	* An alternate solution using Java's GregorianCalendar.
	*/
	public int useAgain2(int year)  {

		GregorianCalendar c = new GregorianCalendar(year, Calendar.JANUARY, 1);
		int initialDayOfWeek = c.get(Calendar.DAY_OF_WEEK);

		while (true)  {
			c.add(Calendar.YEAR, 1);
			if ((c.get(Calendar.DAY_OF_WEEK) == initialDayOfWeek) &&
					(c.isLeapYear(c.get(Calendar.YEAR)) == c.isLeapYear(year))) {
				return c.get(Calendar.YEAR);
			}
		}
	}
}
