package My_Learning.graph;

import java.util.PriorityQueue;

public class SellDiminsighValueBallLeetcode1648 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Hard point 1: Must calculate the sum like n *(n + 1) / 2, rather than i++,
	// given number is big
	// Hard ponit 2: Big number and always use long and cast!!
	public int maxProfit(int[] inventory, int orders) {
		int mod = 1000000007;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int num : inventory) {
			pq.offer(num);
		}

		int cur = pq.poll();
		int count = 1; // When pq poll the next element, +1 to count.
		long res = 0;
		while (orders > 0) {
			int next = pq.isEmpty() ? 0 : pq.peek();
			// If the number for [next + 1, cur] less than orders, add them ALL.
			if ((cur - next) * count <= orders) {
				// Add all the sum, and don't forget cast!
				long num = (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
				res = (res + num) % mod;
				orders -= (cur - next) * count;

			} else {
				// If the number for [next + 1, cur] greater than orders, only add partially.
				// Calculate the new next where the add stops.
				next = cur - orders / count;
				long num = (1L * (next + 1 + cur) * (cur - next) * count / 2) % mod;
				res = (res + num) % mod;
				// For the last number to add (new next), and don't forget cast! I forget here
				// in contest!
				res = (res + 1L * next * (orders % count)) % mod;
				orders = 0;
			}

			if (!pq.isEmpty())
				cur = pq.poll();
			count++;
		}
		return (int) res;
	}

}
