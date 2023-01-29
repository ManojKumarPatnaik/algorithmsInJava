package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSortUsingDFS {

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

		ArrayList<Integer> ans = topoSortDFS(n, adjList);
		System.out.println("Topologic sort answer for given graph :: " + ans.toString());
		sc.close();

	}

	private static ArrayList<Integer> topoSortDFS(int V, ArrayList<ArrayList<Integer>> adjList) {

		ArrayList<Integer> ans = new ArrayList<>();
		int[] vis = new int[V];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < V; i++) {
			if (vis[i] == 0) {
				dfs(i, adjList, vis, stack);
			}
		}

		while (!stack.isEmpty()) {
			ans.add(stack.pop());
		}

		return ans;

	}

	private static void dfs(int node, ArrayList<ArrayList<Integer>> adjList, int[] vis, Stack<Integer> stack) {
		// TODO Auto-generated method stub

		vis[node] = 1;

		for (Integer it : adjList.get(node)) {
			if (vis[it] == 0) {
				dfs(it, adjList, vis, stack);
			}
		}

		stack.push(node);

	}

}
