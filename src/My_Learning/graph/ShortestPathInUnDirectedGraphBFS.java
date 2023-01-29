package My_Learning.graph;

import java.util.*;

public class ShortestPathInUnDirectedGraphBFS {
	
//		Enter the number of vertices in a graph :: 
//		9
//		Enter the number of edges present in a graph :: 
//		11
//		Enter the edges in u v format !!
//		01
//		03
//		13
//		12
//		26
//		34
//		45
//		56
//		67
//		68
//		78
//		Edges :: [[0, 1], [0, 3], [1, 3], [1, 2], [2, 6], [3, 4], [4, 5], [5, 6], [6, 7], [6, 8], [7, 8]]
//		Adjacency List :: [[1, 3], [0, 3, 2], [1, 6], [0, 1, 4], [3, 5], [4, 6], [2, 5, 7, 8], [6, 8], [6, 7], []]
//		The shortest path from source :: 0 to destinaton :: 6 is :: 3

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

		int src = 0; // initialize the source with initial value. it is given in question
		int destination = 6;

		int shortestPath = giveShortestPath(n, src, destination, adjList);
		System.out.println("The shortest path from source :: " + src + " to destinaton :: " + destination + " is :: "
				+ shortestPath);
		sc.close();

	}

	private static int giveShortestPath(int V, int src, int destination, ArrayList<ArrayList<Integer>> adjList) {

		// initialize the distance array with infinity
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);

		Queue<Integer> q = new LinkedList<>();

		q.add(src);
		distance[src] = 0; // since the shortest path from source to itself is 0

		while (!q.isEmpty()) {

			int node = q.poll();

			for (Integer it : adjList.get(node)) {
				if (distance[node] + 1 < distance[it]) {
					distance[it] = distance[node] + 1;
					q.add(it);
				}
			}
		}

		return distance[destination];
	}

}
