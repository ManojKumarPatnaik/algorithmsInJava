package My_Learning.strings;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatchReadLeetcode401 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> readBinaryWatch(int turnedOn) {
		ArrayList<String> ans = new ArrayList<String>();
		for (int hr = 0; hr < 12; hr++) {
			for (int min = 0; min < 60; min++) {
				int h = countOn(hr);
				int m = countOn(min);
				if (h + m == turnedOn) {
					if (min < 10) {
						ans.add(hr + ":" + "0" + min);
					} else {
						ans.add(hr + ":" + min);
					}
				}
			}
		}
		return ans;
	}

	public static int countOn(int n) {
		int count = 0;
		while (n > 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

}
