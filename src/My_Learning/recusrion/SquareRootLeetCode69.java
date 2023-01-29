package My_Learning.recusrion;

public class SquareRootLeetCode69 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int mySqrt(int x) {
		if (x == 0)
			return 0;

		int left = 1, right = Integer.MAX_VALUE;
		while (true) {
			int mid = left + (right - left) / 2;
			if (mid > x / mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x / (mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}

}
