package My_Learning.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsBipartiteGraphBFSLeetCode785 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//method-1
	boolean bfsCheck(ArrayList<ArrayList<Integer>> adj, int node, int color[]) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node); 
		color[node] = 1; 
		while(!q.isEmpty()) {
			Integer nde = q.poll(); 

			for(Integer it: adj.get(nde)) {
				if(color[it] == -1) {
					color[it] = 1 - color[nde]; 
					q.add(it); 
				}
				else if(color[it] == color[nde]) {
					return false; 
				}
			}
		}
		return true; 
	}


    boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n)
    {
        int color[] = new int[n];
        for(int i = 0;i<n;i++) {
        	color[i] = -1; 
        }
        for(int i = 0;i<n;i++) {
        	if(color[i] == -1) {
        		if(!bfsCheck(adj, i, color)) {
        			return false; 
        		}
        	}
        }
        return true; 
    }
	
	// method-2
	public boolean isBipartite(int[][] graph) {
		int[] color = new int[graph.length];
		Arrays.fill(color, -1);
		for (int i = 0; i < graph.length; i++)
			if ((color[i] == -1) && !bfs(i, graph, color))
				return false;
		return true;
	}

	private boolean bfs(int node, int[][] graph, int[] color) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		color[node] = 0;
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int nei : graph[curr]) {
				if (color[nei] == color[curr])
					return false;
				if (color[nei] == -1) {
					color[nei] = 1 - color[curr];
					q.add(nei);
				}
			}
		}
		return true;
	}

}
