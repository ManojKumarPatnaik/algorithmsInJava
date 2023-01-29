package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DepthFirstSearchTraversalDFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Providing the edges !! 12 23 34 45 52 Adjacency List :: [[], [2], [1, 3, 5],
		 * [2, 4], [3, 5], [4, 2]]
		 */
		
		// we assume that we are given adjacency list for the graph and the number of vertices it have
		
		Scanner sc = new Scanner(System.in);
		int V = 5, E = 5;
		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
		
		System.out.println("Providing the edges !!");
		while(E!=0) {
			ArrayList<Integer> tempEdges = new ArrayList<>();
			
			String uvS = sc.nextLine();
			
			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));
			tempEdges.add(u);
			tempEdges.add(v);
			
			edges.add(tempEdges);
			
			E-=1;
		}
		
		ArrayList<ArrayList<Integer>> adjList = AdjacencyListUserInputGraph.makeAdjList(V, E, edges);
		System.out.println("Adjacency List :: "+adjList.toString());
		
		ArrayList<Integer> dfs  = getDFSTraversal(V, adjList);
		System.out.println("DFS Traversal List :: "+dfs.toString());
		
		sc.close();

	}

	private static ArrayList<Integer> getDFSTraversal(int V, ArrayList<ArrayList<Integer>> adjList) {
		// TODO Auto-generated method stub
		
		boolean[] visited = new boolean[V+1];
		ArrayList<Integer> dfs = new ArrayList<>();
		
		for(int i = 1; i<= V ; i++) {
			if(visited[i]==false) {
				dfs(i, visited, adjList, dfs);
			}
		}
		
		return dfs;
	}

	private static void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> dfs) {
		// TODO Auto-generated method stub
		
		dfs.add(node);
		visited[node] = true;
		
		for(Integer it : adjList.get(node)) {
			if(visited[it]==false) {
				dfs(it, visited, adjList, dfs);
			}
		}
		
	}

}
