public class RPG {
	
	public int[] dieRolls(String[] dice) {

        int min = 0;
        int max = 0;

        for (int d = 0; d < dice.length; d++)  {

            /*
            * Splits the string into the parts before and after the 'd'
            */
            String[] s = dice[d].split("d");

            int rolls = Integer.parseInt(s[0]);
            int die = Integer.parseInt(s[1]);

            min += rolls;
            max += (rolls * die);
        }

        int average = ((max - min) / 2) + min;

        return new int[] {min, max, average};
    }


}
