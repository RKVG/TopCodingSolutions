/*
CodeChef
July Challenge 2014
Description: http://www.codechef.com/JULY14/problems/DISHOWN
 */

import java.io.File;
import java.util.Scanner;

public class DishOwner {

    public static void main(String[] args) throws Exception {

        Scanner sc;

        // If an arg is given, read from that file. Otherwise use stdin.
        if (args.length > 0) {
            File f = new File(args[0]);
            sc = new Scanner(f);
        } else {
            sc = new Scanner(System.in);
        }

        // Get number of Test Cases
        int numTestCases = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numTestCases; i++) {

            // Get number of Chefs
            int numOfChefs = Integer.parseInt(sc.nextLine());

            // Set dish owners
            int[] owners = new int[numOfChefs];
            for (int owner = 0; owner < numOfChefs; owner++) {
                owners[owner] = owner;
            }

            // Set scores for each Dish
            int[] scores = new int[numOfChefs];

            int dish = 0;
            for (String s : sc.nextLine().split(" ")) {
                scores[dish++] = Integer.parseInt(s);
            }

            // Get number of Queries
            int numOfQueries = Integer.parseInt(sc.nextLine());

            // Process each query
            for (int q = 0; q < numOfQueries; q++) {
                String[] query = sc.nextLine().split(" ");

                if (query.length == 3) {
                    doCompetition(Integer.parseInt(query[1]) - 1,
                            Integer.parseInt(query[2]) - 1, scores, owners);
                } else {
                    System.out.println(getDishOwner(Integer.parseInt
                            (query[1]) - 1, owners) + 1);
                }
            }
        }
    }

    private static void doCompetition(int dish1, int dish2, int[] scores,
                                      int[] owners) {

        int chef1 = getDishOwner(dish1, owners);
        int chef2 = getDishOwner(dish2, owners);

        if (chef1 == chef2) {
            System.out.println("Invalid query!");
            return;
        }

        if (scores[dish1] > scores[dish2]) {
            owners[dish2] = chef1;
        } else if (scores[dish2] > scores[dish1]) {
            owners[dish1] = chef2;
        } else {
            // Tie. do nothing
        }
    }

    private static int getDishOwner(int dish, int[] owners) {

        int chef = dish;
        while (owners[dish] != chef) {
            chef = owners[dish];
        }
        return chef;
    }
}
