package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyListUserInputDirectedWeightedGraph {

//		Enter the number of vertices in directed graph :: 
//		6
//		Enter the number of edges present in directed graph :: 
//		7
//		Enter the edges+weight in uvw format !!
//		012
//		041
//		123
//		236
//		422
//		454
//		531
//		Edges :: [[0, 1, 2], [0, 4, 1], [1, 2, 3], [2, 3, 6], [4, 2, 2], [4, 5, 4], [5, 3, 1]]
//		Adjacency List :: [ [PairDirectedWeightedNode [u=0, v=1, w=2], PairDirectedWeightedNode [u=0, v=4, w=1]], 
//							[PairDirectedWeightedNode [u=1, v=2, w=3]], 
//							[PairDirectedWeightedNode [u=2, v=3, w=6]], 
//							[], 
//							[PairDirectedWeightedNode [u=4, v=2, w=2], PairDirectedWeightedNode [u=4, v=5, w=4]],
//							[PairDirectedWeightedNode [u=5, v=3, w=1]], 
//						  ]

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// taking input a graph
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the number of vertices in directed graph :: ");
		int n = sc.nextInt();

		System.out.println("Enter the number of edges present in directed graph :: ");
		int m = sc.nextInt(); // will read input 3_ and underscore is the current cursor position

		sc.nextLine(); // consuming the next line is \n since after integer directly we can parse the
						// string

		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		System.out.println("Enter the edges+weight in uvw format !!");
		while (m != 0) {
			ArrayList<Integer> uv = new ArrayList<>();

			String uvS = sc.nextLine();

			// String[] uvA = uvS.split(" ");
			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));
			int w = Integer.valueOf(String.valueOf(uvS.charAt(2)));

			uv.add(u);
			uv.add(v);
			uv.add(w); // weight

			edges.add(uv);

			m -= 1;
		}

		System.out.println("Edges :: " + edges.toString()); // StringUtils.toString(edges)

		// making the adjacency list for the given graph
		ArrayList<ArrayList<PairDirectedWeightedNode>> adjList = makeAdjList(n, m, edges);
		System.out.println("Adjacency List :: " + adjList.toString());

		sc.close();

	}

	public static ArrayList<ArrayList<PairDirectedWeightedNode>> makeAdjList(int V, int e,
			ArrayList<ArrayList<Integer>> weightedEdges) {

		ArrayList<ArrayList<PairDirectedWeightedNode>> adjList = new ArrayList<>();

		for (int i = 0; i < V; i++) {
			adjList.add(new ArrayList<>());
		}

		for (ArrayList<Integer> uv : weightedEdges) {

			// adjList.get(uv.get(0)).add(uv.get(1)); // [1,2] -> 1 -> 2 and 2->1
			// adjList.get(uv.get(1)).add(uv.get(0));
			// [1,2,3] => 1->2 with weight 3

			int u = uv.get(0);
			int v = uv.get(1);
			int w = uv.get(2);

			PairDirectedWeightedNode node = new PairDirectedWeightedNode(u, v, w);
			adjList.get(u).add(node);

		}
		return adjList;
	}

}
