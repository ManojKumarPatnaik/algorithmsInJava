package My_Learning.strings;

import java.util.HashMap;
import java.util.Map;

public class SumBeautyOfAllSubStringLeetcode1781 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(beautySum("aabcb"));
	}

	public static int beautySum(String s) {

		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				String subStr = s.substring(i, j);
				if (isBeautyString(subStr)) {
					count++;
				}
			}
		}

		return count;
	}

	private static boolean isBeautyString(String s) {
		if (s.length() <= 1)
			return false;
		Map<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		return false;
	}

	public int beautySum1(String s) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			int[] bucket = new int[26];
			for (int j = i; j < s.length(); j++) {
				bucket[s.charAt(j) - 'a']++;
				ans += beauty(bucket);
			}
		}

		return ans;
	}

	private int beauty(int[] bucket) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int i = 0; i < 26; i++) {
			if (bucket[i] == 0)
				continue;
			min = Math.min(min, bucket[i]);
			max = Math.max(max, bucket[i]);
		}
		return max - min;
	}

}
