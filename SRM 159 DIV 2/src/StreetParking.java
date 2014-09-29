public class StreetParking {
	
	public int freeParks(String street) {

        int numSpots = 0;

        for (int p = 0; p < street.length(); p++)  {
            if (isGoodParkingSpot(p, street))  {
                numSpots++;
            }
        }

        return numSpots;
	}

    private static boolean isGoodParkingSpot(int p, String s)  {

        // Is it directly in front of a private driveway.
        if (s.charAt(p) == 'D') return false;

        // Is it directly in front of a bus stop.
        if (s.charAt(p) == 'B') return false;

        // Is it 5 meters in front of a bus stop.
        if (((p + 1)  < s.length()) && (s.charAt(p + 1) == 'B')) return false;

        // Is it 10 meters in front of a bus stop.
        if (((p + 2) < s.length()) && (s.charAt(p + 2) == 'B')) return false;

        // Is it directly in front of a side-street.
        if (s.charAt(p) == 'S') return false;

        // Is it 5 meters before a side street.
        if (((p + 1)  < s.length()) && (s.charAt(p + 1) == 'S')) return false;

        // Is it 5 meters after a side street.
        if ((p > 0) && (s.charAt(p - 1)) == 'S') return false;

        return true;
    }
}
