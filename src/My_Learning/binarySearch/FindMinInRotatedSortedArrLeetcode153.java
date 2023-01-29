package My_Learning.binarySearch;

public class FindMinInRotatedSortedArrLeetcode153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMin(int[] nums) {
		int s = 0;
		int e = nums.length - 1;
		while (s < e) {
			int m = s + (e - s) / 2;
			if (nums[m] > nums[e])
				s = m + 1;
			else
				e = m;
		}
		return nums[s];
	}

}
