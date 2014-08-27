public class Salary {

    private static String DAY_START = "06:00:00";
    private static String DAY_END = "17:59:59";

    private static long convertTimeToSeconds(String time)  {

        String[] timeArray = time.split(":");
        int hours = Integer.parseInt(timeArray[0]);
        int minutes = Integer.parseInt(timeArray[1]);
        int seconds = Integer.parseInt(timeArray[2]);

        return (hours * 3600) + (minutes * 60) + seconds;
    }

    public int howMuch(String[] arrival, String[] departure, int wage) {

        long effectiveSecondsWorked = 0;
        long dayStart = convertTimeToSeconds(DAY_START);
        long dayEnd = convertTimeToSeconds(DAY_END);

        for (int i = 0; i < arrival.length; i++) {
            long shiftStart = convertTimeToSeconds(arrival[i]);
            long shiftEnd = convertTimeToSeconds(departure[i]);

            for (long j = shiftStart; j < shiftEnd; j++)  {
                if ((j >= dayStart) && (j <= dayEnd))  {
                    effectiveSecondsWorked += 2;
                } else  {
                    effectiveSecondsWorked += 3;
                }
            }
        }

        return (int) ((effectiveSecondsWorked * wage) / 7200);
    }
}
