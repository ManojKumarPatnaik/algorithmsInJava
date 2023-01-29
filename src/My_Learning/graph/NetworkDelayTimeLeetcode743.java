package My_Learning.graph;

import java.util.*;

public class NetworkDelayTimeLeetcode743 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	class Node{
		private int travelTime;
		private int destination;
		
		public Node(int travelTime, int destination) {
			super();
			this.travelTime = travelTime;
			this.destination = destination;
		}

		public Node() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int travelTime() {
			return travelTime;
		}

		public void setTravelTime(int travelTime) {
			this.travelTime = travelTime;
		}

		public int destination() {
			return destination;
		}

		public void destination(int destination) {
			this.destination = destination;
		}
		
		
		
	}

	private final Map<Integer, List<Node>> connected = new HashMap<>();

	public int networkDelayTime(int[][] times, int n, int k) {
		for (int[] time : times) {
			connected.putIfAbsent(time[0], new ArrayList<>());
			connected.get(time[0]).add(new Node(time[2], time[1]));
		}
		connected.forEach((source, nodes) -> nodes.sort(Comparator.comparing(Node::travelTime)));
		int[] receivedTime = new int[n + 1];
		Arrays.fill(receivedTime, 1, receivedTime.length, Integer.MAX_VALUE);
		dfs(receivedTime, 0, k);

		int max = Arrays.stream(receivedTime).max().orElseThrow(RuntimeException::new);
		return max == Integer.MAX_VALUE ? -1 : max;
	}

	private void dfs(int[] receivedTime, int currentTime, int currentNode) {
		if (receivedTime[currentNode] <= currentTime)
			return;
		receivedTime[currentNode] = currentTime;
		if (connected.containsKey(currentNode))
			connected.get(currentNode)
					.forEach(node -> dfs(receivedTime, currentTime + node.travelTime(), node.destination()));
	}

//	public record Node(int travelTime, int destination) {
//	}

}
