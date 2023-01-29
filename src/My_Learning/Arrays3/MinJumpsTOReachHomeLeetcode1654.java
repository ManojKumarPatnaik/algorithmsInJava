package My_Learning.Arrays3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinJumpsTOReachHomeLeetcode1654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumJumps(int[] forbidden, int a, int b, int x) {
		Set<Integer> set = new HashSet<>();
		Set<String> visit = new HashSet<>();
		for (int n : forbidden)
			set.add(n);

		Queue<int[]> q = new LinkedList<>();
		int moves = 0;
		int max = 2000 + 2 * b;

		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();
				int pos = current[0], direction = current[1];

				if (pos == x)
					return moves;

				if (pos + a < max && !set.contains(pos + a) && !visit.contains(pos + a + "," + 0)) {
					visit.add(pos + a + "," + 0);
					q.offer(new int[] { pos + a, 0 });
				}

				if (direction == 0) {
					if (pos - b >= 0 && !set.contains(pos - b) && !visit.contains(pos - b + "," + 1)) {
						visit.add(pos - b + "," + 1);
						q.offer(new int[] { pos - b, 1 });
					}
				}
			}
			moves++;
		}

		return -1;
	}

}
