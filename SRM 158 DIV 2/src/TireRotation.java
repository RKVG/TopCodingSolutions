public class TireRotation {
	
	public int getCycle(String initial, String current) {

        // Start at phase 1 and the initial pattern.
        int phase = 1;
        String s = initial;

        /*
        * Loop until we either match the current pattern, or have cycled
        * through all 4 phases.
        */
        while ((phase < 5) && (!s.equals(current))) {
            s = rotateTires(s);
            phase++;
        }

        /*
        * If phase is > 4, then the pattern was invalid, return -1.
        * Otherwise return phase.
        */
        return (phase > 4) ? -1 : phase;
    }

    /*
    * Returns a String representing the new tire pattern after performing
    * a rotation.
    * The tire in:
    * position 1, c[0] receives the tire from position 4, charAt(3)
    * position 2, c[1] receives the tire from position 3, charAt(2)
    * position 3, c[2] receives the tire from position 1, charAt(0)
    * position 4, c[3] receives the tire from position 2, charAt(1)
    */
    private static String rotateTires(String s)  {

        char[] c = new char[4];

        c[0] = s.charAt(3);
        c[1] = s.charAt(2);
        c[2] = s.charAt(0);
        c[3] = s.charAt(1);

        return new String(c);
    }
}
