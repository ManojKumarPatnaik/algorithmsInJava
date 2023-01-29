package My_Learning.Arrays3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllLonelyNumberLeetcode2150 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> findLonely(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}
		List<Integer> answer = new ArrayList<>();
		for (int num : nums) {
			if (freqMap.get(num) == 1) {
				if (!freqMap.containsKey(num - 1) && !freqMap.containsKey(num + 1)) {
					answer.add(num);
				}
			}
		}
		return answer;
	}

}
