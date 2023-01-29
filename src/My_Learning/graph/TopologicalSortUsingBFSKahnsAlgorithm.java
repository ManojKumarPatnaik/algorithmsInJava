package My_Learning.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSortUsingBFSKahnsAlgorithm {

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
		ArrayList<ArrayList<Integer>> adjList = AdjacencyListUserInputDirectedGraph.makeAdjList(n-1, m, edges);
		System.out.println("Adjacency List :: " + adjList.toString());

		ArrayList<Integer> ans = topoSortBFS(n, adjList);
		System.out.println("Topologic sort answer for given graph :: " + ans.toString());
		sc.close();
	}

	private static ArrayList<Integer> topoSortBFS(int V, ArrayList<ArrayList<Integer>> adjList) {
		// TODO Auto-generated method stub

		ArrayList<Integer> ans = new ArrayList<>();

		int[] inDegree = new int[V];
		for (int i = 0; i < V; i++) {
			for (Integer it : adjList.get(i)) {
				inDegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		// putting the node into q whose in degree is 0
		for (int i = 0; i < V; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int node = q.poll();

			ans.add(node);

			for (Integer it : adjList.get(node)) {
				inDegree[it]--;
				if (inDegree[it] == 0)
					q.add(it);
			}

		}

		return ans;
	}
	
	public int[] getTopoSortKhansAlgorithmBFS(int N, ArrayList<ArrayList<Integer>> adj) {
        int topo[] = new int[N]; 
        int indegree[] = new int[N]; 
        for(int i = 0;i<N;i++) {
            for(Integer it: adj.get(i)) {
                indegree[it]++; 
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>(); 
        for(int i = 0;i<N;i++) {
            if(indegree[i] == 0) {
                q.add(i); 
            }
        }
       
        int ind = 0;
        while(!q.isEmpty()) {
            Integer node = q.poll(); 
            topo[ind++] = node;
            for(Integer it: adj.get(node)) {
                indegree[it]--; 
                if(indegree[it] == 0) {
                    q.add(it); 
                }
            }
        }
        
       return topo;
    }

}
