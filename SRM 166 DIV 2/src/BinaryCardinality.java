import java.util.Arrays;
import java.util.Comparator;

public class BinaryCardinality {

    private class BinaryCardinalityComparator implements Comparator<Integer>  {

        /*
        * Compares the binary cardinality of the two numbers.  If that's
        * equal, then compare the value of the numbers themselves.
        */
        @Override
        public int compare(Integer o1, Integer o2) {

            int c1 = binaryCardinality(o1);
            int c2 = binaryCardinality(o2);

            if (c1 < c2) return -1;
            if (c2 < c1) return 1;

            return o1.compareTo(o2);
        }

        /*
        * Counts the number of 1's in the binary representation of the number.
        */
        public int binaryCardinality(Integer i)  {

            int c = 0;

            while (i > 0)  {
                if ((i & 1) == 1) c++;
                i = i >> 1;
            }

            return c;
        }
    }

    public int[] arrange(int[] numbers) {

        // Convert array of ints to an array of Integer
        Integer[] numbersAsIntegers = new Integer[numbers.length];

        for (int i = 0; i < numbers.length; i++)  {
            numbersAsIntegers[i] = numbers[i];
        }

        // Sort the numbers using our custom Comparator.
        Arrays.sort(numbersAsIntegers, new BinaryCardinalityComparator());

        // Convert array of Integer back to array of ints.
        int[] result2 = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++)  {
            result2[i] = numbersAsIntegers[i];
        }

        return result2;
    }

}
