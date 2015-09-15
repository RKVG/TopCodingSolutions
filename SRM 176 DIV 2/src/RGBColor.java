import java.util.*;
import java.math.*;
import static java.lang.Math.*;

public class RGBColor {

    private static final int RGB_MAX = 255;
    private static final int GREY_TOLERANCE = 32;

	public int[] getComplement(int[] rgb) {

		int[] compliment = new int[rgb.length];

        boolean isGrey = true;

        for (int i = 0; i < rgb.length; i++)  {
            compliment[i] = RGB_MAX - rgb[i];
            if (Math.abs(rgb[i] - compliment[i]) > GREY_TOLERANCE) isGrey = false;
        }

        if (isGrey)  {
            for (int i = 0; i < rgb.length; i++)  {
                compliment[i] = (rgb[i] >= 128) ? rgb[i] - 128 : rgb[i] + 128;
            }
        }

        return compliment;

	}
}
