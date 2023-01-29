package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyListUserInputDirectedGraph {
	
//		Enter the number of vertices in directed graph :: 
//		9
//		Enter the number of edges present in directed graph :: 
//		10
//		Enter the edges in uv format !!
//		12
//		23
//		34
//		45
//		36
//		65
//		72
//		78
//		89
//		97
//		Edges :: [[1, 2], [2, 3], [3, 4], [4, 5], [3, 6], [6, 5], [7, 2], [7, 8], [8, 9], [9, 7]]
//		Adjacency List :: [[], [2], [3], [4, 6], [5], [], [5], [2, 8], [9], [7]]

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//taking input a graph
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices in directed graph :: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the number of edges present in directed graph :: ");
		int m = sc.nextInt(); // will read input 3_ and underscore is the current cursor position
		
		sc.nextLine(); // consuming the next line is \n since after integer directly we can parse the string 
		
		ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
		System.out.println("Enter the edges in uv format !!");
		while(m!=0) {
			ArrayList<Integer> uv = new ArrayList<>();
			
			String uvS = sc.nextLine();
			
			//String[] uvA = uvS.split(" ");
			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));
			
			uv.add(u);
			uv.add(v);
			
			edges.add(uv);
			
			m-=1;
		}
		
		System.out.println("Edges :: "+edges.toString()); // StringUtils.toString(edges)
		
		// making the adjacency list for the given graph
		ArrayList<ArrayList<Integer>> adjList = makeAdjList(n, m, edges);
		System.out.println("Adjacency List :: "+adjList.toString());
		
		
		sc.close();

	}

	public static ArrayList<ArrayList<Integer>> makeAdjList(int v, int e, ArrayList<ArrayList<Integer>> edges) {
		
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
		
		for(int i = 0; i <= v; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(ArrayList<Integer> uv : edges) {
			adjList.get(uv.get(0)).add(uv.get(1)); // [1,2] -> 1 -> 2 and 2->1
			//adjList.get(uv.get(1)).add(uv.get(0));
			
		}
		return adjList;
	}
}
