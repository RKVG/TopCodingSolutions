public class Removal {
	
	public int finalPos(int n, int k, String[] remove) {

		for (int i = remove.length - 1; i >= 0; i--)  {

			String[] hilo = remove[i].split("-");
			int lo = Integer.parseInt(hilo[0]);
			int hi = Integer.parseInt(hilo[1]);

			if (k >= lo)  {
				k += (hi - lo + 1);
			}

			// If k < 0, then we've overflowed, return a -1.
			if ((k > n) || (k < 0)) return -1;
		}

		return k;
	}

}
