package My_Learning.binaryTrees_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithFactorsLeetcode823 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numFactoredBinaryTrees(int[] A) {
		Arrays.sort(A);
		Map<Integer, Long> map = new HashMap<>();
		long count = 1;
		map.put(A[0], count);
		for (int i = 1; i < A.length; i++) {
			count = 1;
			for (Integer n : map.keySet()) {
				if (A[i] % n == 0 && map.containsKey(A[i] / n)) {
					count += map.get(n) * map.get(A[i] / n);
				}
			}
			map.put(A[i], count);
		}
		long sum = 0;
		for (Integer n : map.keySet()) {
			sum = (sum + map.get(n)) % ((int) Math.pow(10, 9) + 7);
		}
		return (int) sum;
	}

}
