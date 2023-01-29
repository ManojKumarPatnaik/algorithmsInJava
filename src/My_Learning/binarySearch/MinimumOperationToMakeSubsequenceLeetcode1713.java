package My_Learning.binarySearch;

import java.util.*;

public class MinimumOperationToMakeSubsequenceLeetcode1713 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// LCS to LIS
	public int minOperations(int[] target, int[] A) {
		Map<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < target.length; ++i)
			h.put(target[i], i);

		ArrayList<Integer> stack = new ArrayList<>();
		for (int a : A) {
			if (!h.containsKey(a))
				continue;
			if (stack.size() == 0 || h.get(a) > stack.get(stack.size() - 1)) {
				stack.add(h.get(a));
				continue;
			}
			int left = 0, right = stack.size() - 1, mid;
			while (left < right) {
				mid = (left + right) / 2;
				if (stack.get(mid) < h.get(a))
					left = mid + 1;
				else
					right = mid;
			}
			stack.set(left, h.get(a));
		}
		return target.length - stack.size();
	}

	// Using Arrays.binearySearch

	public int minOperationsM1(int[] target, int[] A) {
		Map<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < target.length; ++i) {
			h.put(target[i], i);
		}
		int lis = 0, stack[] = new int[A.length + 1];
		for (int a : A) {
			if (!h.containsKey(a))
				continue;
			int i = Arrays.binarySearch(stack, 0, lis, h.get(a));
			i = Math.max(i, ~i);
			stack[i] = h.get(a);
			lis = Math.max(lis, i + 1);
		}
		return target.length - lis;
	}

	// Using Java Tree Set
	public int minOperationsM2(int[] target, int[] A) {
		Map<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < target.length; i++) {
			h.put(target[i], i);
		}
		TreeSet<Integer> stack = new TreeSet<>();
		for (int a : A) {
			if (!h.containsKey(a)) {
				continue;
			}
			if (stack.isEmpty() || stack.last() < h.get(a)) {
				stack.add(h.get(a));
				continue;
			}
			int key = stack.ceiling(h.get(a));
			stack.remove(key);
			stack.add(h.get(a));
		}
		return target.length - stack.size();
	}

}
