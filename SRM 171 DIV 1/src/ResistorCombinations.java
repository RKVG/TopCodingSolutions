import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ResistorCombinations {

    public double closestValue(String[] resistances, double target) {

        double closest = 0;

        Set<String> possible = getCombinations(resistances);

        for (String s : possible)  {

            StringBuilder sb = new StringBuilder();
            sb.append(s);

            double d = getResistance(s);
            sb.append(" R:");
            sb.append(d);

            if (Math.abs(target - d) < (Math.abs(target - closest)))  {
                closest = d;
                sb.insert(0, "*** ");
                sb.append(" ");
                sb.append(Math.abs(target - d));
            }

            System.out.println(sb.toString());
        }

        return closest;

    }

    private Set<String> getCombinations(String[] resistors) {

        Set<String> possible = new HashSet<>();

        if (resistors.length == 0) {
            return possible;
        }

        if (resistors.length == 1) {
            possible.add(resistors[0]);
            return possible;
        }

        for (int i = 1; i < resistors.length; i++) {
            String[] r1Array = new String[i];
            System.arraycopy(resistors, 0, r1Array, 0, r1Array.length);
            Set<String> r1Set = getCombinations(r1Array);

            String[] r2Array = new String[resistors.length - i];
            System.arraycopy(resistors, i, r2Array, 0, r2Array.length);
            Set<String> r2Set = getCombinations(r2Array);

            for (String r1 : r1Set) {
                possible.add(r1);

                for (String r2 : r2Set) {
                    possible.add(r2);
//                    possible.add(r1 + " - " + r2);
//                    possible.add(r1 + " = " + r2);
                    possible.add("" + getResistance(r1 + " - " + r2));
                    possible.add("" + getResistance(r1 + " = " + r2));
                }
            }
        }

        return possible;
    }

    private double getResistance(String s)  {

        Scanner scanner = new Scanner(s);

        boolean addInSeries = true;

        double d = scanner.nextDouble();

        double returnValue = addResistor(0, d, addInSeries);

        while(scanner.hasNext())  {
            String operation = scanner.next(".");
            addInSeries = ("-".equals(operation));
            d = scanner.nextDouble();
            returnValue = addResistor(returnValue, d, addInSeries);
        }

        return returnValue;
    }

    private double addResistor(double r1, double r2, boolean inSeries)  {

        if (inSeries)  {
            return r1 + r2;
        } else  {
            return (r1 * r2) / (r1 + r2);
        }
    }
}


