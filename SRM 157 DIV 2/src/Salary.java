public class Salary {

	private static String DAY_START = "06:00:00";
	private static String DAY_END = "17:59:59";

	/*
    * Converts the current time to the number of seconds since midnight
    */
	private static long convertTimeToSeconds(String time)  {

		String[] timeArray = time.split(":");
		int hours = Integer.parseInt(timeArray[0]);
		int minutes = Integer.parseInt(timeArray[1]);
		int seconds = Integer.parseInt(timeArray[2]);

		return (hours * 3600) + (minutes * 60) + seconds;
	}

	public int howMuch(String[] arrival, String[] departure, int wage) {

        /*
        * The number of seconds worked, modified for evening and night time.
        * To avoid using decimals (float or long), we'll count each day
        * shift second as 2, and each evening/night shift second as 3.
        * Then, at the very end, divide the total by 2.
        */
		long effectiveSecondsWorked = 0;

		// Markers for the start and end of the day shifts.
		long dayStart = convertTimeToSeconds(DAY_START);
		long dayEnd = convertTimeToSeconds(DAY_END);


		for (int i = 0; i < arrival.length; i++) {

			long shiftStart = convertTimeToSeconds(arrival[i]);
			long shiftEnd = convertTimeToSeconds(departure[i]);

			// Loop through each secod of the shift.
			for (long j = shiftStart; j < shiftEnd; j++)  {

                /*
                * If the current second is part of the day shift, increment the
                * count by 2.
                */
				if ((j >= dayStart) && (j <= dayEnd))  {
					effectiveSecondsWorked += 2;

                /*
                * If it's part of an evening or night shift, increment the count
                * by 3.
                */
				} else  {
					effectiveSecondsWorked += 3;
				}
			}
		}

        /*
        * Multiply the wage by the number of hours worked.  Note that there are
        * 60 * 60 = 3600 seconds in an hour, but since we doubled that when
        * counting the seconds, we need to divide by 2 * 3600 = 7200
        */
		return (int) ((effectiveSecondsWorked * wage) / 7200);
	}
}