package My_Learning.bitManipulation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BitWiseOrArrayLeetcode898 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int subarrayBitwiseORs(int[] arr) {
		int n = arr.length;
		Set<Integer> s = new HashSet<>();
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			int size = queue.size();
			if (!queue.contains(arr[i])) {
				queue.offer(arr[i]);
				s.add(arr[i]);
			}
			int j = 0;
			while (j < size) {
				int tmp = queue.poll() | arr[i];
				if (!queue.contains(tmp)) {
					queue.offer(tmp);
					s.add(tmp);
				}
				j++;
			}
		}
		return s.size();
	}

}
