package My_Learning.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraphDAG {

//	Enter the number of vertices in directed graph :: 
//	6
//	Enter the number of edges present in directed graph :: 
//	7
//	Enter the edges+weight in uvw format !!
//	012
//	041
//	123
//	236
//	422
//	454
//	531
//	Edges :: [[0, 1, 2], [0, 4, 1], [1, 2, 3], [2, 3, 6], [4, 2, 2], [4, 5, 4], [5, 3, 1]]
//	Adjacency List :: [ [PairDirectedWeightedNode [u=0, v=1, w=2], PairDirectedWeightedNode [u=0, v=4, w=1]], 
//						[PairDirectedWeightedNode [u=1, v=2, w=3]], 
//						[PairDirectedWeightedNode [u=2, v=3, w=6]], 
//						[], 
//						[PairDirectedWeightedNode [u=4, v=2, w=2], PairDirectedWeightedNode [u=4, v=5, w=4]],
//						[PairDirectedWeightedNode [u=5, v=3, w=1]], 
//					  ]
//	Shortest distnce in given weighted graph from source node 0
//	0 2 3 6 1 5 
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// making the directed weighted graph
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
		ArrayList<ArrayList<PairDirectedWeightedNode>> adjList = AdjacencyListUserInputDirectedWeightedGraph
				.makeAdjList(n, m, edges);
		System.out.println("Adjacency List :: " + adjList.toString());
		int src = 0;

		shortestPath(src, adjList, n);

		sc.close();

	}

	private static void shortestPath(int src, ArrayList<ArrayList<PairDirectedWeightedNode>> adjList, int n) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<>();
		int[] distance = new int[n];
		
		boolean[] visit = new boolean[n];
		Arrays.fill(visit, false);
		
		for(int i = 0; i < n ; i++) {
			if(visit[i]==false) {
				topologicalSort(i, visit, adjList, stack);
			}
		}
		
		for(int i = 0; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		
		distance[src] = 0;
		
		while(!stack.isEmpty()) {
			int node = stack.pop();
			if(distance[node] != Integer.MAX_VALUE) {
				
				for(PairDirectedWeightedNode it : adjList.get(node)) {
					if(distance[node] + it.getW() < distance[it.getV()]) {
						distance[it.getV()] = distance[node] + it.getW();
					}
				}
			}
		}
		
		
		// printing the answer
		System.out.println("Shortest distnce in given weighted graph from source node "+src);
		for(int i = 0; i < n; i++) {
			if(distance[i] != Integer.MAX_VALUE) {
				System.out.print(distance[i]+" ");
			} else {
				System.out.print("INF ");
			}
		}
	}

	private static void topologicalSort(int node, boolean[] visit, ArrayList<ArrayList<PairDirectedWeightedNode>> adjList,
			Stack<Integer> stack) {
		// TODO Auto-generated method stub
		
		visit[node] = true;
		for(PairDirectedWeightedNode it : adjList.get(node)) {
			if(visit[it.getV()]== false) {
				topologicalSort(it.getV(), visit, adjList, stack);
			}
		}
		
		stack.add(node);
	}

}
