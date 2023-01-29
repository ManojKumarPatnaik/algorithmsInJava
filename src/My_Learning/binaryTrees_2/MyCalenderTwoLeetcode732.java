package My_Learning.binaryTrees_2;

import java.util.ArrayList;
import java.util.List;

public class MyCalenderTwoLeetcode732 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private List<int[]> books = new ArrayList<>();

	public boolean book(int s, int e) {
		MyCalendar overlaps = new MyCalendar();
		for (int[] b : books)
			if (Math.max(b[0], s) < Math.min(b[1], e)) // overlap exist
				if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e)))
					return false; // overlaps overlapped
		books.add(new int[] { s, e });
		return true;
	}

	private static class MyCalendar {
		List<int[]> books = new ArrayList<>();

		public boolean book(int start, int end) {
			for (int[] b : books)
				if (Math.max(b[0], start) < Math.min(b[1], end))
					return false;
			books.add(new int[] { start, end });
			return true;
		}
	}

}
