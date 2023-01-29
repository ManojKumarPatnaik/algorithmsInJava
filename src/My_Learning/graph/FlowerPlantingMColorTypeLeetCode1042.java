package My_Learning.graph;

import java.util.*;

public class FlowerPlantingMColorTypeLeetCode1042 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] gardenNoAdj1(int n, int[][] paths) {
        List<Integer>[] graph = buildGraph(n, paths);
        int[] flowers = new int[n];
        for (int garden = 0; garden < n; garden++) {
            boolean[] used = new boolean[5];
            for (int adj : graph[garden]) {
                used[flowers[adj]] = true;
            }
            flowers[garden] = pickFlower(used);
        }
        return flowers;
    }

    private int pickFlower(boolean[] used) {
        for (int flower = 1; flower <= 4; flower++) {
            if (!used[flower]) return flower;
        }
        return -1;
    }

    private List<Integer>[] buildGraph(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
    
    //approach-2
    public int[] gardenNoAdj2(int N, int[][] paths) {
        //Create a graph
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        //... via adjacency list
        for (int i = 0; i < N; i++) graph.put(i, new HashSet<>());
        //Add the edges 
        
        for (int[] path : paths){
            int x = path[0] - 1; //Due to 1-based indexing 
            int y = path[1] - 1; //Due to 1-based indexing
            //Undirected edge
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        //Here is our solution vector where res[i] represents color of garden i+1
        int[] res = new int[N];
        
        //Now run graph painting algorithm
        
        //For each garden
        for (int i = 0; i < N; i++){
            int[] colors = new int[5]; //Use 5 instead of 4 so we can easily use 1-based indexing of the garden colors
            for (int nei : graph.get(i)){
                colors[res[nei]] = 1; //Mark the color as used if neighbor has used it before.
            }
            //Now just use a color that has not been used yet
            for (int c = 4; c >= 1; c--){
                if (colors[c] != 1) //colors[c] == 0 => the color has not been used yet,
                    res[i] = c; //so let's use that one
                	break; 
            }
        }
        
        return res;
        
    }

}
