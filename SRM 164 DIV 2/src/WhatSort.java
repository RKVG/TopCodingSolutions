import java.util.Arrays;
import java.util.Comparator;

class Person {

    final int age;
    final int weight;
    final String name;

    Person(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class PersonComparator implements Comparator<Person> {

    final String type;

    PersonComparator(String type) {
        this.type = type;
    }

    @Override
    public int compare(Person p1, Person p2) {

        int x;

        switch (type) {
            case "NAW":
                x = compareName(p1, p2);
                if (x != 0) return x;
                x = compareAge(p1, p2);
                if (x != 0) return x;
                return compareWeight(p1, p2);

            case "NWA":
                x = compareName(p1, p2);
                if (x != 0) return x;
                x = compareWeight(p1, p2);
                if (x != 0) return x;
                return compareAge(p1, p2);

            case "ANW":
                x = compareAge(p1, p2);
                if (x != 0) return x;
                x = compareName(p1, p2);
                if (x != 0) return x;
                return compareWeight(p1, p2);

            case "AWN":
                x = compareAge(p1, p2);
                if (x != 0) return x;
                x = compareWeight(p1, p2);
                if (x != 0) return x;
                return compareName(p1, p2);

            case "WAN":
                x = compareWeight(p1, p2);
                if (x != 0) return x;
                x = compareAge(p1, p2);
                if (x != 0) return x;
                return compareName(p1, p2);

            case "WNA":
                x = compareWeight(p1, p2);
                if (x != 0) return x;
                x = compareName(p1, p2);
                if (x != 0) return x;
                return compareAge(p1, p2);

            default:
                return 0;
        }

    }

    private int compareName(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }

    private int compareAge(Person p1, Person p2) {
        return new Integer(p1.age).compareTo(p2.age);
    }

    private int compareWeight(Person p1, Person p2) {
        return -1 * new Integer(p1.weight).compareTo(p2.weight);
    }
}

public class WhatSort {

    public String sortType(String[] name, int[] age, int[] wt) {

        Person[] inputList = new Person[name.length];

        for (int i = 0; i < name.length; i++) {
            Person p = new Person(name[i], age[i], wt[i]);
            inputList[i] = p;
        }

        String method = null;

        String[] sortingMethods = new String[]{"NAW", "NWA", "ANW",
                "AWN", "WAN", "WNA"};

        for (String s : sortingMethods) {
            String result = testSortingMethod(inputList, s);
            if (result != null) {
                if (method != null) {
                    return "IND";
                } else {
                    method = result;
                }
            }
        }

        return (method == null) ? "NOT" : method;
    }

    private String testSortingMethod(Person[] inputList, String method) {

        Person[] sortedList = new Person[inputList.length];

        System.arraycopy(inputList, 0, sortedList, 0, inputList.length);
        Arrays.sort(sortedList, new PersonComparator(method));

        return (Arrays.equals(inputList, sortedList)) ? method : null;
    }

}
