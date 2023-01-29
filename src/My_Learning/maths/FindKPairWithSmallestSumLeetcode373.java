package My_Learning.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairWithSmallestSumLeetcode373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	class Pair {
		int numFromArray1;
		int numFromArray2;
		int array1Index;
		int array2Index;
		int sum;

		Pair(int numFromArray1, int numFromArray2, int array1Index, int array2Index) {
			sum = numFromArray1 + numFromArray2;
			this.numFromArray1 = numFromArray1;
			this.numFromArray2 = numFromArray2;
			this.array1Index = array1Index;
			this.array2Index = array2Index;

		}
	}

	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> {
			return a.sum - b.sum;
		});
		int n = nums1.length, m = nums2.length;
		for (int i = 0; i < nums2.length; i++) {
			pq.add(new Pair(nums1[0], nums2[i], 0, i));
		}
		while (!pq.isEmpty() && k-- > 0) {
			Pair p = pq.poll();
			List<Integer> curr = new ArrayList<Integer>();
			curr.add(p.numFromArray1);
			curr.add(p.numFromArray2);
			list.add(curr);
			if (p.array1Index < n - 1) {
				pq.add(new Pair(nums1[p.array1Index + 1], p.numFromArray2, p.array1Index + 1, p.array2Index));
			}
		}
		return list;
	}

}
