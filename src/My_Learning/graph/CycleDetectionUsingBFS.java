package My_Learning.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CycleDetectionUsingBFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Enter number of vertices ::
		// 8
		// Enter number of EDGES ::
		// 7
		// Providing the edges !!
		// 13
		// 34
		// 25
		// 56
		// 67
		// 78
		// 85

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of vertices :: ");
		int V = Integer.parseInt(sc.nextLine());
		System.out.println("Enter number of EDGES :: ");
		int E = Integer.parseInt(sc.nextLine());

		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();

		System.out.println("Providing the edges !!");
		while (E != 0) {
			ArrayList<Integer> tempEdges = new ArrayList<>();

			String uvS = sc.nextLine();

			int u = Integer.valueOf(String.valueOf(uvS.charAt(0)));
			int v = Integer.valueOf(String.valueOf(uvS.charAt(1)));
			tempEdges.add(u);
			tempEdges.add(v);

			edges.add(tempEdges);

			E -= 1;
		}

		ArrayList<ArrayList<Integer>> adjList = AdjacencyListUserInputGraph.makeAdjList(V, E, edges);
		System.out.println("Adjacency List :: " + adjList.toString());

		boolean cycleP = isCyclePresent(V, adjList);
		System.out.println("Is cycle present :: " + cycleP);

		sc.close();
	}

	private static boolean isCyclePresent(int V, ArrayList<ArrayList<Integer>> adjList) {

		boolean[] visited = new boolean[V + 1];

		for (int i = 1; i <= V; i++) {
			if (visited[i] == false) {
				if (checkForCycle(i, visited, adjList))
					return true;
			}
		}

		return false;
	}

	private static boolean checkForCycle(int source, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {
		// can't directly pass pair of argument need to have a object which contain data
		// Queue<Integer,Integer> q = new LinkedList<>(); // store (node,
		// parent/previous) value

		Queue<CycleNode> q = new LinkedList<>();
		q.add(new CycleNode(source, -1));
		visited[source] = true;

		while (!q.isEmpty()) {
			CycleNode node = q.peek();

			int currentNode = node.getFirst();
			int parent = node.getSecond();

			visited[currentNode] = true;

			q.remove();

			for (Integer it : adjList.get(currentNode)) {
				if (visited[it] == false) {
					q.add(new CycleNode(it, currentNode));
					visited[it] = true;
				} else if (parent != it) {
					return true;
				}
			}

		}

		return false;
	}

}
