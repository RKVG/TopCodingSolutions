/*
TopCoder
Single Round Match: 151
Division: 2 / 1
Level: 3 / 2
Points: 1000 / 500
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1705
 */

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    private int numCompares = 0;

    public int howManyComparisons(int[] numbers) {

        // Convert the int[] into a List
        List list = new ArrayList<Integer>(numbers.length);

        for (int i : numbers) {
            list.add(i);
        }

        mergeSort(list);

        return numCompares;
    }

    private List<Integer> mergeSort(List a) {

        if (a.size() <= 1) { return a; }

        List sb = mergeSort(a.subList(0, a.size() / 2));
        List sc = mergeSort(a.subList((a.size() / 2), a.size()));

        return merge(sb, sc);
    }

    private List merge(List<Integer> b, List<Integer> c) {

        /*
         * It's important that new Lists are created here to hold copies of b
         * and c. Otherwise, we run the risk of a concurrent modification
         * exception when we start removing elements
         */
        List<Integer> b1 = new ArrayList<>();
        List<Integer> c1 = new ArrayList<>();

        b1.addAll(b);
        c1.addAll(c);

        // We know the final size of the List, might as well provide it.
        List a = new ArrayList(b.size() + c.size());

        while (!b1.isEmpty() && !c1.isEmpty()) {

            int x = b1.get(0);
            int y = c1.get(0);

            numCompares++;
            if (x < y) {
                a.add(b1.remove(0));
            } else if (x > y) {
                a.add(c1.remove(0));
            } else {
                a.add(b1.remove(0));
                a.add(c1.remove(0));
            }

        }

        if (!b1.isEmpty()) { a.addAll(b1); }

        if (!c1.isEmpty()) { a.addAll(c1); }

        return a;
    }
}
