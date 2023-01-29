package My_Learning.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithmShortestPathFromSourceToAllNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		ArrayList<ArrayList<DirectedWeightedNode>> adj = new ArrayList<ArrayList<DirectedWeightedNode>>();
		
		for(int i = 0 ; i < n ; i++)
			adj.add(new ArrayList<DirectedWeightedNode>());
		
		// adding edges with weight 
		// adj.get(u).add(new DirectedWeightedNode(v,w));
		
		adj.get(0).add(new DirectedWeightedNode(1,2));
		adj.get(1).add(new DirectedWeightedNode(0,2));
		
		adj.get(1).add(new DirectedWeightedNode(2, 4));
		adj.get(2).add(new DirectedWeightedNode(1, 4));
		
		adj.get(0).add(new DirectedWeightedNode(3, 1));
		adj.get(3).add(new DirectedWeightedNode(0, 1));
		
		adj.get(3).add(new DirectedWeightedNode(2, 3));
		adj.get(2).add(new DirectedWeightedNode(3, 3));
		
		adj.get(1).add(new DirectedWeightedNode(4, 5));
		adj.get(4).add(new DirectedWeightedNode(1, 5));
		
		adj.get(2).add(new DirectedWeightedNode(4, 1));
		adj.get(4).add(new DirectedWeightedNode(2, 1));
		int src = 0; // take any node as source
		
		getShortestPathUsingDijkstra(src, adj, n);
	}

	private static void getShortestPathUsingDijkstra(int src, ArrayList<ArrayList<DirectedWeightedNode>> adj, int n) {
		// TODO Auto-generated method stub
		int[] distance = new int[n];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		distance[src] = 0 ; // starting node
		PriorityQueue<DirectedWeightedNode> pq = new PriorityQueue<DirectedWeightedNode>(n, new DirectedWeightedNode());
		//we can use set as an alternate way for above pq
		//Set<DirectedWeightedNode> set = new HashSet<DirectedWeightedNode>();
		
		pq.add(new DirectedWeightedNode(src, 0));
		
		while(!pq.isEmpty()) {
			DirectedWeightedNode node = pq.poll();
			
			for(DirectedWeightedNode it : adj.get(node.getV())) {
				
				if(distance[node.getV()] + it.getWeight() < distance[it.getV()]) {
					distance[it.getV()] = distance[node.getV()] + it.getWeight();
					pq.add(new DirectedWeightedNode(it.getV(), distance[it.getV()] ));
				}
			}
			
		}
		
		//printing the distance
		System.out.println("The shortest distance using Dijkstra's algorithm from single source :: "+src+" to every node");
		for(int i = 0 ; i < n ; i++) {
			System.out.print(distance[i]+" ");
		}
		
		
	}

}
