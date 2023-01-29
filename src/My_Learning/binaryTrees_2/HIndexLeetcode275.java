package My_Learning.binaryTrees_2;

public class HIndexLeetcode275 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int hIndex(int[] citations) {
		int n = citations.length;

		int s = 1;
		int e = n;

		int ans = 0;

		while (s <= e) {
			int h = s + (e - s) / 2;

			int g = n - h;
			int l = g - 1;

			if (citations[g] >= h && (l <= 0 || citations[l] <= h)) {
				ans = h;
				s = h + 1;
			} else if (g >= 0 && citations[g] < h) {
				e = h - 1;
			} else if (l >= 0 && citations[l] > h) {
				s = h + 1;
			}
		}

		return ans;
	}
}
