package My_Learning.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithmMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int n = 5;
		ArrayList<ArrayList<DirectedWeightedNode>> adj = new ArrayList<ArrayList<DirectedWeightedNode>>();

		for (int i = 0; i < n; i++)
			adj.add(new ArrayList<DirectedWeightedNode>());

		// adding edges with weight
		// adj.get(u).add(new DirectedWeightedNode(v,w));

		adj.get(0).add(new DirectedWeightedNode(1, 2));
		adj.get(1).add(new DirectedWeightedNode(0, 2));

		adj.get(1).add(new DirectedWeightedNode(2, 3));
		adj.get(2).add(new DirectedWeightedNode(1, 3));

		adj.get(0).add(new DirectedWeightedNode(3, 6));
		adj.get(3).add(new DirectedWeightedNode(0, 6));

		adj.get(1).add(new DirectedWeightedNode(3, 8));
		adj.get(3).add(new DirectedWeightedNode(1, 8));

		adj.get(1).add(new DirectedWeightedNode(4, 5));
		adj.get(4).add(new DirectedWeightedNode(1, 5));

		adj.get(2).add(new DirectedWeightedNode(4, 7));
		adj.get(4).add(new DirectedWeightedNode(2, 7));

		System.out.println("Prims Algorithm Brute force!!");
		primsAlgoBruteForce(n, adj);
		System.out.println("Prims Algorithm Better approach!!");
		primsAlgoBetterApproach(n, adj);

	}

	private static void primsAlgoBruteForce(int n, ArrayList<ArrayList<DirectedWeightedNode>> adj) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		int[] key = new int[n];
		boolean[] mst = new boolean[n];
		int[] parent = new int[n];

		// initializing all arrays
		for (int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
			parent[i] = -1;
		}

		// int src = 0;
		// key[src] = 0;

		key[0] = 0;
		parent[0] = -1;

		for (int i = 0; i < n; i++) {
			if (mst[i] == false) { // handling the below test case mentioned
				int mini = Integer.MAX_VALUE;
				int u = 0;

				for (int v = 0; v < n; v++) {
					if (mst[v] == false && key[v] < mini) {
						mini = key[v];
						u = v;
					}
				}

				mst[u] = true;

				for (DirectedWeightedNode it : adj.get(u)) {
					if (mst[it.getV()] == false && it.getWeight() < key[it.getV()]) {

						parent[it.getV()] = u;
						key[it.getV()] = it.getWeight();
					}
				}
			}
		}
		// Run the loop till all the nodes have been visited
		// because in the brute code we checked for mstSet[node] == false while
		// computing the minimum
		// but here we simply take the minimal from the priority queue, so a lot of
		// times a node might be taken twice
		// hence its better to keep running till all the nodes have been taken.
		// try the following case:
		// 6 7
		// 0 1 5
		// 0 2 10
		// 0 3 100
		// 1 3 50
		// 1 4 200
		// 3 4 250
		// 4 5 50

		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " -> " + i);
		}

	}

	private static void primsAlgoBetterApproach(int n, ArrayList<ArrayList<DirectedWeightedNode>> adj) {
		// TODO Auto-generated method stub
		int[] key = new int[n];
		boolean[] mst = new boolean[n];
		int[] parent = new int[n];

		// initializing all arrays
		for (int i = 0; i < n; i++) {
			key[i] = Integer.MAX_VALUE;
			mst[i] = false;
			parent[i] = -1;
		}

		// int src = 1;
		// key[src] = 0;

		PriorityQueue<DirectedWeightedNode> pq = new PriorityQueue<DirectedWeightedNode>(n, new DirectedWeightedNode());

		key[0] = 0;
		parent[0] = -1;
		pq.add(new DirectedWeightedNode(key[0], 0));

		// Run the loop till all the nodes have been visited
		// because in the brute code we checked for mstSet[node] == false while
		// computing the minimum
		// but here we simply take the minimal from the priority queue, so a lot of
		// times a node might be taken twice
		// hence its better to keep running till all the nodes have been taken.
		// try the following case:
		// 6 7
		// 0 1 5
		// 0 2 10
		// 0 3 100
		// 1 3 50
		// 1 4 200
		// 3 4 250
		// 4 5 50
		while (!pq.isEmpty()) {
			int u = pq.poll().getV();
			mst[u] = true;

			for (DirectedWeightedNode it : adj.get(u)) {
				if (mst[it.getV()] == false && it.getWeight() < key[it.getV()]) {
					parent[it.getV()] = u;
					key[it.getV()] = it.getWeight();
					pq.add(new DirectedWeightedNode(it.getV(), key[it.getV()]));
				}
			}
		}

		for (int i = 1; i < n; i++) {
			System.out.println(parent[i] + " -> " + i);
		}

	}

}
