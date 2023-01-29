package My_Learning.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BreadthFirstSearchTraversalBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Providing the edges !! 12 23 34 45 52 Adjacency List :: [[], [2], [1, 3, 5],
		 * [2, 4], [3, 5], [4, 2]]
		 */
		
		// assume total number of vertices and adjacency list for the graph is provided 
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
		
		ArrayList<Integer> bfsTraversal = getBFSTraversal(V, adjList);
		System.out.println("BFS Traversal :: "+bfsTraversal.toString());
		
		sc.close();
	}

	private static ArrayList<Integer> getBFSTraversal(int V, ArrayList<ArrayList<Integer>> adjList) {
		ArrayList<Integer> bfs = new ArrayList<>();
		
		boolean[] visited = new boolean[V+1];
		
		// using loop since we have multiple disconnected component of single graph
		
		for(int i = 1; i<= V; i++) { 
			
			if((visited[i]==false)) {
				Queue<Integer> q = new LinkedList<>();
				
				q.add(i);
				visited[i] = true;
				
				while(!q.isEmpty()) {
					Integer node = q.poll(); //take FIFO top element and delete from q
					bfs.add(node);
					
					for(Integer it: adjList.get(i)) {
						
						if(visited[it]==false) {
							visited[it] = true;
							q.add(it);
						}
						
					}
				}
			}
		}
		
		
		return bfs;
	}

}
