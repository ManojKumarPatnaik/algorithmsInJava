package My_Learning.maths;

import java.util.HashMap;
import java.util.Map;

public class MinimizeTheConfusionOfExamLeetcode2024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxConsecutiveAnswers(String answerKey, int k) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] arr = answerKey.toCharArray();
		int left = 0;
		int max = 0;
		for (int right = 0; right < arr.length; right++) {
			map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
			while (map.getOrDefault('T', 0) > k && map.getOrDefault('F', 0) > k) {
				map.put(arr[left], map.get(arr[left]) - 1);
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return max;
	}
}
