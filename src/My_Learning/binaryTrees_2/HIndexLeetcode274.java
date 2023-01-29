package My_Learning.binaryTrees_2;

import java.util.Arrays;

public class HIndexLeetcode274 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hIndex(int[] citations) {
		if (citations == null || citations.length == 0) {
			return 0;
		}

		Arrays.sort(citations);
		int h = 0;

		for (int i = 0; i < citations.length; i++) {
			if (citations[i] >= citations.length - i) {
				h = citations.length - i;
				break;
			}
		}

		return h;
	}
}
