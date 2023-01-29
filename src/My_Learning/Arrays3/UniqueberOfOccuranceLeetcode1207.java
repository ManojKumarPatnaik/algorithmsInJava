package My_Learning.Arrays3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueberOfOccuranceLeetcode1207 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Set<Integer> set = new HashSet<>(map.values());
		return map.size() == set.size();
	}
}
