import java.util.HashSet;
import java.util.Set;

public class StringTrain {

    // The method called by TopCoder
    public String buildTrain(String[] cars) {

        String train = cars[0];

        // Process each car in turn.
        for (int i = 1; i < cars.length; i++) {
            train = processCar(train, cars[i]);
        }

        // Get the train length before removing characters.
        int trainLength1 = train.length();

        train = removeAllButLastChar(train);

        return trainLength1 + " " + train;
    }

    private static String processCar(String train, String car) {

        int trainIdx = 0;
        int carIdx = 0;

        while (trainIdx < train.length()) {

            /*
            * Move forward through the characters in train until one that
            * matches the first character of car is found.
            */
            while ((trainIdx < train.length()) &&
                    (car.charAt(carIdx) != train.charAt(trainIdx))) {
                trainIdx++;
            }

            // If we reach the end of train, return train.
            if (trainIdx == train.length()) {
                return train;
            }

            // Mark the start of this possible suffix.
            int startOfSuffix = trainIdx;

            /*
            * While the characters match, and we haven't reached the
            * end of either string, move to the next character of each string.
            */
            while ((trainIdx < train.length()) &&
                    (carIdx < car.length()) &&
                    (car.charAt(carIdx) == train.charAt(trainIdx))) {
                trainIdx++;
                carIdx++;
            }

            // If we've reached the end of the train.
            if (trainIdx == train.length()) {

                /*
                * If startOfSuffix == 0, then the entire train String
                * is being used.  If carIdx == car.length, then the entire
                * car String is used.  In either case, it's not a proper
                * pre/suf-fix.
                */
                if ((startOfSuffix != 0) && (carIdx < car.length())) {

                    /*
                    * Create the return string by starting with train as the
                    * base and adding the remaining characters from car.
                    */
                    StringBuilder sb = new StringBuilder();
                    sb.append(train);
                    for (int i = carIdx; i < car.length(); i++) {
                        sb.append(car.charAt(i));
                    }
                    return sb.toString();
                }
            }

            // Move train index forward, and reset the car index.  Try again.
            trainIdx = startOfSuffix + 1;
            carIdx = 0;

        }

        return train;
    }

    private static String removeAllButLastChar(String s) {

        // This set contains all characters that have been seen.
        Set<Character> usedChars = new HashSet<>();

        StringBuilder sb = new StringBuilder(s.length());

        /*
        * Work backward from the end of the String to the front.
        * Add characters to the output only if they are not in the usedChars
        * set.  When a new character is encountered, add it to the front
        * of the output, and add the character to usedChars so it is not
        * added again.
        */
        for (int i = s.length() - 1; i >= 0; i--) {
            if (!usedChars.contains(s.charAt(i))) {
                usedChars.add(s.charAt(i));
                sb.insert(0, s.charAt(i));
            }
        }

        return sb.toString();

    }

}
