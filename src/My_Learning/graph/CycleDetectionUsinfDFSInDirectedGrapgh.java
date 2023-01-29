package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleDetectionUsinfDFSInDirectedGrapgh {

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
		ArrayList<ArrayList<Integer>> adjList = AdjacencyListUserInputDirectedGraph.makeAdjList(n, m, edges);
		System.out.println("Adjacency List :: " + adjList.toString());

		boolean ans = isCyclic(n, adjList);
		System.out.println("Given Graph is cyclic :: " + ans);
		sc.close();
	}

	private static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adjList) {

		int[] vis = new int[V + 1];
		int[] dfsVis = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			if (vis[i] == 0) {
				if (checkCycle(i, adjList, vis, dfsVis) == true)
					return true;
			}
		}
		return false;
	}

	private static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, int[] dfsVis) {

		vis[node] = 1;
		dfsVis[node] = 1;
		
//		System.out.println("Check cycle ");
//		System.out.println("Current node :: "+node);
//		System.out.println("visited array :: "+Arrays.toString(vis));
//		System.out.println("DFS visisted array :: "+Arrays.toString(dfsVis));
		
		for (Integer it : adjList.get(node)) {
			if (vis[it] == 0) {
				if (checkCycle(it, adjList, vis, dfsVis) == true)
					return true;
			} else if (dfsVis[it] == 1) // checking for cycle in other DFS array
				return true;
		}
		
		dfsVis[node] = 0;
		return false;
	}

}
