import java.util.ArrayList;
import java.util.List;

public class Animation {

	public static final char EMPTY_POSITION = '.';
	public static final char OCCUPIED_POSITION = 'X';
	public static final char RIGHT = 'R';
	public static final char LEFT = 'L';

	// If the position contains both a R and L moving particle.
	public static final char BOTH = 'B';

	public String[] animate(int speed, String init) {

		List<String> result = new ArrayList<>();

		result.add(init);

		String prevFrame = init;

		while(!isEmptyChamber(prevFrame))  {
			char[] nextFrame = new char[init.length()];

			// Initialize the chamber to all empty;
			for (int i = 0; i < nextFrame.length; i++)  {
				nextFrame[i] = EMPTY_POSITION;
			}

			for (int i = 0; i < prevFrame.length(); i++)  {
				if (prevFrame.charAt(i) != EMPTY_POSITION)  {

					if ((prevFrame.charAt(i) == RIGHT) || (prevFrame.charAt(i) == BOTH))  {
						int newPos = i + speed;
						if (newPos < nextFrame.length)  {
							if (nextFrame[newPos] == LEFT) {
								nextFrame[newPos] = BOTH;
							} else  {
								nextFrame[newPos] = RIGHT;
							}
						}
					}

					if ((prevFrame.charAt(i) == LEFT) || (prevFrame.charAt(i) == BOTH))  {
						int newPos = i - speed;
						if (newPos >= 0)  {
							if (nextFrame[newPos] == RIGHT)  {
								nextFrame[newPos] = BOTH;
							} else  {
								nextFrame[newPos] = LEFT;
							}
						}
					}

				}
			}

			String s = new String(nextFrame);
			result.add(s);
			prevFrame = s;

		}

		// Convert the List into a String[] and return it.
		String[] resultList = new String[result.size()];

		for (int i = 0; i < result.size(); i++)  {
			resultList[i] = markOccupied(result.get(i));
		}
		return resultList;
	}

	/*
	* Replaces any position marked with a 'R', 'L', or 'B'
	* with an 'X'
	*/
	private static String markOccupied(String s)  {

		StringBuilder sb = new StringBuilder(s.length());

		for (int i = 0; i < s.length(); i++)  {
			sb.append((s.charAt(i) == EMPTY_POSITION) ? EMPTY_POSITION : OCCUPIED_POSITION);
		}

		return sb.toString();
	}

	/*
	* Returns true iff the chamber is empty.
	*/
	private static boolean isEmptyChamber(String s)  {

		for (int i = 0; i < s.length(); i++)  {
			if (s.charAt(i) != EMPTY_POSITION)  return false;
		}

		return true;
	}
}
