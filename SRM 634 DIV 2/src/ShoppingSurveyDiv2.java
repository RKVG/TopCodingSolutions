public class ShoppingSurveyDiv2 {

    public int minValue(int N, int[] s) {

        int numItemsPurchased = 0;

        for (int i : s) {
            numItemsPurchased += i;
        }

        int maxItemsPurchasedWithNoBigShoppers = (s.length - 1) * N;

        int numBigShoppers =
                numItemsPurchased - maxItemsPurchasedWithNoBigShoppers;

        return (numBigShoppers < 0) ? 0 : numBigShoppers;

    }
}
