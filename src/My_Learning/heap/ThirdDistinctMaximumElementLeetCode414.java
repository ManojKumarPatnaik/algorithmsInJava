package My_Learning.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdDistinctMaximumElementLeetCode414 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int thirdMaxIterative(int[] nums) {
		Integer max1 = null;
		Integer max2 = null;
		Integer max3 = null;
		for (Integer n : nums) {
			if (n.equals(max1) || n.equals(max2) || n.equals(max3))
				continue;
			if (max1 == null || n > max1) {
				max3 = max2;
				max2 = max1;
				max1 = n;
			} else if (max2 == null || n > max2) {
				max3 = max2;
				max2 = n;
			} else if (max3 == null || n > max3) {
				max3 = n;
			}
		}
		return max3 == null ? max1 : max3;
	}

	// using Priority queue
	public int thirdMax(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.contains(i)) {
				pq.offer(i);
				set.add(i);
				if (pq.size() > 3) {
					set.remove(pq.poll());
				}
			}
		}
		if (pq.size() < 3) {
			while (pq.size() > 1) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	// no need to use set
	public int thirdMaxP(int[] nums) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : nums) {
			if (!pq.contains(i)) {
				pq.offer(i);
				if (pq.size() > 3) {
					pq.poll();
				}
			}
		}
		if (pq.size() < 3) {
			while (pq.size() > 1) {
				pq.poll();
			}
		}
		return pq.peek();
	}

}
