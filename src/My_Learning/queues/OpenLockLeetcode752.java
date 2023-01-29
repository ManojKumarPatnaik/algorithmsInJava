package My_Learning.queues;

import java.util.*;

public class OpenLockLeetcode752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int openLock(String[] deadends, String target) {
		int steps = 0;
		Queue<String> queue = new LinkedList<>();
		Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
		// need to use visited set, so we won't recheck the same number
		Set<String> visited = new HashSet<>();
		if (deadSet.contains("0000")) {
			return -1;
		}
		queue.offer("0000");
		visited.add("0000");
		// bfs
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				String cur = queue.poll();
				// found answer, return steps
				if (cur.equals(target)) {
					return steps;
				}
				// put the next number into the queue
				// change 1 char at a time
				for (int i = 0; i < 4; i++) {
					String nextIncrease = cur.substring(0, i) + (cur.charAt(i) - '0' + 1 + 10) % 10
							+ cur.substring(i + 1);
					String nextDecrease = cur.substring(0, i) + (cur.charAt(i) - '0' - 1 + 10) % 10
							+ cur.substring(i + 1);
					if (!visited.contains(nextIncrease) && !deadSet.contains(nextIncrease)) {
						queue.offer(nextIncrease);
						visited.add(nextIncrease);
					}
					if (!visited.contains(nextDecrease) && !deadSet.contains(nextDecrease)) {
						queue.offer(nextDecrease);
						visited.add(nextDecrease);
					}
				}
			}
			steps++;
		}
		// no result
		return -1;
	}

}
