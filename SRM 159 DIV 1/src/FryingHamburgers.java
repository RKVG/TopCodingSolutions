public class FryingHamburgers {

	private static final int MINS_PER_SIDE = 5;
	private static final int MINS_PER_BURGER = 2 * MINS_PER_SIDE;

	public int howLong(int panSize, int hamburgers) {

		// If there are no hamburgers, it takes no time.
		if (hamburgers == 0)  return 0;

		// All the hamburgers can fit on one pan.
		if (hamburgers <= panSize)  return MINS_PER_BURGER;

		// The hamburgers divide evenly by panSize
		if ((hamburgers % panSize) == 0)  {
			return (hamburgers / panSize) * MINS_PER_BURGER;
		}

		/*
		* If the remainder is <= panSize, we can use the trick described in
		* the tests to save the cooking time of one side.
		*/
		if ((hamburgers % panSize) <= (panSize / 2))  {
			return ((hamburgers / panSize + 1) * MINS_PER_BURGER)
					- MINS_PER_SIDE;
		}

		// Worst case, we just cook one side, then the other.
		return (hamburgers / panSize + 1) * MINS_PER_BURGER;

	}
}
