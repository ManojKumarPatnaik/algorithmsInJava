package My_Learning.maths;

import java.util.HashMap;
import java.util.TreeMap;

public class TImeBaseKeyValueStoreLeetcode981 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// added time based key value store impl
	HashMap<String, TreeMap<Integer, String>> map;

	public TImeBaseKeyValueStoreLeetcode981() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key)) {
			return "";
		}

		Integer time = map.get(key).floorKey(timestamp);
		if (time == null) {
			return "";
		}

		return map.get(key).get(time);
	}

}
