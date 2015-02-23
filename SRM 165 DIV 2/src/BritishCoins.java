public class BritishCoins {

    private static final int SHILLINGS_PER_POUND = 20;
    private static final int PENNIES_PER_SHILLING = 12;

    private static final int PENNIES_PER_POUND =
            PENNIES_PER_SHILLING * SHILLINGS_PER_POUND;

    public int[] coins(int pence)  {

        int[] ret = new int[3];

        ret[0] = pence / PENNIES_PER_POUND;
        ret[1] = (pence % PENNIES_PER_POUND) / PENNIES_PER_SHILLING;
        ret[2] = pence % PENNIES_PER_SHILLING;

        return ret;
    }
}
