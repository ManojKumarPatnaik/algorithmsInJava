package My_Learning.Arrays3;

import java.util.PriorityQueue;

public class EqualSumArrayWithMinOperationsLeetcode1775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minOperations(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6)
			return -1;
		int sum1 = 0, sum2 = 0, operations = 0;
		for (int i : nums2)
			sum2 += i;
		for (int i : nums1)
			sum1 += i;
		if (sum1 > sum2) {
			int[] temp = nums1;
			nums1 = nums2;
			nums2 = temp;

			int tempSum = sum1;
			sum1 = sum2;
			sum2 = tempSum;
		}
		PriorityQueue<Integer> pq1 = new PriorityQueue<>(), pq2 = new PriorityQueue<>((x, y) -> y - x);
		for (int i : nums1)
			pq1.offer(i);
		for (int i : nums2)
			pq2.offer(i);

		for (; sum1 < sum2; operations++)
			if (pq2.isEmpty() || pq2.peek() - 1 < 6 - pq1.peek())
				sum1 += 6 - pq1.poll();
			else
				sum2 -= pq2.poll() - 1;
		return operations;
	}

}
