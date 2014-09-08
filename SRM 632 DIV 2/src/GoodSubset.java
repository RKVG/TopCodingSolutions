import java.util.*;

public class GoodSubset {

    public static final int MOD_VALUE = 1_000_000_007;

    static private long count_num_subsets = 0L;
    static private long count_products = 0L;
    static private long count_possible = 0L;

    public int numberOfSubsets(int goodValue, int[] d) {

        count_num_subsets++;

        if (d.length == 0) return 0;

        List<List<Integer>> possibleGoodSubsets =
                getPossibleGoodSubsets(goodValue, d, 0);

        int count = 0;

        for (List<Integer> ints : possibleGoodSubsets) {

            if (goodValue == productOfInts(goodValue, ints)) {
                count++;
                if(count == MOD_VALUE) count = 0;
            }

        }

        System.out.println("Possible Guesses Size: " + possibleGoodSubsets.size());
        System.out.println("numberOfSubsets: " + count_num_subsets);
        System.out.println("productOfInts: " + count_products);
        System.out.println("getPossibleGoodSubsets: " + count_possible);

        return count;

    }


    private static long productOfInts(int goodValue, List<Integer> ints) {

        count_products++;

        long product = 1L;

        for (int i : ints) {

            product = product * (long)i;

            if (product > goodValue) {
                product = -1L;
                break;
            }

        }

        return product;
    }

    private static List<List<Integer>> getPossibleGoodSubsets(
            int goodValue, int[] d, int index) {

        count_possible++;

        List<List<Integer>> possibleGoodSubSets;

        if (index == (d.length - 1)) {
            possibleGoodSubSets = new ArrayList<>();
        } else {
            possibleGoodSubSets = getPossibleGoodSubsets(goodValue, d, index + 1);
        }

        if (goodValue % d[index] == 0) {

            List<List<Integer>> toAdd = new ArrayList<>();

            for (List<Integer> ints : possibleGoodSubSets) {

                long product = 1L;

                for (int i : ints) {

                    product = product * (long)i;

                    if (product > goodValue) {
                        product = -1L;
                        break;
                    }

                }

                product *= (long) d[index];

                if ((goodValue % product) == 0) {
                    List<Integer> newInts = new ArrayList<>();
                    for (int i : ints) {
                        newInts.add(i);
                    }
                    newInts.add(d[index]);
                    toAdd.add(newInts);
                }

            }

            for (List<Integer> l : toAdd) {
                possibleGoodSubSets.add(l);
            }

            List<Integer> l = new ArrayList<>();
            l.add(d[index]);
            possibleGoodSubSets.add(l);
        }

        return possibleGoodSubSets;

    }

    public static void main(String[] args) {

        int goodValue = 1837836000;

//        int goodValue = 1073741824;

        int[] d1 = new int[]{4914, 54054000, 4, 10725, 28728, 325684, 5569200,
                6909157, 351738, 89563, 4284, 229500, 300300, 78, 462000,
                462000, 5400, 836, 3454578, 143, 77000, 162568, 55115, 895631,
                3141600, 4845, 6732, 1890, 1870, 112200, 374, 89563, 330, 20475,
                17671500, 8353800, 2550, 69300, 6650, 12376, 280, 448800,
                2198368, 6300, 91891800, 21736, 1285200, 3465, 4606105,
                1039500, 2700, 513, 198900, 16380, 950, 2200, 235620, 760,
                5890500, 33150, 33, 1836, 396, 22440, 3400, 4836410, 400400,
                14586000, 38675, 14212, 67736, 58500, 26, 4773600, 18378360,
                1638000, 221000, 6669, 1755, 200, 3553, 680, 138600, 596700,
                21945, 654500, 56898, 8008, 177157, 2931157, 440, 1071000,
                74406, 425, 11628, 95, 18525, 163800, 28728, 570};

        int[] d = new int[]{65536, 1, 8, 2048, 4096, 4096, 256, 524288, 2,
                1024, 4194304, 134217728, 67108864, 2097152, 32, 1024, 1, 512,
                524288, 512, 4194304, 4194304, 8192, 16777216, 2, 32, 16384, 32,
                16777216, 2048, 524288, 131072, 8192, 64, 524288, 67108864,
                2048, 32768, 32, 262144, 2, 16, 4096, 33554432, 1, 1073741824,
                268435456, 512, 1048576, 134217728, 262144, 256, 1048576,
                4194304, 1073741824, 134217728, 8, 262144, 268435456, 128};
//                268435456, 1073741824, 512, 268435456, 32, 1048576, 128,
//                67108864, 4, 64, 64, 8388608, 4194304, 512, 524288, 8192, 2, 128,
//                16777216, 512, 4194304, 16, 1048576, 32768, 1073741824, 512,
//                33554432, 16777216, 536870912, 67108864, 268435456, 512,
//                1073741824, 32, 4, 4194304, 131072, 2048, 1024, 8192};


        int count = 0;

        for (int i : d)  {
            if (goodValue % i == 0)  {
                count++;
            }
        }

        System.out.println(d.length + "\t" + count);

    }
}



















































