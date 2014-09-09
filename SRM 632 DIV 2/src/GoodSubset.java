import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GoodSubset {

    /*
    * Stores a list of Integers along with their product.  Avoids having
    * to muliply the Integers together multiple times to get their product.
    * This class was added after the solution was working in an attempt to
    * improve performace.  A lot of time was being spent re-calculating
    * the products of these lists.
    * Note: I don't think it helped much...
    */
    class ListAndProduct {
        List<Integer> ints;
        int product;

        ListAndProduct(List<Integer> ints, int product)  {
            this.ints = ints;
            this.product = product;
        }
    }

    // Reset count each time it reaches this value.
    public static final int MOD_VALUE = 1_000_000_007;


    /*
    * The method called by the tests.  Obtains a Collection of ListAndProduct
    * objects, and then counts the number of items whose product equals
    * goodValue.
    */
    public int numberOfSubsets(int goodValue, int[] d) {

        if (d.length == 0) return 0;

        Collection<ListAndProduct> possibleGoodSubsets =
                getPossibleGoodSubsets(goodValue, d, 0);

        int count = 0;

        for (ListAndProduct lap : possibleGoodSubsets) {

            if (goodValue == lap.product) {
                count++;
                if (count == MOD_VALUE) count = 0;
            }

        }

        return count;

    }

    /*
    * Returns a Collection of ListAndProduct objects.  The product of of
    * each item will be a factor of goodValue.
    */
    private Collection<ListAndProduct> getPossibleGoodSubsets(
            int goodValue, int[] d, int index) {

        Collection<ListAndProduct> possibleGoodSubSets;

        /*
        * If this is the last element in d[] the create the return list,
        * otherwise, obtain it by recursively calling getPossibleSubsets using
        * the next index.
        */
        if (index == (d.length - 1)) {
            possibleGoodSubSets = new ArrayList<>();

        } else {
            possibleGoodSubSets = getPossibleGoodSubsets(
                    goodValue, d, index + 1);
        }

        // Only interested in numbers that are factors of goodValue.
        if (goodValue % d[index] == 0) {

            /*
            * Contains new items to be added to possibleGoodSubSets.  Don't
            * want to modify that list until the for loop is done though.
            */
            List<ListAndProduct> toAdd = new ArrayList<>();

            for (ListAndProduct lap : possibleGoodSubSets) {

                /*
                * For each of the items currently in the possibleGoodSubSets
                * Collection, does multiplying that product by d[index] also
                * result in a factor of goodValue?  If so, note it so it gets
                * added to the Collection.
                */
                long product = (long) d[index] * (long) lap.product;

                if ((goodValue % product) == 0) {

                    /*
                    * Create and store a new ListAndProduct object using the
                    * previous list of integers, and the current index.  Store
                    * the list along with its product.
                    */
                    List<Integer> newInts = new ArrayList<>();
                    for (int i : lap.ints) {
                        newInts.add(i);
                    }
                    newInts.add(d[index]);
                    toAdd.add(new ListAndProduct(newInts, (int) product));
                }

            }

            /*
            * possibleGoodSubSets could not be modified within the above for
            * loop.  So now, we can add all the items from toAdd into it.
            */
            for (ListAndProduct lap : toAdd) {
                possibleGoodSubSets.add(lap);
            }

            // The current index is a factor of goodValue, so add that in too.
            List<Integer> l = new ArrayList<>();
            l.add(d[index]);
            possibleGoodSubSets.add(new ListAndProduct(l, d[index]));
        }

        return possibleGoodSubSets;

    }
}



















































