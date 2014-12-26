import java.util.ArrayList;
import java.util.List;

public class IsHomomorphism {
	
	public String[] numBad(String[] source, String[] target, int[] mapping) {

		List<String> results = new ArrayList<>();

		for (int a = 0; a < source.length; a++)  {
			for (int b = 0; b < source.length; b++)  {

				/*
				* Testing:
				* mappings(a@b) = mappings(a)~mappings(b)
				* for all values of a and b.
				*/

				/*
				* For the '@' operator, the first value given is the index into
				* the source array, and the second value gives the character
				* we're interested in.
				*/
				int leftSide = mapping[source[a].charAt(b) - '0'];

				// Same for the '~' operator, except use the target array
				int rightSide = target[mapping[a]].charAt(mapping[b]) - '0';

				// If the sides are not equal, add the pair to the results list.
				if (leftSide != rightSide) {
					results.add("(" + a + "," + b + ")");
				}
			}
		}

		// Convert the List to an array and return it.
		String[] ret = new String[results.size()];
		for (int i = 0; i < ret.length; i++)  {
			ret[i] = results.get(i);
		}

		return ret;
	}
}
