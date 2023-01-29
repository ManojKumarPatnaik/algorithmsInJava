package My_Learning.Arrays3;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumRefulingStopsLeetcode871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		if (startFuel >= target)
			return 0;
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		int i = 0, n = stations.length, stops = 0, maxDistance = startFuel;
		while (maxDistance < target) {
			while (i < n && stations[i][0] <= maxDistance) {
				queue.offer(stations[i++][1]);
			}
			if (queue.isEmpty())
				return -1;
			maxDistance += queue.poll();
			stops++;
		}
		return stops;
	}

}
