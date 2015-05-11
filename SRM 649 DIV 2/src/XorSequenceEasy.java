import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class XorSequenceEasy {
	
	public int getmax(int[] A, int N) {

        int maxPairs = 0;

        for (int i = 0; i < N; i++)  {
            int[] C = doXor(A, i);
            maxPairs = Math.max(maxPairs, countPairs(C));
        }

        return maxPairs;
	}

    private int[] doXor(int[] A, int b)  {
        int[] j = new int[A.length];

        for (int k=0; k<j.length; k++)  {
            j[k] = A[k] ^ b;
        }

        return j;
    }

    private int countPairs(int[] A)  {

        int numPairs = 0;

        for (int i=0; i <A.length - 1; i++ )  {
            for (int j = i + 1; j < A.length; j++)  {
                if (A[i] < A[j])  numPairs++;
            }
        }

        return numPairs;
    }
}
