package My_Learning.strings;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharactersToMakeTargetStrLeetcode2287 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int rearrangeCharacters(String s, String target) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (char ch : target.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
			map2.put(ch, 0);
		}
		for (char ch : s.toCharArray()) {
			if (map2.containsKey(ch)) {
				map2.put(ch, map2.get(ch) + 1);
			}
		}
		int min = Integer.MAX_VALUE;
		for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
			min = Math.min(min, entry.getValue() / map.get(entry.getKey()));
		}
		return min;
	}

}
