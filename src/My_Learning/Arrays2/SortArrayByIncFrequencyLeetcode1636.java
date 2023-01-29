package My_Learning.Arrays2;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortArrayByIncFrequencyLeetcode1636 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] frequencySort(int[] nums) {
		// init hashmap and count occurences of elements in nums
		// init minHeap based on occurence, if two elements have same freq sort in
		// decreasing order
		// add elements in map into minHeap as array, containing element and occurence
		// init index to traverse array
		// loop while minHeap is not empty
		// grab min element
		// keep inserting element into nums while in bounds and occurence > 0
		// return nums

		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(new int[] { entry.getKey(), entry.getValue() });
		}

		int index = 0;

		while (!minHeap.isEmpty()) {
			int[] min = minHeap.poll();

			while (index < nums.length && min[1] > 0) {
				nums[index++] = min[0];
				min[1]--;
			}
		}

		return nums;
	}

}
