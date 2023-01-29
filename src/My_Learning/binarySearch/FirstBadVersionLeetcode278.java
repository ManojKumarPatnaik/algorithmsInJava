package My_Learning.binarySearch;

public class FirstBadVersionLeetcode278 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstBadVersion(int n) {
		int start = 1;
		int end = n;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			// boolean ans = isBadVersion(mid); isBadVersion is defined in one of the parent
			// class just here reference
			boolean ans = false; // true;
			if (ans == false) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return start;
	}

}
