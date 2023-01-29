package My_Learning.Arrays3;

import java.util.PriorityQueue;

public class FindKThLargestIntegerArrayLeetcode1985 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String kthLargestNumber(String[] nums, int k) {
		PriorityQueue<String> minHeap = new PriorityQueue<>((o1, o2) -> {
			if (o1.length() == o2.length()) { // If the same length then compare by their string
				return o1.compareTo(o2);
			}
			return Integer.compare(o1.length(), o2.length()); // Compare by their length
		});
		for (String num : nums) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll(); // pop the minimum value in the heap
			}
		}
		return minHeap.poll();
	}

}
