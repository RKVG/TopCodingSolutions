

public class BirthdayOdds {
	
	public int minPeople(int minOdds, int daysInYear) {

		double pA = 1.0;
		double days = (double) daysInYear;
		double cutOff = 1.0 - (minOdds / 100.0);

		int numPeople = 1;

		while (pA > cutOff)  {
			pA *= ((double) (daysInYear - numPeople) / days);
			numPeople++;
		}

		return numPeople;

	}
}
