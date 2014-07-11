/*
TopCoder
Single Round Match: 147
Division: 2
Level: 2
Points: 600
Description: http://community.topcoder.com/stat?c=problem_statement&amp;pm=1225
 */

public class PeopleCircle {

    private char[] circle;

    public String order(int numMales, int numFemales, int K) {

        // Creates a new array large enough to hold all males and females.
        circle = new char[numMales + numFemales];

        /*
          Initialize the circle to have numMales. This is the problem's
          ending condition.  We'll work backwards from here.
         */
        for (int i = 0; i < numMales; i++) {
            circle[i] = 'M';
        }

        /*
       Set the initial positions to be just after the number of males.  When
        problem description has finished, the circle will have all males,
        the last female will have just been removed.
        */
        int position = numMales;
        int numAdded = 0;

        // Check for the case where there were no females to start with.
        if (numFemales == 0) {
            return new String(circle);
        }

        /*
        Count back and insert females until all have been added.
         */
        while (numAdded < numFemales) {
            insertFemale(position);
            numAdded++;
            position = position - K + 1;

            // Loop around to the back of the array
            while (position < 0) {
                position += numMales + numAdded;
            }
        }

        /*
        Construct the return string by taking the elements to the right
        of the current positions, and then adding the elements from the
        beginning of the circle up to the current position.
         */
        String s1 = new String(circle).substring(position);
        String s2 = new String(circle).substring(0, position);
        return s1 + s2;
    }

    /*
    Inserts a female ('F') at the given positions.
    Shifts everything to the right of pos one spot further to the right
    creating a space to insert the new character.
     */
    private void insertFemale(int pos) {

        /*
        Works backward from the end of the array shifting everything
        over to the right.
         */
        for (int i = circle.length - 1; i > pos; i--) {
            circle[i] = circle[i - 1];
        }

        circle[pos] = 'F';
    }
}
