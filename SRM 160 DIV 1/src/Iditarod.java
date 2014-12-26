public class Iditarod {
	
	public int avgMinutes(String[] times) {

		int totalMinutes = 0;

		// Add up the total minutes for each finishing time.
		for (String t : times)  {
			totalMinutes += calcMinutes(t);
		}

		// Get the average.
		double avg = (double) totalMinutes / (double) times.length;

		// Round off by adding .5 and truncating.
		avg += 0.5;
		return (int) avg;
	}

	private static int calcMinutes(String s)  {

		// Format is: hh:mm xM, DAY n

		int hours = Integer.parseInt(s.substring(0,2));
		int minutes = Integer.parseInt(s.substring(3,5));
		boolean isPM = (s.charAt(6) == 'P');

		// Handles both 1 and 2 digit day lengths.
		int day = Integer.parseInt(s.substring(14, s.length()));

		// Handle 12 PM and 12 AM hours
		if (hours == 12)  {
			if (isPM)  {
				hours = 0;
			} else {
				hours = 24;
				day -= 1;
			}
		}

		if (isPM) hours += 12;

		// Subtract off the start time.
		hours -= 8;

		// Minutes per day, times number of days (don't count day 1)
		int totalMinutes = (24*60) * (day - 1);

		totalMinutes += (60 * hours);

		totalMinutes += minutes;

		return totalMinutes;
	}

}
