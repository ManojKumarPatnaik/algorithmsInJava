package My_Learning.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class IsBipartiteGraphDFSLeetCode785 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// taking input a graph
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of vertices in a graph :: ");
		int n = sc.nextInt();

		System.out.println("Enter the number of edges present in a graph :: ");
		int m = sc.nextInt(); // will read input 3_ and underscore is the current cursor position

		sc.nextLine(); // consuming the next line is \n since after integer directly we can parse the
						// string

		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		System.out.println("Enter the edges in u v format !!");
		while (m != 0) {
			ArrayList<Integer> uv = new ArrayList<>();

			String uvS = sc.nextLine();

			// String[] uvA = uvS.split(" ");
			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));

			uv.add(u);
			uv.add(v);

			edges.add(uv);

			m -= 1;
		}

		System.out.println("Edges :: " + edges.toString());

		// making the adjacency list for the given graph
		ArrayList<ArrayList<Integer>> adjList = AdjacencyListUserInputGraph.makeAdjList(n, m, edges);
		System.out.println("Adjacency List :: " + adjList.toString());

		boolean ans = isBipartite(n, adjList);
		System.out.println("Input grapgh is bipartite :: "+ans);
		sc.close();
	}

	public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {

		int[] color = new int[V + 1];
		Arrays.fill(color, -1); // for filling the array with -1 initially

		for (int i = 1; i <= V; i++) {
			if (color[i] == -1) {
				if (!dfsCheck(i, adj, color)) {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {

		// see if node is colored or not
		if (color[node] == -1) {
			color[node] = 1;
		}

		for (Integer it : adj.get(node)) {
			if (color[it] == -1) {
				color[it] = 1 - color[node];
				
				if (!dfsCheck(it, adj, color)) {
					return false;
				}
			} else if (color[it] == color[node]) { // see if adj is colored with same or not
				return false;
			}
		}

		return true;
	}

}
