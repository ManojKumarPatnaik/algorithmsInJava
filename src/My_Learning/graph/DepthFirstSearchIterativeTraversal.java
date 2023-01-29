package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DepthFirstSearchIterativeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Providing the edges !! 12 23 34 45 52 Adjacency List :: [[], [2], [1, 3, 5],
		 * [2, 4], [3, 5], [4, 2]]
		 */

		// we assume that we are given adjacency list for the graph and the number of
		// vertices it have

		Scanner sc = new Scanner(System.in);
		int V = 5, E = 5;
		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

		System.out.println("Providing the edges !!");
		while (E != 0) {
			ArrayList<Integer> tempEdges = new ArrayList<>();

			String uvS = sc.nextLine();

			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));
			tempEdges.add(u);
			tempEdges.add(v);

			edges.add(tempEdges);

			E -= 1;
		}

		ArrayList<ArrayList<Integer>> adjList = AdjacencyListUserInputGraph.makeAdjList(V, E, edges);
		System.out.println("Adjacency List :: " + adjList.toString());

		ArrayList<Integer> dfs = getDFSTraversalIterative(V, adjList);
		System.out.println("DFS Traversal List :: " + dfs.toString());

		sc.close();

	}

	private static ArrayList<Integer> getDFSTraversalIterative(int V, ArrayList<ArrayList<Integer>> adjList) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();

		boolean[] visited = new boolean[V + 1];

		ArrayList<Integer> dfsIterative = new ArrayList<>();

		for (int i = 1; i <= V; i++) {
			if (visited[i] == false) {
				stack.push(i);
//				System.out.println("Stack :: "+stack.toString());
				
				while (!stack.isEmpty()) {
					
					int node = stack.peek();
					stack.pop();
					
					if(visited[node]==false) {
						dfsIterative.add(node);
						visited[node] = true;
					}
					
					System.out.println("DFS :: "+dfsIterative.toString());
					for (Integer it : adjList.get(node)) {
						if (visited[it] == false) {
							stack.add(it);
							//System.out.println("In Stack"+stack.toString());
						}
					}
				}
			}
		}

		return dfsIterative;
	}
}
