import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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

        switch (type) {

            case "NAW":
                if (p1.name.compareTo(p2.name) != 0)
                    return p1.name.compareTo(p2.name);
                if (p1.age != p2.age) return (p1.age < p2.age) ? -1 : 1;
                if (p1.weight != p2.weight)
                    return (p1.age > p2.age) ? -1 : 1;
                return 0;
            case "NWA":
                if (p1.name.compareTo(p2.name) != 0)
                    return p1.name.compareTo(p2.name);
                if (p1.weight != p2.weight)
                    return (p1.weight > p2.weight) ? -1 : 1;
                if (p1.age != p2.age) return (p1.age < p2.age) ? -1 : 1;
                return 0;
            case "ANW":
                if (p1.age != p2.age) return (p1.age < p2.age) ? -1 : 1;
                if (p1.name.compareTo(p2.name) != 0)
                    return p1.name.compareTo(p2.name);
                if (p1.weight != p2.weight)
                    return (p1.weight > p2.weight) ? -1 : 1;
                return 0;
            case "AWN":
                if (p1.age != p2.age) return (p1.age < p2.age) ? -1 : 1;
                if (p1.weight != p2.weight)
                    return (p1.weight > p2.weight) ? -1 : 1;
                if (p1.name.compareTo(p2.name) != 0)
                    return p1.name.compareTo(p2.name);
                return 0;
            case "WAN":
                if (p1.weight != p2.weight)
                    return (p1.weight > p2.weight) ? -1 : 1;
                if (p1.age != p2.age) return (p1.age < p2.age) ? -1 : 1;
                if (p1.name.compareTo(p2.name) != 0)
                    return p1.name.compareTo(p2.name);
                return 0;
            case "WNA":
                if (p1.weight != p2.weight)
                    return (p1.weight > p2.weight) ? -1 : 1;
                if (p1.name.compareTo(p2.name) != 0)
                    return p1.name.compareTo(p2.name);
                if (p1.age != p2.age) return (p1.age < p2.age) ? -1 : 1;
                return 0;
            default:
                return 0;
        }

    }
}

public class WhatSort {

    public String sortType(String[] name, int[] age, int[] wt) {

        List<Person> inputList = new ArrayList<>();
        List<Person> sortedList = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            Person p = new Person(name[i], age[i], wt[i]);
            inputList.add(p);
            sortedList.add(p);
        }

        String result = null;

        Collections.sort(sortedList, new PersonComparator("NAW"));
        if (inputList.equals(sortedList)) {
            result = "NAW";
        }

        Collections.sort(sortedList, new PersonComparator("NWA"));
        if (inputList.equals(sortedList)) {
            if (result != null) {
                return "IND";
            } else {
                result = "NWA";
            }
        }

        Collections.sort(sortedList, new PersonComparator("ANW"));
        if (inputList.equals(sortedList)) {
            if (result != null) {
                return "IND";
            } else {
                result = "ANW";
            }
        }

        Collections.sort(sortedList, new PersonComparator("AWN"));
        if (inputList.equals(sortedList)) {
            if (result != null) {
                return "IND";
            } else {
                result = "AWN";
            }
        }

        Collections.sort(sortedList, new PersonComparator("WAN"));
        if (inputList.equals(sortedList)) {
            if (result != null) {
                return "IND";
            } else {
                result = "WAN";
            }
        }

        Collections.sort(sortedList, new PersonComparator("WNA"));
        if (inputList.equals(sortedList)) {
            if (result != null) {
                return "IND";
            } else {
                result = "WNA";
            }
        }

        return (result == null) ? "NOT" : result;

    }

}
