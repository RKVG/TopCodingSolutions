import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pricing {

    private static int calculatePrice(int[] pr, int a, int b, int c, int d) {

        int ret = 0;

        for (int aPr : pr) {
            if (aPr >= a) {
                ret += a;
            } else if (aPr >= b) {
                ret += b;
            } else if (aPr >= c) {
                ret += c;
            } else if (aPr >= d) {
                ret += d;
            }
        }

        return ret;
    }

    private static int uniquePrices(int[] price) {

        Set<Integer> pSet = new HashSet<>();

        for (int i : price) {
            pSet.add(i);
        }

        return pSet.size();
    }

    public int maxSales(int[] price) {

        if ((price.length <= 4) || (uniquePrices(price) <= 4)) {
            int x = 0;
            for (int aPrice : price) {
                x += aPrice;
            }
            return x;
        }

        // Reverse sort the array of prices.
        Arrays.sort(price);

        int s = 0;
        int e = price.length - 1;
        while (s < e) {
            int t = price[s];
            price[s] = price[e];
            price[e] = t;
            s++;
            e--;
        }

        int max = 0;

        for (int i = 0; i < price.length - 3; i++) {

            if (price[i] == price[i + 1]) {
                continue;
            }

            for (int j = i + 1; j < price.length - 2; j++) {

                if (price[j] == price[j + 1]) {
                    continue;
                }

                for (int k = j + 1; k < price.length - 1; k++) {

                    if (price[k] == price[k + 1]) {
                        continue;
                    }

                    for (int m = k + 1; m < price.length; m++) {

                        int p = calculatePrice(price, price[i], price[j],
                                price[k], price[m]);
                        if (p > max) {
                            max = p;
                        }
                    }
                }
            }
        }

        return max;
    }
}


