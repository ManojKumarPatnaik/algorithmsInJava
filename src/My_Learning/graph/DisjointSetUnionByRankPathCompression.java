package My_Learning.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class DisjointSetUnionByRankPathCompression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of nodes in graph :: ");
		int n = Integer.parseInt(sc.nextLine());
		
		ArrayList<ArrayList<Integer>> operationList = new ArrayList<>();
		System.out.print("Enter the number of operation for union :: ");
		int m = Integer.parseInt(sc.nextLine());
		
		while(m!=0) {
			ArrayList<Integer> uv = new ArrayList<>();
			String uvS = sc.nextLine();
			
			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));
			
			uv.add(u);
			uv.add(v);
			
			operationList.add(uv);
			
			m--;
		}
		
		
		constructDisjoinSet(n, operationList);
		
		sc.close();

	}

	private static void constructDisjoinSet(int n, ArrayList<ArrayList<Integer>> operationList) {
		int[] parent = new int[n+1];
		int[] rank = new int[n+1];
		
		for(int i = 0 ; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
		
		for(ArrayList<Integer> it : operationList) {
			int u = it.get(0);
			int v = it.get(1);
			
			union(u, v, rank, parent);
			
			
		}
		
		for(int i = 0 ; i < n ; i++) {
			System.out.println(parent[i]+"->"+i);
		}
		
		if(findParent(2, parent) != findParent(5, parent)) {
			System.out.println("Different Component");
		} else {
			System.out.println("Same component!!");
		}
		
		
	}

	private static void union(int u, int v, int[] rank, int[] parent) {
		u = findParent(u, parent);
		v = findParent(v, parent);
		
		if(rank[u] < rank[v]) {
			parent[u] = v;
		} 
		else if(rank[v] < rank[u]) {
			parent[v] = u;
		}
		else {
			parent[v] = u;
			rank[u]++;
		}
		
	}

	private static int findParent(int node, int[] parent) {
		
		if(node == parent[node]) {
			return node;
		}
		
		//return findParent(parent[node], parent) 
		return parent[node] = findParent(parent[node], parent); // with path compression
	}

}
