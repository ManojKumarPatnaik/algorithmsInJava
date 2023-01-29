package My_Learning.binarySearch;

public class FindSmallestGreaterThanTargetLeetcode744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char nextGreatestLetterNaive(char[] a, char x) {
		int n = a.length;

		if (x >= a[n - 1])
			x = a[0];
		else
			x++;

		int lo = 0, hi = n - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == x)
				return a[mid];
			if (a[mid] < x)
				lo = mid + 1;
			else
				hi = mid;
		}
		return a[hi];
	}

	public char nextGreatestLetter(char[] letters, char target) {
		if (letters[0] > target)
			return letters[0];
		if (letters[letters.length - 1] <= target)
			return letters[0];

		return binarySearch(letters, target);
	}

	private char binarySearch(char[] letters, char target) {
		int start = 0;
		int end = letters.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (letters[mid] <= target) {
				start = mid + 1;
			} else if (letters[mid] > target) {
				end = mid - 1;
			}
		}
		return letters[start];
	}

}
