package My_Learning.Arrays3;

import java.util.PriorityQueue;

public class IPOLeetcode502 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int n = profits.length;
		PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<Integer>(n, (i1, i2) -> capital[i1] - capital[i2]);
		PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<Integer>(n, (i1, i2) -> profits[i2] - profits[i1]);

		// adding all capital to minHeap
		for (int i = 0; i < n; i++) {
			minCapitalHeap.offer(i);
		}
		// finding k projects
		int availableCapital = w;
		for (int i = 0; i < k; i++) {
			while (!minCapitalHeap.isEmpty() && capital[minCapitalHeap.peek()] <= availableCapital) {
				maxProfitHeap.add(minCapitalHeap.poll());
			}

			if (maxProfitHeap.isEmpty()) {
				break;
			}

			availableCapital += profits[maxProfitHeap.poll()];
		}
		return availableCapital;
	}

}
