package My_Learning.Arrays3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class JumpGame3Leetcode1306 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean canReach(int[] arr, int start) {
		int n = arr.length;
		HashSet<Integer> visited = new HashSet<>(); // visited set
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		while (!q.isEmpty()) {
			int i = q.poll();
			if (arr[i] == 0)
				return true; // found then return it
			if (visited.contains(i))
				continue; // already visited than continue
			visited.add(i);
			if (i + arr[i] < n)
				q.add(i + arr[i]);
			if (i - arr[i] >= 0)
				q.add(i - arr[i]);
		}
		return false;// not found
	}

}
