package My_Learning.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastWeightElementleetcode1046 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lastStoneWeight(int[] stones) {
		if (stones == null || stones.length == 0) {
			return 0;
		}

		Comparator<Integer> comparator = (o1, o2) -> o2 - o1; // max heap
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(comparator);
		for (int stone : stones) {
			queue.offer(stone);
		}

		while (queue.size() > 1) {
			int num1 = queue.poll();
			int num2 = queue.poll();
			if (num1 != num2) {
				queue.offer(num1 - num2);
			}
		}

		return queue.isEmpty() ? 0 : queue.poll();
	}

}
