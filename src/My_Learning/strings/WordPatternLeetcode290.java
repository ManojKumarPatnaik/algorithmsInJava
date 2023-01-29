package My_Learning.strings;

import java.util.HashMap;

public class WordPatternLeetcode290 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean wordPattern(String pattern, String str) {
		String[] arr = str.split(" ");
		HashMap<Character, String> map = new HashMap<Character, String>();
		if (arr.length != pattern.length())
			return false;
		for (int i = 0; i < arr.length; i++) {
			char c = pattern.charAt(i);
			if (map.containsKey(c)) {
				if (!map.get(c).equals(arr[i]))
					return false;
			} else {
				if (map.containsValue(arr[i]))
					return false;
				map.put(c, arr[i]);
			}
		}
		return true;
	}

}
