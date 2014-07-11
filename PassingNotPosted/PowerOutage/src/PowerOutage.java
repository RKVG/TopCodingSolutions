/*
TopCoder
Single Round Match: 144
Division: 2
Level: 3
Points: 1100
Description: http://community.topcoder.com/stat?c=problem_statement&pm=1697
 */

import java.util.ArrayList;

public class PowerOutage {

    public static void main(String[] args) {

        int[] fromJunction = new int[]{0};
        int[] toJunction = new int[]{1};
        int[] ductLength = new int[]{10};
        int l = new PowerOutage().estimateTimeOut(fromJunction, toJunction,
                ductLength);
        System.out.println(l);
    }

    private static int getSumOfLengths(int[] lengths) {

        int total = 0;

        for (int i : lengths) { total += i; }

        return total;
    }

    public int estimateTimeOut(int[] fromJunction, int[] toJunction,
                               int[] ductLength) {

        int sumOfLengths = getSumOfLengths(ductLength);
        int longestLength = getLongestLength(fromJunction, toJunction,
                ductLength);

        return (2 * sumOfLengths) - longestLength;
    }

    private int getLongestLength(int[] from, int[] to, int[] length) {

        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(50);

        for (int i = 0; i < from.length; i++) {
            graph.addEdge(new DirectedEdge(from[i], to[i], length[i]));
        }

        return getMaxLength(graph, 0);
    }

    private int getMaxLength(EdgeWeightedDigraph graph, int source) {

        int max = 0;

        for (DirectedEdge edge : graph.getAdjacent(source)) {
            int length = edge.weight + getMaxLength(graph, edge.to);
            if (length > max) { max = length; }
        }

        return max;
    }

    class DirectedEdge {

        final int from;

        final int to;

        final int weight;

        DirectedEdge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    class EdgeWeightedDigraph {

        private final ArrayList[] adjLists;

        EdgeWeightedDigraph(int numVertices) {
            adjLists = new ArrayList[numVertices];
            for (int i = 0; i < numVertices; i++) {
                adjLists[i] = new ArrayList<DirectedEdge>();
            }
        }

        void addEdge(DirectedEdge e) {
            adjLists[e.from].add(e);
        }

        Iterable<DirectedEdge> getAdjacent(int vertex) {
            return adjLists[vertex];
        }
    }
}
