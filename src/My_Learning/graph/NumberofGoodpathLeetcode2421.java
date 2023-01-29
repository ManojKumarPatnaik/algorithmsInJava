package My_Learning.graph;

import java.util.*;

public class NumberofGoodpathLeetcode2421 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int sum = n;
        
        // create adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        
        // create sortedmap with key as node value and value as list of index
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        
        // create unionfind
        UnionFind uf = new UnionFind(n);
        
        for (int i = 0; i < n; i++) { //O(N)
            adjList.add(new ArrayList<>());
            if (!tm.containsKey(vals[i])) {
                tm.put(vals[i], new ArrayList<>());
            }
            tm.get(vals[i]).add(i);
        }
        for (int[] edge : edges) { //O(N)
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        // traverse node values from lowest to highest 
        Map.Entry<Integer, List<Integer>> curr = tm.firstEntry();
        while (curr != null) { 
			List<Integer> listNodes = curr.getValue();
		
            // for each node union with neighbor if neighbor value is
			// lower or equal to node value
            for (Integer node : listNodes) { 
                List<Integer> neighbors = adjList.get(node);
                for (Integer neighbor : neighbors) { 
                    if (vals[node] >= vals[neighbor]) {
                        uf.merge(node, neighbor);
                    }
                }
            }
			
            // check if each node is in union with other node with 
			// same value
            if (listNodes.size() > 1) {
                Map<Integer, Integer> freq = new HashMap<>();
				
				// create frequency map of parent, to count number of nodes of same value in each set
                for (int i = 0; i < listNodes.size(); i++) {
                    int parent = uf.find(listNodes.get(i));
                    freq.put(parent, freq.getOrDefault(parent, 0) + 1);
                }
				
				// apply arithmetic progression formula to find sum of good paths
                for (int parentKey : freq.keySet()) {
                    int frequency = freq.get(parentKey) - 1;
                    sum += (frequency * (frequency + 1)) / 2;
                }
            }
            
            curr = tm.higherEntry(curr.getKey());
        }
        return sum;
    }
}

class UnionFind {
    int[] dp;
    int[] rank;
    
    public UnionFind(int n) {
        dp = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int i) {
        if (dp[i] == i) {
            return i;
        }
        dp[i] = find(dp[i]);
        return dp[i];
    }

    public boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    public void merge(int x, int y) {
        if (isSameSet(x, y)) {
            return;
        }
        int xp = find(x);
        int yp = find(y);

        if (rank[xp] < rank[yp]) {
            dp[xp] = yp;
        } else {
            dp[yp] = dp[xp];
            if (rank[xp] == rank[yp]) {
                rank[xp]++;
            }
        }
    }
}
