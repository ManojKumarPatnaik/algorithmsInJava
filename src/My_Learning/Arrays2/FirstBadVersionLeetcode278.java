package My_Learning.Arrays2;

public class FirstBadVersionLeetcode278 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	
	public int firstBadVersion(int n) {
		int start = 1;
		int end = n;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			//boolean ans = isBadVersion(mid);
			boolean ans = true;
			if (ans == false) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return start;
	}
}
