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

	private static final int MAX_JUNCTIONS = 50;

	/* Each tunnel will need to be traversed twice, once on the way out and
    then again on the way back.  However, if we save the longest tunnel for
    last, then the power can go back on before we return along the longest
    path.  Therefore the estimate time out is 2 * the sum of all the lenghts,
     minus the longest length.
     */
	public int estimateTimeOut(int[] fromJunction, int[] toJunction,
							   int[] ductLength) {

		int sumOfLengths = 0;
		for (int i : ductLength) sumOfLengths += i;

		int longestLength = getLongestLength(fromJunction, toJunction,
				ductLength);

		return (2 * sumOfLengths) - longestLength;
	}

	/*
    Creates a graph representing the tunnels and junctions.  Then calls
    getMaxLength() to determine the longest path.
     */
	private int getLongestLength(int[] from, int[] to, int[] length) {

		EdgeWeightedDigraph graph = new EdgeWeightedDigraph(MAX_JUNCTIONS);

		for (int i = 0; i < from.length; i++) {
			graph.addEdge(new DirectedEdge(from[i], to[i], length[i]));
		}

		return getMaxLength(graph, 0);
	}

	/*
    Uses recursion to return the length of the longest path beginning at the
    source.
     */
	private int getMaxLength(EdgeWeightedDigraph graph, int source) {

		int max = 0;

		for (DirectedEdge edge : graph.getAdjacent(source)) {
			int length = edge.weight + getMaxLength(graph, edge.to);
			if (length > max) { max = length; }
		}

		return max;
	}

	/*
    Holds a to and from junction, and the weight(distance) between them
     */
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

	/*
    A slimmed down Edge-Weighted Directed Graph.
     */
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
