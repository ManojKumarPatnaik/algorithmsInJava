package My_Learning.hashing;

import java.util.TreeMap;

public class MyCalander1Leetcode729 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Added Leetcode daily solution
	TreeMap<Integer, Integer> calendar;

	public MyCalander1Leetcode729() {
		calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
		Integer floorKey = calendar.floorKey(start);
		if (floorKey != null && calendar.get(floorKey) > start)
			return false;
		Integer ceilingKey = calendar.ceilingKey(start);
		if (ceilingKey != null && ceilingKey < end)
			return false;

		calendar.put(start, end);
		return true;
	}

}
